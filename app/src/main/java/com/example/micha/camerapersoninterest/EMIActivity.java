package com.example.micha.camerapersoninterest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.Math;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class EMIActivity extends AppCompatActivity {

    private SeekBar total;
    private SeekBar rate;
    private SeekBar time;
    private TextView totalView;
    private TextView rateView;
    private TextView yearView;
    private TextView emi;

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
        emi = findViewById(R.id.emi);

        total.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                NumberFormat formatter = new DecimalFormat("#,###");
                totalView.setText("Total owed: $" + formatter.format(total.getProgress()));
                calculate();
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
                calculate();
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
                calculate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    void calculate(){
        double amount = total.getProgress();
        //let's say it's monthly interest
        double interest = (rate.getProgress()+1)/100.00;
        double years = (time.getProgress()+1);
        double calculation = amount*interest*Math.pow((1+interest),years*12)/(Math.pow(1+interest,years*12)-1);
        NumberFormat format = new DecimalFormat("#,###.##");
        emi.setText("Monthly Installment: $" + format.format(calculation));
    }

}
