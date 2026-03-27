package items;

import control.BattleContext;
import domain.Combatant;
import domain.Player;

public class SmokeBomb implements Items{
    @Override
    public String getName(){
        return "Smoke Bomb";
    }

    @Override
    public void apply(BattleContext ctx, Player c){
        ctx.activateSmokeBomb();
    }
}
