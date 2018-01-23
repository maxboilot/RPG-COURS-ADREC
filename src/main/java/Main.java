import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Combien de joueurs : ");
        int nbJoueurs = scan.nextInt();


        ArrayList<Player> listJoueurs = new ArrayList<Player>();

        for (int i = 0; i < nbJoueurs; i++) {
            System.out.print("Attribuer un nom au joueur " + (i+1) + " : ");
            String namePlayer = scan.nextLine();
            scan.nextLine();

            boolean invalide = true;

            do {
                System.out.print("Attribuer une classe au joueur (1 : guerrier, 2 : mage, 3: soigneur)");
                int classePlayer = scan.nextInt();

                if (classePlayer < 1 || classePlayer > 3) {
                    System.out.println("Recommencer");
                    continue;
                }
                invalide = false;
            } while (invalide);

            System.out.print("Le joueur " + (i+1) + " est enregistré.");
            listJoueurs.add(new Player(scan.nextLine(), scan.nextInt()));

        }

        Monster Monstre = new Monster();

        int numeroDuJoueur = 0;
        Player lastPlayer = new Player(scan.nextLine(), scan.nextInt());
        do {
            Player aQuiLeTour = listJoueurs.get(numeroDuJoueur);

            System.out.println("Pour info : Le montre à encore " + Monstre.getPvs() + " point de vie !");
            System.out.println("Pour info : " + Player.getName() + " à encore " + Player.getPvs() + " point de vie.");
            System.out.println("À qui le tour : " + aQuiLeTour.getName());

            if (Player.getClasse() == 1) {
                aQuiLeTour.attackMonster(Monstre);
            } else if (Player.getClasse() == 2) {
                boolean invalide = true;
                do {
                    System.out.print("Que souhaitez vous faire? (1 : attaquer, 2 : vous soigner)");
                    int choixMage = scan.nextInt();

                    if (choixMage < 1 || choixMage > 2) {
                        System.out.println("Recommencer");
                        continue;
                    }
                    invalide = false;

                    if (choixMage == 1) {
                        aQuiLeTour.attackMonster(Monstre);
                    } else {
                        Mage.heal(Mage.getPvs());
                    }

                } while (invalide);

            } else {
                boolean invalide = true;
                do {
                    System.out.print("Que souhaitez vous faire? (1 : attaquer, 2 : soigner un joueur)");
                    int choixSoigneur = scan.nextInt();

                    if (choixSoigneur < 1 || choixSoigneur > 2) {
                        System.out.println("Recommencer");
                        continue;
                    }
                    invalide = false;

                    if (choixSoigneur == 1) {
                        aQuiLeTour.attackMonster(Monstre);
                    } else {

                        do {
                            System.out.print("Quel joueur souhaitez vous soigner? (entrez le nom du joueur)");
                            String choixSoigneur2 = scan.nextLine();

                            Soigneur.care(choixSoigneur2);

                            if (choixSoigneur2 == null) {
                                System.out.println("Recommencer");
                                continue;
                            }
                            invalide = false;
                        } while (invalide);

                    }

                } while (invalide);
            }

            Monstre.attackPlayer(lastPlayer);

            numeroDuJoueur++;

            if (numeroDuJoueur >= listJoueurs.size()) {
                numeroDuJoueur = 0;
            }

            lastPlayer = aQuiLeTour;
        } while (Player.getPvs()!= 0);

        System.out.println(lastPlayer.getName() + " KO !");

        for (int i = 0; i < nbJoueurs; i++) {
            if (Player.getPvs() == 0){
                System.out.print("Tous les joueurs sont à 0 points de vie... La partie est perdue!");
            }
        }

        if (Monstre.getPvs() == 0){
            System.out.print("Félicitation! Vous avez vaincu le monstre");
            System.out.println("Pour info : " + Player.getName() + " à encore " + Player.getPvs() + " point de vie.");
        }
    }
}
