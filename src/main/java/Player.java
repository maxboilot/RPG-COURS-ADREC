public class Player {

    private static String name;

    private static int classe;

    private static int pvs;

    private int degats;


    public Player(String name, int classe) {
        this.name = name;
        this.classe = classe;
    }

    public static String getName() {
        return name;
    }

    public static int getClasse() {
        return classe;
    }

    public static int getPvs(){
        return pvs;
    }

    static void ajouterPvs(int nb){
        pvs = pvs + nb;
    }

    static void enleverPvs(int nb){
         pvs = pvs - nb;
    }

    public int getDegats(){
        return this.degats;
    }

    public void attackMonster(Monster Monstre){
        Monster Monster = new Monster();
        Monster.enleverPvs(degats);
    }

}
