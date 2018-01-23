import java.util.Random;

public class Monster {

    Random rnd = new Random();

    private String name = "Monster";

    private int pvs;

    private int degats;

    public int getPvs(){

        this.pvs= 50 + rnd.nextInt(301);
        return this.pvs;
    }

    public void enleverPvs(int nb){
        this.pvs = this.pvs - nb;
    }

    public int getDegats(){

        this.degats = 5 + rnd.nextInt(21);
        return this.degats;
    }

    public void attackPlayer(Player player){
        Player.enleverPvs(degats);
    }

}
