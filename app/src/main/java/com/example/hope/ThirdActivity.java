package com.example.hope;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThirdActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference().child("Participant");

  /*  String nom;
    String prenom;
    String age;
    String email;
    String adr;
    String tel;
    String etab;
    String dom;
    String comp;*/
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

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String nom = dataSnapshot.child("Name").getValue(String.class);
                String prenom = dataSnapshot.child("Surename").getValue(String.class);
                String age = dataSnapshot.child("Age").getValue(String.class);
                String email = dataSnapshot.child("Email").getValue(String.class);
                String adr = dataSnapshot.child("Address").getValue(String.class);
                String tel = dataSnapshot.child("Phone").getValue(String.class);
                String etab = dataSnapshot.child("School").getValue(String.class);
                String dom = dataSnapshot.child("FieldOfStudy").getValue(String.class);
                String comp = dataSnapshot.child("Competence").getValue(String.class);
               // Log.d(nom, "Value is: " + nom);

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

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("Error", "Failed to read value.", error.toException());
            }

       /* Intent j=getIntent();
        nom=j.getExtras().getString("11");
        prenom=j.getExtras().getString("22");
        age=j.getExtras().getString("33");
        email=j.getExtras().getString("44");
        adr=j.getExtras().getString("55");
        tel=j.getExtras().getString("66");
        etab=j.getExtras().getString("77");
        dom=j.getExtras().getString("88");
        comp=j.getExtras().getString("99");














        */

    });
    }
}