package domain;

public abstract class Enemy extends AbstractCombatant {
    public Enemy(String name, int hp, int atk, int def, int spd) {
        super(name, hp, atk, def, spd);
    }
}
