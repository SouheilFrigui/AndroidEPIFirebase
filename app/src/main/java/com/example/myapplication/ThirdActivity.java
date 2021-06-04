package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    String nom;
    String prenom;
    String age;
    String email;
    String adr;
    String tel;
    String etab;
    String dom;
    String comp;
    TextView nomIns;
    TextView prenIns;
    TextView ageIns;
    TextView emailIns;
    TextView adrIns;
    TextView telIns;
    TextView etabIns;
    TextView domIns;
    TextView compIns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent j=getIntent();
        nom=j.getExtras().getString("11");
        prenom=j.getExtras().getString("22");
        age=j.getExtras().getString("33");
        email=j.getExtras().getString("44");
        adr=j.getExtras().getString("55");
        tel=j.getExtras().getString("66");
        etab=j.getExtras().getString("77");
        dom=j.getExtras().getString("88");
        comp=j.getExtras().getString("99");

        nomIns=findViewById(R.id.nomIns);
        nomIns.setText("Nom: "+nom);

        prenIns=findViewById(R.id.prenIns);
        prenIns.setText("Prénom: "+prenom);

        ageIns=findViewById(R.id.dateIns);
        ageIns.setText("Date de naissance: "+age);

        emailIns=findViewById(R.id.emailIns);
        emailIns.setText("Email: "+email);

        adrIns=findViewById(R.id.adrIns);
        adrIns.setText("Adresse: "+adr);

        telIns=findViewById(R.id.telIns);
        telIns.setText("Telephone: "+tel);

        etabIns=findViewById(R.id.etabIns);
        etabIns.setText("Etablissement: "+etab);

        domIns=findViewById(R.id.domIns);
        domIns.setText("Domaine: "+dom);

        compIns=findViewById(R.id.compIns);
        compIns.setText("Compétence: "+comp);


    }
}