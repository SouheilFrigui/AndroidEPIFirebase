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
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    private Button DatePickerMD;
    Button Next;
    private EditText SelectedDate;
    private EditText Name;
    private EditText SurName;
    private EditText AgeDate;
    private EditText Email;
    private EditText Adr;
    private EditText Phone;
    private EditText School;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Date Button
        DatePickerMD= findViewById(R.id.datePicker);
        SelectedDate= findViewById(R.id.dateInput);

        MaterialDatePicker.Builder builder=MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Choisir une date");
        MaterialDatePicker materialDatePicker=builder.build();

        DatePickerMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(),"DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                SelectedDate.setText(materialDatePicker.getHeaderText());
            }
        });
        // Date Button

        Next= findViewById(R.id.envoyer);
        Name=findViewById(R.id.nomInput);
        SurName=findViewById(R.id.prenomInput);
        AgeDate=findViewById(R.id.dateInput);
        Email=findViewById(R.id.emailInput);
        Adr=findViewById(R.id.adresseInput);
        Phone=findViewById(R.id.telInput);
        School=findViewById(R.id.etabInput);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, SecondActivity.class);
                String NameString = Name.getText().toString();
                String SurNameString= SurName.getText().toString();
                String AgeDateString= AgeDate.getText().toString();
                String EmailString= Email.getText().toString();
                String AdrString= Adr.getText().toString();
                String PhoneString= Phone.getText().toString();
                String SchoolString= School.getText().toString();
                String DomaineString= autoCompleteTextView.getText().toString();


                i.putExtra("1",NameString);
                i.putExtra("2",SurNameString);
                i.putExtra("3",AgeDateString);
                i.putExtra("4",EmailString);
                i.putExtra("5",AdrString);
                i.putExtra("6",PhoneString);
                i.putExtra("7",SchoolString);
                i.putExtra("8",DomaineString);

                startActivity(i);
                finish();

            }
        });

     autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
     String [] option={"Informatique", "Mécanique", "Artistique"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.dropdown_item,option);
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);
        autoCompleteTextView.setAdapter(arrayAdapter);

    }
}