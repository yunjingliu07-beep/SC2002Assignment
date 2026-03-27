package ui;

import domain.Combatant;

import java.util.List;

public interface GameUI {
    int choosePlayer();
    int choosePlayerActions();
    int chooseTarget();
    int chooseItems();
    void showEnemies();
    void showBattleResult(boolean victory);
}
