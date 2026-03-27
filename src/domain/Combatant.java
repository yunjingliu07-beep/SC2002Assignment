package domain;
import effects.StatusEffects;

public interface Combatant {
    // Methods related to the basic
    String getName(); //Get the name of the combatant
    int getHp(); //Get current Hp
    int getMaxHp(); //Get max Hp
    int getAtk();
    int getDef();
    int getSpd();

    boolean isAlive();
    void takeDamage(int damage);
    void heal(int amount);

    void addStatusEffect(StatusEffects e);
    void removeExpiredEffect();
    void tickEffects();
    boolean canAct();

    String getCurrentAttribute();

}
