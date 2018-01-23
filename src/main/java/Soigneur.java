public class Soigneur extends Player {

    public Soigneur(){
        super("Soigneur ", 3);
    }

    private int pvs = 50;

    private int degats = 5;

    public static void care(String player) {
        Player.ajouterPvs(30);
    }
}
