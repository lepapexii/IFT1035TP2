package com.example.tp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.green;

public class GrilleDeJeu extends AppCompatActivity {
    Jeu jeu;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,newGame;
    TextView result, titre;
    Button[] tab;
    int[] tabGagner;
    Boolean fini;
    int nombreDeCoups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jeu = new Jeu();
        tab = new Button[9];
        tab[0] = findViewById(R.id.b0);
        tab[1] = findViewById(R.id.b1);
        tab[2] = findViewById(R.id.b2);
        tab[3] = findViewById(R.id.b3);
        tab[4] = findViewById(R.id.b4);
        tab[5] = findViewById(R.id.b5);
        tab[6] = findViewById(R.id.b6);
        tab[7] = findViewById(R.id.b7);
        tab[8] = findViewById(R.id.b8);
        b0 = tab[0];
        b1 = tab[1];
        b2 = tab[2];
        b3 = tab[3];
        b4 = tab[4];
        b5 = tab[5];
        b6 = tab[6];
        b7 = tab[7];
        b8 = tab[8];
        newGame = findViewById(R.id.newGame);
        result = findViewById(R.id.result);
        titre = findViewById(R.id.titre);
        initialiser();
        jeu.initialise();
        nombreDeCoups = jeu.nbreDeCoups;
    }

    public GrilleDeJeu(){

    }

    public void initialiser(){
        for (int i=0; i<tab.length; i++ ){
            //tab[i].setBackgroundColor(GREEN);
            tab[i].setText("");

        }
        jeu.initialise();
        tabGagner = new int[3];
        for(int j=0; j<3; j++){
         tabGagner[j] = -1;
        }
        //tabGagner = jeu.tabCombinaisons;
        fini = false;
        result.setText("");
    }

    public void actionPerformed(View v){

        Button b = (Button)v;

        int aff = v.getId();
        if(b0.getId() == aff && b0.getText() == ""){
            b0.setText("x");
            boutonClique(0);


        }
        if(b1.getId() == aff && b1.getText() == ""){
            b1.setText("x");
            boutonClique(1);

        }
        if(b2.getId() == aff && b2.getText() == ""){
            b2.setText("x");
            boutonClique(2);

        }
        if(b3.getId() == aff && b3.getText() == ""){
            b3.setText("x");
            boutonClique(3);

        }
        if(b4.getId() == aff && b4.getText() == ""){
            b4.setText("x");
            boutonClique(4);

        }
        if(b5.getId() == aff && b5.getText() == ""){
            b5.setText("x");
            boutonClique(5);
        }
        if(b6.getId() == aff && b6.getText() == ""){
            b6.setText("x");
            boutonClique(6);
        }
        if(b7.getId() == aff && b7.getText() == ""){
            b7.setText("x");
            boutonClique(7);
        }
        if(b8.getId() == aff && b8.getText() == ""){
            b8.setText("x");
            boutonClique(8);
        }



    }

    private void boutonClique(int i) {
        if(fini)
            return;
        jeu.setX(i);				//Transmettre l'index du choix X au jeu
        if(jeu.gagnant("X",tabGagner)){	//Victoire de X?
            fini = true;
            marque(tabGagner);
            result.setText("X gagne!");
        }
        else
        if(!jeu.isPartieNulle()){				 // Si pas victoire de X et pas nulle
            int cellule = jeu.getO(); // Demande le choix pour O
            tab[cellule].setText("O");		 // Modifier l'affichage sur la grille pour
            // réfléter le choix de O
            if(jeu.gagnant("O",tabGagner)){	 // O gagne?
                fini = true;
                marque(tabGagner);
                result.setText("O gagne!");
            }
        }
        else	//Partie nulle
        {
            fini = true;
            result.setText("Partie nulle!");
        }
    }

    private void marque(int[] tabGagner) {
        for(int i=0; i<3;i++){
            tab[tabGagner[i]].setBackgroundColor(BLUE);
        }
    }

    public void affiche(int op){
        Toast.makeText(getApplicationContext(),"Le bouton est " + op,Toast.LENGTH_LONG).show();
    }
}
