package ui;

import control.BattleContext;
import control.Difficulty;
import domain.Combatant;

import java.util.List;

public interface GameUI {
    int choosePlayer();
    int choosePlayerActions();
    int chooseTarget(BattleContext ctx);
    int[] chooseInitialItems();
    void showEnemies(BattleContext ctx);
    void showBattleResult(boolean victory);
    void showBattleStart(Difficulty difficulty);
}
