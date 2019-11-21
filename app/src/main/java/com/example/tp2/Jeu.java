package com.example.tp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Jeu{


    public int celluleClicked;
    public ArrayList<Integer> listeCoupsX, listeCoupsY;
    public ArrayList<Integer> listeCoups;

    ArrayList<ArrayList<Integer>> tabCombinaisons = new ArrayList<ArrayList<Integer>>();

    public int nbreDeCoups;
    public Jeu(){

    }


    public void initialise() {
        listeCoupsX = new ArrayList<Integer>();
        listeCoupsY = new ArrayList<Integer>();
        listeCoups = new ArrayList<Integer>();
        nbreDeCoups = 0;

        ArrayList<Integer> comb1 = new ArrayList<Integer>(Arrays.asList(0,1,2));
        tabCombinaisons.add(comb1);
        ArrayList<Integer> comb2 = new ArrayList<Integer>(Arrays.asList(0,4,8));
        tabCombinaisons.add(comb2);
        ArrayList<Integer> comb3 = new ArrayList<Integer>(Arrays.asList(0,3,6));
        tabCombinaisons.add(comb3);
        ArrayList<Integer> comb4 = new ArrayList<Integer>(Arrays.asList(6,7,8));
        tabCombinaisons.add(comb4);
        ArrayList<Integer> comb5 = new ArrayList<Integer>(Arrays.asList(6,4,2));
        tabCombinaisons.add(comb5);
        ArrayList<Integer> comb6 = new ArrayList<Integer>(Arrays.asList(3,4,5));
        tabCombinaisons.add(comb6);
        ArrayList<Integer> comb7 = new ArrayList<Integer>(Arrays.asList(1,4,7));
        tabCombinaisons.add(comb7);
        ArrayList<Integer> comb8 = new ArrayList<Integer>(Arrays.asList(2,5,8));
        tabCombinaisons.add(comb8);
    }


    public void setX(int cellule) {
        checkForWin();
        isPartieNulle();
        this.celluleClicked = cellule;
        listeCoups.add(cellule);
        listeCoupsX.add(cellule);
        nbreDeCoups++;

    }


    public int getO() {
        System.out.println("nbre de coup" + nbreDeCoups);

        //Coup de bot a  tour 1,3,5,7,9

        int[] n;
        int m;
        Random random = new Random(); //O=bot
        if (nbreDeCoups == 1) {
            if (listeCoups.get(0) == 4) {
                nbreDeCoups++;
                n = new int[]{0, 2, 6, 8};
                m = (n[random.nextInt(n.length)]);
                listeCoups.add(m);
                listeCoupsY.add(m);
                System.out.println("Coup numero: " + nbreDeCoups + " Liste des Coups" + listeCoups);
                return m;
            }
            if (listeCoups.get(0) != 4) {
                nbreDeCoups++;
                listeCoups.add(4);
                listeCoupsY.add(4);
                System.out.println("Coup numero: " + nbreDeCoups + " Liste des Coups" + listeCoups);
                return 4;
            }
        }

        if (nbreDeCoups == 3) {
            if (listeCoups.get(0) == 4) {
                //Cas ou humain a 4+{0,1,2,3,5,6,7,8}
                if (listeCoups.get(2) == (0) && listeCoups.get(1) != 4 && !listeCoups.contains(8)) {
                    nbreDeCoups++;
                    listeCoups.add(8);
                    System.out.println("X:4,0 \nO: [!] 4");
                    listeCoupsY.add(8);
                    return 8;
                }
                if (listeCoups.get(2) == 1 && listeCoups.get(1) != 4 && !listeCoups.contains(7)) {
                    nbreDeCoups++;
                    listeCoups.add(7);
                    System.out.println("X:4,1 \nO: [!] 4");
                    listeCoupsY.add(7);
                    return 7;
                }
                if (listeCoups.get(2) == (2) && listeCoups.get(1) != 4 && !listeCoups.contains(6)) {
                    nbreDeCoups++;
                    listeCoups.add(6);
                    System.out.println("X:4,2 \nO: [!] 4");
                    listeCoupsY.add(6);
                    return 6;
                }
                if (listeCoups.get(2) == 3 && listeCoups.get(1) != 4 && !listeCoups.contains(5)) {
                    nbreDeCoups++;
                    listeCoups.add(5);
                    System.out.println("X:4,3 \nO: [!] 4");
                    listeCoupsY.add(5);
                    return 5;
                }
                if (listeCoups.get(2) == (5) && listeCoups.get(1) != 4 && !listeCoups.contains(3)) {
                    nbreDeCoups++;
                    listeCoups.add(3);
                    System.out.println("X:4,5 \nO: [!] 4");
                    listeCoupsY.add(3);
                    return 3;
                }
                if (listeCoups.get(2) == (6) && listeCoups.get(1) != 4 && !listeCoups.contains(2)) {
                    nbreDeCoups++;
                    listeCoups.add(2);
                    System.out.println("X:4,6 \nO: [!] 4");
                    listeCoupsY.add(2);
                    return 2;
                }
                if (listeCoups.get(2) == (7) && listeCoups.get(1) != 4 && !listeCoups.contains(1)) {
                    nbreDeCoups++;
                    listeCoups.add(1);
                    System.out.println("X:4,7 \nO: [!] 4");
                    listeCoupsY.add(1);
                    return 1;
                }
                if (listeCoups.get(2) == (8) && listeCoups.get(1) != 4 && !listeCoups.contains(0)) {
                    nbreDeCoups++;
                    listeCoups.add(0);
                    System.out.println("X:4,8 \nO: [!] 4");
                    listeCoupsY.add(0);
                    return 0;
                }
                //Cas ou humain a 2 coins mais pas 4 //[!] need plus de cas
                if (listeCoups.get(2) == (8) && listeCoups.get(1) == (0) && !listeCoups.contains(1) || !listeCoups.contains(3) || !listeCoups.contains(5) || !listeCoups.contains(7)) {
                    n = new int[]{1, 3, 5, 7};
                    m = (n[random.nextInt(n.length)]);
                    listeCoups.add(m);
                    System.out.println("X:4,0 \nO: 8");
                    listeCoupsY.add(m);
                    return m;
                } //(1,3,5 ou 7)
                if (listeCoups.get(2) == (0) && listeCoups.get(1) == (8) && !listeCoups.contains(1) || !listeCoups.contains(3) || !listeCoups.contains(5) || !listeCoups.contains(7)) {
                    n = new int[]{1, 3, 5, 7};
                    m = (n[random.nextInt(n.length)]);
                    listeCoups.add(m);
                    System.out.println("X:4,8 \nO: 0");
                    listeCoupsY.add(m);
                    return m;
                } //(1,3,5 ou 7)
                if (listeCoups.get(2) == (6) && listeCoups.get(1) == (2) && !listeCoups.contains(1) || !listeCoups.contains(3) || !listeCoups.contains(5) || !listeCoups.contains(7)) {
                    n = new int[]{1, 3, 5, 7};
                    m = (n[random.nextInt(n.length)]);
                    listeCoups.add(m);
                    System.out.println("X:4,6 \nO: 2");
                    listeCoupsY.add(m);
                    return m;
                }
                if (listeCoups.get(2) == (2) && listeCoups.get(1) == (6) && !listeCoups.contains(1) || !listeCoups.contains(3) || !listeCoups.contains(5) || !listeCoups.contains(7)) {
                    n = new int[]{1, 3, 5, 7};
                    m = (n[random.nextInt(n.length)]);
                    listeCoups.add(m);
                    System.out.println("X:4,2 \nO: 6");
                    listeCoupsY.add(m);
                    return m;
                }
            }


//Cas pour les lignes/colonnes (entourent le 4 Bot)
            if (listeCoups.get(1) == 4) {
                if (listeCoups.get(0) == 0 || listeCoups.get(2) == 0) {
                    if (listeCoups.get(0) == 1 || listeCoups.get(2) == 1 && !listeCoups.contains(2)) {
                        nbreDeCoups++;
                        listeCoups.add(2);
                        System.out.println("X:0,1 \nO: 4");
                        listeCoupsY.add(2);
                        return 2;
                    }
                    if (listeCoups.get(0) == 2 || listeCoups.get(2) == 2 && !listeCoups.contains(1)) {//ADDENDUM
                        nbreDeCoups++;
                        listeCoups.add(1);
                        System.out.println("X:0,1 \nO: 4");
                        listeCoupsY.add(1);
                        return 1;
                    }
                    if (listeCoups.get(0) == 3 || listeCoups.get(2) == 3 && !listeCoups.contains(6)) {
                        nbreDeCoups++;
                        listeCoups.add(6);
                        System.out.println("X:0,3 \nO: 4");
                        listeCoupsY.add(6);
                        return 6;
                    }
                    if (listeCoups.get(0) == 6 || listeCoups.get(2) == 6 && !listeCoups.contains(3)) {//ADDENDUM
                        nbreDeCoups++;
                        listeCoups.add(3);
                        System.out.println("X:0,6 \nO: 4");
                        listeCoupsY.add(3);
                        return 3;
                    }

                }
                if (listeCoups.get(0) == 2 || listeCoups.get(2) == 2) {
                    if (listeCoups.get(0) == 1 || listeCoups.get(2) == 1 && !listeCoups.contains(0)) {
                        nbreDeCoups++;
                        listeCoups.add(0);
                        System.out.println("X:2,1 \nO: 4");
                        listeCoupsY.add(0);
                        return 0;
                    }
                    if (listeCoups.get(0) == 0 || listeCoups.get(2) == 0 && !listeCoups.contains(1)) {//ADDENDUM
                        nbreDeCoups++;
                        listeCoups.add(1);
                        System.out.println("X:2,0 \nO: 4");
                        listeCoupsY.add(1);
                        return 1;
                    }
                    if (listeCoups.get(0) == 5 || listeCoups.get(2) == 5 && !listeCoups.contains(8)) {
                        nbreDeCoups++;
                        listeCoups.add(8);
                        System.out.println("X:2,5 \nO: 4");
                        listeCoupsY.add(8);
                        return 8;
                    }
                    if (listeCoups.get(0) == 8 || listeCoups.get(2) == 8 && !listeCoups.contains(8)) {//ADDENDUM
                        nbreDeCoups++;
                        listeCoups.add(5);
                        System.out.println("X:2,8 \nO: 4");
                        listeCoupsY.add(5);
                        return 5;
                    }
                }
                if (listeCoups.get(0) == 6 || listeCoups.get(2) == 6) {
                    if (listeCoups.get(0) == 3 || listeCoups.get(2) == 3 && !listeCoups.contains(0)) {
                        nbreDeCoups++;
                        listeCoups.add(0);
                        System.out.println("X:3,6 \nO: 4");
                        listeCoupsY.add(0);
                        return 0;
                    }
                    if (listeCoups.get(0) == 0 || listeCoups.get(2) == 0 && !listeCoups.contains(3)) {//ADDENDUM
                        nbreDeCoups++;
                        listeCoups.add(3);
                        System.out.println("X:0,6 \nO: 4");
                        listeCoupsY.add(3);
                        return 3;
                    }
                    if (listeCoups.get(0) == 7 || listeCoups.get(2) == 7 && !listeCoups.contains(8)) {
                        nbreDeCoups++;
                        listeCoups.add(8);
                        System.out.println("X:6,7 \nO: 4");
                        listeCoupsY.add(8);
                        return 8;
                    }
                    if (listeCoups.get(0) == 8 || listeCoups.get(2) == 8 && !listeCoups.contains(7)) {
                        nbreDeCoups++;
                        listeCoups.add(7);
                        System.out.println("X:6,8 \nO: 4");
                        listeCoupsY.add(7);
                        return 7;
                    }
                }
                if (listeCoups.get(0) == 8 || listeCoups.get(2) == 8) {
                    if (listeCoups.get(0) == 5 || listeCoups.get(2) == 5 && !listeCoups.contains(2)) {
                        nbreDeCoups++;
                        listeCoups.add(2);
                        System.out.println("X:5,8 \nO: 4");
                        listeCoupsY.add(2);
                        return 2;
                    }
                    if (listeCoups.get(0) == 2 || listeCoups.get(2) == 2 && !listeCoups.contains(2)) {
                        nbreDeCoups++;
                        listeCoups.add(5);
                        System.out.println("X:2,8 \nO: 4");
                        listeCoupsY.add(5);
                        return 5;
                    }
                    if (listeCoups.get(0) == 7 || listeCoups.get(2) == 7 && !listeCoups.contains(6)) {
                        nbreDeCoups++;
                        listeCoups.add(6);
                        System.out.println("X:7,8 \nO: 4");
                        listeCoupsY.add(6);
                        return 6;
                    }
                    if (listeCoups.get(0) == 6 || listeCoups.get(2) == 6 && !listeCoups.contains(6)) {
                        nbreDeCoups++;
                        listeCoups.add(6);
                        System.out.println("X:6,8 \nO: 4");
                        listeCoupsY.add(7);
                        return 7;
                    }
                }
                //Cas ou on a 2 cas adjacentes a un coin
                if (listeCoups.get(0) == 1 || listeCoups.get(2) == 1) {
                    if (listeCoups.get(0) == 3 || listeCoups.get(2) == 3 && !listeCoups.contains(0)) {
                        nbreDeCoups++;
                        listeCoups.add(0);
                        System.out.println("X:1,3 \nO: 4");
                        listeCoupsY.add(0);
                        return 0;
                    }

                    if (listeCoups.get(0) == 5 || listeCoups.get(2) == 5 && !listeCoups.contains(2)) {
                        nbreDeCoups++;
                        listeCoups.add(2);
                        System.out.println("X:1,5 \nO: 4");
                        listeCoupsY.add(2);
                        return 2;
                    }
                }
                if (listeCoups.get(0) == 7 || listeCoups.get(2) == 7 ) {
                    if (listeCoups.get(0) == 3 || listeCoups.get(2) == 3 && !listeCoups.contains(6) ) {
                        nbreDeCoups++;
                        listeCoups.add(6);
                        System.out.println("X:3,7 \nO: 4");
                        listeCoupsY.add(6);
                        return 6;
                    }
                    if (listeCoups.get(0) == 5 || listeCoups.get(2) == 5 && !listeCoups.contains(8)) {
                        nbreDeCoups++;
                        listeCoups.add(8);
                        System.out.println("X:5,7 \nO: 4");
                        listeCoupsY.add(8);
                        return 8;
                    }
                }
            }
        }

        nbreDeCoups++;
        //if(nbreDeCoups>3){System.out.println("Erreur critique sur l'algorithme");}
        if (doeswin(listeCoupsX, listeCoupsY, tabCombinaisons).size()==0 && nbreDeCoups>3) {

            ArrayList <Integer> caselibre;
            caselibre = new ArrayList<Integer>();
            caselibre.add(0);
            caselibre.add(1);
            caselibre.add(2);
            caselibre.add(3);
            caselibre.add(4);
            caselibre.add(5);
            caselibre.add(6);
            caselibre.add(7);
            caselibre.add(8);
            caselibre.removeAll(listeCoups);

            if(caselibre.size()==0){isPartieNulle(); }
            else if (caselibre.size()!=0){
                System.out.println(caselibre);
                m = (caselibre.get(random.nextInt(caselibre.size())));
                listeCoups.add(m);
                listeCoupsY.add(m);
                nbreDeCoups++;
                System.out.println("RANDOM ="+ m);
                return m;
            }
        }else if (doeswin(listeCoupsX, listeCoupsY, tabCombinaisons).size()!=0 && nbreDeCoups>3){
            for(int i=0;i<doeswin(listeCoupsX, listeCoupsY, tabCombinaisons).size();i++){
                //System.out.println(doeswin(listeCoupsX, listeCoupsY, tabCombinaisons).get(i));
                if(listeCoups.contains(doeswin(listeCoupsX, listeCoupsY, tabCombinaisons).get(i))) {
                    continue;
                }
                listeCoupsY.add(doeswin(listeCoupsX, listeCoupsY, tabCombinaisons).get(i));
                break;
            }
            nbreDeCoups++;
            listeCoups.add(listeCoupsY.get(listeCoupsY.size()-1));
            listeCoupsY.add(listeCoupsY.get(listeCoupsY.size()-1));
            return listeCoupsY.get(listeCoupsY.size()-1);

        }
        isPartieNulle();
        return 9;
    }

    public void checkForWin(){
        for (ArrayList<Integer> combinaisons: tabCombinaisons
        ) {
            int combHaveX = 0;
            int combHaveY = 0;
            if(nbreDeCoups >= 5){
                for (int i = 0; i < 3; i++) {
                    if (combHaveX != 3 || combHaveY != 3) {
                        if(listeCoupsX.contains(combinaisons.get(i))){
                            combHaveX++;
                        }else if(listeCoupsY.contains(combinaisons.get(i))){
                            combHaveY++;
                        }
                    }else if(combHaveX == 3){
                        System.out.println("X a " + combinaisons);
                    }else  if(combHaveY == 3){
                        System.out.println("Y a " + combinaisons);
                    }

                }

            }




        }
    }

    public  ArrayList<Integer> doeswin(ArrayList<Integer> joueur1, ArrayList<Integer> joueur2, ArrayList<ArrayList<Integer>> combiwin)
    {
        ArrayList<Integer> win = new ArrayList<Integer>();
        ArrayList<Integer> tempo = new ArrayList<Integer>();
        ArrayList<Integer> tempx = new ArrayList<Integer>();
        ArrayList<Integer> tempo2 = new ArrayList<Integer>();
        boolean priorite=true;
        String joueur="";
        for(int count=0;count<combiwin.size();count++) {
            //System.out.println("target:"+combiwin.get(count));
            tempo = (ArrayList<Integer>) joueur1.clone();
            tempx = (ArrayList<Integer>) joueur2.clone();
            tempo2 = (ArrayList<Integer>) combiwin.get(count).clone();
            tempo.retainAll(combiwin.get(count));
            priorite=true;//RESET de la priorité si elle a été modifié dans une des boucle

            if(tempo.size()>=2){ System.out.println(count+" :tempO: "+tempo+" Combinaison:"+combiwin.get(count));}//Liste les combinaisons que X possede si il ne manque que 1 element

            if (tempo.size()==0 && joueur1.contains(tempo2.get(0))==false && joueur1.contains(tempo2.get(1))==false){//SI X ne peut pas faire de combinaison ET il n'y a pas d'element de X sur la ligne(possible de gagner pour O[BOT])
                tempo2.removeAll(tempx);//On regarde les elements libre(ni X, ni O) de la combinaison

                System.out.println("\t"+count+" :tempX: "+tempx+" Combinaison:"+combiwin.get(count)); //On donne les elements libre (1 ou 2)
                if(tempo2.size()==1){ //SI il ne reste que un element pour que O[BOT] gagne
                    System.out.println("\t O A 2/3 MANQUE [" + tempo2.get(0) +"]");
                    if (win.size()==0)win.add(tempo2.get(0));
                    if (win.size()!=0)win.set(0,tempo2.get(0));
                    priorite=false;//On etablit une priorité sur O[BOT] par rapport a X, car X ne jouera que aprés O[BOT]
                    //o gagne
                }
                if(tempo2.size()==2 && priorite==false) { // SI on a 2 elements(on gagne potentiellement dans 2 tours)
                    System.out.println("\t O A 1/3 MANQUE [" + tempo2.get(0) +","+tempo2.get(1) +"]");
                    if (joueur2.contains(tempo2.get(0))==false || joueur2.contains(tempo2.get(1))==false ){
                        win.add(tempo2.get(1)); //On rajoute le dernier, MAIS pourrait trés bien etre l'element temp02 [0]
                    }
                }
            }
            if(tempo.size()==2 && priorite==true) { //SI O[BOT] ne peut pas gagner en 2 tours, on ne peut qu'eviter de perdre
                tempo2.removeAll(tempo);
                if(joueur2.contains(tempo2.get(0))==false) {
                    System.out.println("\t X A 2/3 MANQUE [" + tempo2.get(0) + "]");
                    if (win.size()==0)win.add(tempo2.get(0));
                    //if (win.size()!=0)win.set(0,tempo2.get(0));
                }
            }
            else if(tempo.size()==3) {//x gagne
                win.add(42);
            }
        }
        System.out.println(win);
        return win;
    }

    public boolean gagnant(String joueur, int[] pos) {


        return false;
    }

    public boolean isPartieNulle() {
        ArrayList <Integer> caselibre;
        caselibre = new ArrayList<Integer>();
        caselibre.add(0);
        caselibre.add(1);
        caselibre.add(2);
        caselibre.add(3);
        caselibre.add(4);
        caselibre.add(5);
        caselibre.add(6);
        caselibre.add(7);
        caselibre.add(8);
        caselibre.removeAll(listeCoups);
        if(caselibre.size()==0){
            System.out.println("La partie est nulle");
            return true; }

        return false;
    }


    public void testDebug(int[] indicesCoups) {

    }


}
