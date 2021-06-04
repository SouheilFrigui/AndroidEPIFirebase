package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView salut;
    String nom;
    String prenom;
    String age;
    String email;
    String adr;
    String tel;
    String etab;
    String dom;
    AutoCompleteTextView autoCompleteTextView2;
    Button Terminer;



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        salut=findViewById(R.id.salutation);
        Intent i=getIntent();
        nom=i.getExtras().getString("1");
        prenom=i.getExtras().getString("2");
        age=i.getExtras().getString("3");
        email=i.getExtras().getString("4");
        adr=i.getExtras().getString("5");
        tel=i.getExtras().getString("6");
        etab=i.getExtras().getString("7");
        dom=i.getExtras().getString("8");
        salut.setText("Vous y êtes presque "+prenom+" "+nom+ ", veuillez choisir votre compétence");

        autoCompleteTextView2=findViewById(R.id.autoCompleteTextView2);
        if (dom.equals("Informatique")){
            String [] option={"Développement Mobile", "Développement Web", "Développement Desktop"};
            ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.dropdown_item,option);
            autoCompleteTextView2.setText(arrayAdapter.getItem(0).toString(), false);
            autoCompleteTextView2.setAdapter(arrayAdapter);
        }
        else if (dom.equals("Mécanique")){
            String [] option={"Mécanique Avion", "Mécanique Auto", "Automatisation"};
            ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.dropdown_item,option);
            autoCompleteTextView2.setText(arrayAdapter.getItem(0).toString(), false);
            autoCompleteTextView2.setAdapter(arrayAdapter);
        }
        else{
            String [] option={"Design produit", "UI/UX design", "Photographie"};
            ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.dropdown_item,option);
            autoCompleteTextView2.setText(arrayAdapter.getItem(0).toString(), false);
            autoCompleteTextView2.setAdapter(arrayAdapter);
        }
        Terminer=findViewById(R.id.terminer);
        Terminer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comp= autoCompleteTextView2.getText().toString();
                Intent i2= new Intent(SecondActivity.this, ThirdActivity.class);
                i2.putExtra("11",nom);
                i2.putExtra("22",prenom);
                i2.putExtra("33",age);
                i2.putExtra("44",email);
                i2.putExtra("55",adr);
                i2.putExtra("66",tel);
                i2.putExtra("77",etab);
                i2.putExtra("88",dom);
                i2.putExtra("99",comp);
                startActivity(i2);
                finish();
            }
        });
    }
}