package actions;

import control.BattleContext;
import domain.Combatant;
import domain.Player;
import items.Inventory;
import ui.GameUI;

import java.util.Scanner;

public class UseItems implements Actions {

    GameUI ui;

    public UseItems(GameUI ui){
        this.ui = ui;
    }

    @Override
    public String actionName(){
        return "UseItems";
    }

    @Override
    public boolean execute(BattleContext ctx, Combatant p){
        Player player = (Player) p;

        Inventory playerInventory = player.getInventory();
        int itemChioce = ui.chooseItem(ctx);
        if(itemChioce != -1){
            playerInventory.useItem(itemChioce-1, ctx, player);
        }
        return false;
    }

}
