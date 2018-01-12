package com.example.micha.camerapersoninterest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.Math;

public class EMIActivity extends AppCompatActivity {

    private SeekBar total;
    private SeekBar rate;
    private SeekBar time;
    private TextView totalView;
    private TextView rateView;
    private TextView yearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);
        total = findViewById(R.id.amount);
        totalView = findViewById(R.id.tTotal);
        rateView = findViewById(R.id.tRate);
        yearView = findViewById(R.id.tYears);
        rate = findViewById(R.id.rate);
        time = findViewById(R.id.years);

        total.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                totalView.setText("Total owed: $" + Integer.toString(total.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        rate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                rateView.setText("Interest Rate: "+ Integer.toString((rate.getProgress()+1)) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        time.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                yearView.setText("Years Owed: " + Integer.toString((time.getProgress()+1))+" years");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    double calculate(){
        double amount = total.getProgress();
        //let's say it's monthly interest
        double interest = (rate.getProgress()+1)/100.00;
        double years = (time.getProgress()+1);
        return 0.0;
    }

}
