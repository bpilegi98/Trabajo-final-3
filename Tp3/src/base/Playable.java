package base;

import inventory.Inventory;
import java.util.Scanner;

/**
 * La clase playable es la que se puede usar para jugar y cuenta con atributos
 * unicos de su clase como la experiencia y las stas de base, las cuales se usan
 * para que suba de nivel
 *
 * @author Juan
 */
public class Playable extends Character {

    private int xp;
    private int lvl;
    private int xpMax;// variable para saber a que punto de xp se sube de lvl
    private Inventory inventory;
    // implementar subida de nivel, e inventario y dinero
    private int hpBase;
    private int manaBase;
    private int dmgBase;
    private int dmgMaxBase;
    private int accBase;
    private int dodgeBase;

    private final double XP_MOD = 2.2;// indica cuanto mas va a costar de exp el siguiente nivel
    private final int MAX_LVL = 5;// nivel maximo

    public Playable() {
        super();
        xp = 0;
        lvl = 0;
        xpMax = 0;
    }

    public Playable(int hp, int mana, int dmg, int maxDmg, int acc, int dodge, int crit, int def, int xp, int lvl,
            int xpMax, String name, int id) {
        super(hp, mana, dmg, maxDmg, acc, dodge, crit, def, name, id);
        this.xp = xp;
        this.lvl = lvl;
        this.xpMax = xpMax;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getXpMax() {
        return xpMax;
    }

    public void setXpMax(int xpMax) {
        this.xpMax = xpMax;
    }

    public int getHpBase() {
        return hpBase;
    }

    public void setHpBase(int hpBase) {
        this.hpBase = hpBase;
    }

    public int getManaBase() {
        return manaBase;
    }

    public void setManaBase(int manaBase) {
        this.manaBase = manaBase;
    }

    public int getDmgBase() {
        return dmgBase;
    }

    public void setDmgBase(int dmgBase) {
        this.dmgBase = dmgBase;
    }

    public int getDmgMaxBase() {
        return dmgMaxBase;
    }

    public void setDmgMaxBase(int dmgMaxBase) {
        this.dmgMaxBase = dmgMaxBase;
    }

    public int getAccBase() {
        return accBase;
    }

    public void setAccBase(int accBase) {
        this.accBase = accBase;
    }

    public int getDodgeBase() {
        return dodgeBase;
    }

    public void setDodgeBase(int dodgeBase) {
        this.dodgeBase = dodgeBase;
    }

    /**
     * Muestra la barra de experiencia, se usa en el tostring de playable
     *
     * @return
     */
    public String showXpState() {
        return getXp() + "/" + getXpMax() + "\n";
    }

    /**
     * Funcion que se encarga de subir el nivel del personaje, controlando si ya
     * no se encuentra en el nivel maximo
     *
     * @return
     */
    public String lvlUp() {
        StringBuilder builder = new StringBuilder();
        System.out.println(this.lvl);
        if (this.lvl < MAX_LVL) {

            double nextXp = (double) xpMax * XP_MOD;
            // xp = xpMax;
            xpMax = (int) nextXp;
            this.statsUp();
        } else {
            Messages m = new Messages();
            // aca se muestra el mensaje de que no puede subir de lvl aun y se muestra el
            // mensaje de la funcion showXpState para que el jugador tenga una referencia

            builder.append(m.lvlError());
            showXpState();
        }
        return builder.toString();

    }

    /**
     * Sube las estadisticas del personaje en base a sus estadisticas base(usado
     * en la subida de nivel) y ademas sube su nivel en 1
     */
    public void statsUp() {
        setMaxHp(getMaxHp() + hpBase);
        setHp(getMaxHp());
        setMaxMana(getMaxMana() + manaBase);
        setMana(getMaxMana());
        setDmg(getDmg() + dmgBase);
        setMaxDmg(getMaxDmg() + dmgMaxBase);
        setAcc(getAcc() + accBase);
        setDodge(getDodge() + dodgeBase);
        setLvl(getLvl() + 1);
    }

    /**
     * Funcion que recibe un int de experiencia y la suma al total, haciendo los
     * controles de si el personaje sube o no de nivel
     *
     * @param xpDrop
     * @return
     */
    public String addXp(int xpDrop) {
        StringBuilder builder = new StringBuilder();
        xp += xpDrop;
        if (xp > xpMax) {
            builder.append(this.lvlUp());
        }
        return builder.toString();
    }
}
