package com.example.micha.camerapersoninterest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micha.camerapersoninterest.model.Person;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity {

    private EditText job;
    private EditText hobby;
    private EditText name;
    private EditText age;
    private EditText gender;
    private ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        hobby = findViewById(R.id.hobby);
        job = findViewById(R.id.dream);
        people = new ArrayList<Person>();
    }

    public void addPerson(View view) {
        String pName = name.getText().toString();
        String pAge = age.getText().toString();
        String pGender = gender.getText().toString();
        String pHobby = hobby.getText().toString();
        String pJob = job.getText().toString();
        Person person = new Person(pName,pAge,pGender,pHobby,pJob);
        people.add(person);
        Toast.makeText(this, "Person: "+person.toString()+" added.", Toast.LENGTH_SHORT).show();
    }

    public void viewPeople(View view) {
        Intent intent = new Intent(getApplicationContext(),PersonListActivity.class);
    }
}
