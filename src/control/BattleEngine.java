package control;

import actions.*;
import domain.Combatant;
import domain.Player;
import domain.Warrior;
import domain.Wizard;
import ui.GameUI;

import java.util.ArrayList;
import java.util.List;

public class BattleEngine {
    private final GameUI gameUI;

    public BattleEngine(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    public BattleOutcome runGame(BattleContext ctx, Difficulty difficulty) {
        gameUI.showBattleStart(difficulty);
        Player player = ctx.getPlayer();

        while (player.isAlive()) {
            ctx.spawnBackupEnemies();

            //If player wins
            if (ctx.isWaveCleared() && ctx.getBackupEnemies().isEmpty()) {
                gameUI.showBattleResult(true);
                return BattleOutcome.WIN;
            }

            //Show enemies
            gameUI.showEnemies(ctx);

            //Determine turn order
            List<Combatant> order = new ArrayList<>();
            TurnOrderStrategy strategy = new SpeedBasedTurnOrderStrategy();
            order = strategy.determineOrder(ctx);

            //Start to loop through the order for combat
            for (Combatant combatant : order) {
                //Player's turn
                if (combatant instanceof Player) {

                }
            }
        }
    }
    void playersTurn(Player player, BattleContext ctx) {
        int choice = gameUI.choosePlayerActions();
        switch (choice) {
            case 1: // 1 for basic attack
                int target = gameUI.chooseTarget(ctx);
                BasicAttackAction ATKaction = new BasicAttackAction(ctx.getAliveEnemies().get(target-1));
                ATKaction.execute(ctx, player);
                break;

            case 2: // 2 for defend
                DefendAction DEFaction = new DefendAction();
                DEFaction.execute(ctx, player);
                break;

            case 3: // 3 for useItem
                UseItems USEaction = new UseItems(gameUI);
                USEaction.execute(ctx, player);
                break;

            case 4: // 4 for special skill
                // Check player type to identify the skill to use
                if (player instanceof Warrior) {
                    target = gameUI.chooseTarget(ctx);
                    ShieldBash SBaction = new ShieldBash(ctx.getAliveEnemies().get(target-1), true);
                    SBaction.execute(ctx, player);
                }
                else if  (player instanceof Wizard) {
                    target = gameUI.chooseTarget(ctx);
                    ArcaneBlast ABaction = new ArcaneBlast(true);
                    ABaction.execute(ctx, player);
                }
        }
    }
}
