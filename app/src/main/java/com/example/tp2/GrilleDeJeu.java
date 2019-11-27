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

public class GrilleDeJeu extends AppCompatActivity {
    Jeu jeu;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,newGame;
    TextView result, titre;
    Button[] tab;
    int[] tabGagner;
    Boolean fini;

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
        tab[7] = findViewById(R.id.b6);
        tab[8] = findViewById(R.id.b7);
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
    }

    public GrilleDeJeu(){

    }

    public void initialiser(){
        for (int i=0; i<tab.length; i++ ){
            tab[i].setBackgroundColor(0);
            tab[i].setText("");

        }
        jeu.initialise();
        for(int j=0; j<3; j++){
         tabGagner[j] = -1;
        }
        fini = false;
        result.setText("");
    }

    public void clicChiffre(View v){

        Button b = (Button)v;

        int aff = b.getId();
        if(b1.getId() == aff){
            affiche(aff);
        }


    }
    public void affiche(int op){
        Toast.makeText(getApplicationContext(),"Le bouton est " + op,Toast.LENGTH_LONG).show();
    }
}
