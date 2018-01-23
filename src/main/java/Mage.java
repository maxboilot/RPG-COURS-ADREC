public class Mage extends Player {

    public Mage() {
        super("Mage " , 2);
    }

    private static int pvs = 100;

    private int degats = 20;

    public static void heal(int pvs) {
        pvs = pvs + 5;
    }
}

