package domain;

import effects.StatusEffects;
import items.Inventory;

public abstract class Player extends AbstractCombatant{
    protected Inventory inventory;
    protected int specialCooldown;
    public Player(String name, int hp, int maxHp, int atk, int def, int spd) {
        super(name, hp, atk, def, spd);
        this.inventory = new Inventory();
        this.specialCooldown = 3; // Cooldown 3 turns according to guideline
    }

    public abstract Action chooseAction(BattleContext ctx);

    public int getSpecialCooldown() {
        return specialCooldown;
    }

    public void setSpecialCooldown() {
        if (super.canAct() &&  this.specialCooldown > 0){
            this.specialCooldown--;
        }
    }
}
