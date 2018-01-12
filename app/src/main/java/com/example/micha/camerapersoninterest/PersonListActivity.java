package com.example.micha.camerapersoninterest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.micha.camerapersoninterest.model.Person;
import com.example.micha.camerapersoninterest.utils.Constants;

import java.util.ArrayList;

public class PersonListActivity extends AppCompatActivity {

    private ArrayList<Person> people;
    private LinearLayout current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);
        people = getIntent().getParcelableArrayListExtra(Constants.KEYS.PEOPLE);
        current = findViewById(R.id.peoplelayout);

        for(int i = 0;i < people.size();i++){
            TextView next = new TextView(getApplicationContext());
            next.setText(people.get(i).toString());
            current.addView(next);
        }
    }
}
