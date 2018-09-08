package com.example.sararush.prog01_speedy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Calculate extends AppCompatActivity {
    private Spinner transportSpinner;
    private EditText input;
    private TextView output1;
    private TextView output2;
    private TextView output3;
    private TextView output4;
    private TextView output5;
    private TextView transport1;
    private TextView transport2;
    private TextView transport3;
    private TextView transport4;
    private TextView transport5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String transport = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        double miles = Double.parseDouble(intent.getStringExtra(MainActivity.EXTRA_MILES));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        transportSpinner = (Spinner) findViewById(R.id.transport_spinner);
        input = (EditText) findViewById(R.id.miles);
        output1 = (TextView) findViewById(R.id.textView6);
        output2 = (TextView) findViewById(R.id.textView7);
        output3 = (TextView) findViewById(R.id.textView8);
        output4 = (TextView) findViewById(R.id.textView9);
        output5 = (TextView) findViewById(R.id.textView10);
        transport1 = (TextView) findViewById(R.id.textView11);
        transport2 = (TextView) findViewById(R.id.textView12);
        transport3 = (TextView) findViewById(R.id.textView13);
        transport4 = (TextView) findViewById(R.id.textView14);
        transport5 = (TextView) findViewById(R.id.textView15);

        int[] converted = convert(transport, miles);
        String[] transports = getTransportList(transport.toLowerCase());

        output1.setText(String.valueOf(String.format("%d", converted[0])));
        output2.setText(String.valueOf(String.format("%d", converted[1])));
        output3.setText(String.valueOf(String.format("%d", converted[2])));
        output4.setText(String.valueOf(String.format("%d", converted[3])));
        output5.setText(String.valueOf(String.format("%d", converted[4])));

        transport1.setText(String.valueOf(transports[0]));
        transport2.setText(String.valueOf(transports[1]));
        transport3.setText(String.valueOf(transports[2]));
        transport4.setText(String.valueOf(transports[3]));
        transport5.setText(String.valueOf(transports[4]));

    }

    private String[] getTransportList(String transport) {
        String[] transports = new String[5];

        switch (transport) {
            case "walking":
                transports[0] = "walking";
                transports[1] = "minutes by Boosted Mini S Board";
                transports[2] = "minutes by Evolve Skateboard";
                transports[3] = "minutes by Segway 12 SE";
                transports[4] = "minutes by Hovertrax Hoverboard";
                break;

            case "boosted mini s board":
                transports[0] = "Boosted Mini S Board";
                transports[1] = "minutes by walking";
                transports[2] = "minutes by Evolve Skateboard";
                transports[3] = "minutes by Segway 12 SE";
                transports[4] = "minutes by Hovertrax Hoverboard";
                break;

            case "evolve skateboard":
                transports[0] = "Evolve Skateboard";
                transports[1] = "minutes by walking";
                transports[2] = "minutes by Boosted Mini S Board";
                transports[3] = "minutes by Segway 12 SE";
                transports[4] = "minutes by Hovertrax Hoverboard";
                break;

            case "segway i2 se":
                transports[0] = "Segway 12 SE";
                transports[1] = "minutes by walking";
                transports[2] = "minutes by Boosted Mini S Board";
                transports[3] = "minutes by Evolve Skateboard";
                transports[4] = "minutes by Hovertrax Hoverboard";
                break;

            case "hovertrax hoverboard":
                transports[0] = "Hovertrax Hoverboard";
                transports[1] = "minutes by walking";
                transports[2] = "minutes by Boosted Mini S Board";
                transports[3] = "minutes by Evolve Skateboard";
                transports[4] = "minutes by Segway i2 SE";
                break;
        }
        return transports;
    }

    private void checkIfFieldIsEmpty(EditText input) {
        if (input.getText().toString().equals("")) {
            Toast.makeText(Calculate.this, "You must enter the number of miles", Toast.LENGTH_LONG).show();
        }
    }

    public int[] convert(String transport, double input) {
        transport = transport.toLowerCase();
        int[] outputs = new int[5];


        switch (transport) {
            case "walking":
                outputs[0] = (int) ((input/3.1) * 60);
                outputs[1] = (int) ((input/18) * 60);
                outputs[2] = (int) ((input/26.0) * 60);
                outputs[3] = (int) ((input/12.5) * 60);
                outputs[4] = (int) ((input/8) * 60);
                break;

            case "boosted mini s board":
                outputs[0] = (int) ((input/18) * 60);
                outputs[1] = (int) ((input/3.1) * 60);
                outputs[2] = (int) ((input/26.0) * 60);
                outputs[3] = (int) ((input/12.5) * 60);
                outputs[4] = (int) ((input/8) * 60);
                break;

            case "evolve skateboard":
                outputs[0] = (int) ((input/26.0) * 60);
                outputs[1] = (int) ((input/3.1) * 60);
                outputs[2] = (int) ((input/18) * 60);
                outputs[3] = (int) ((input/12.5) * 60);
                outputs[4] = (int) ((input/8) * 60);
                break;

            case "segway i2 se":
                outputs[0] = (int) ((input/12.5) * 60);
                outputs[1] = (int) ((input/3.1) * 60);
                outputs[2] = (int) ((input/18) * 60);
                outputs[3] = (int) ((input/26.0) * 60);
                outputs[4] = (int) ((input/8) * 60);
                break;

            case "hovertrax hoverboard":
                outputs[0] = (int) ((input/8) * 60);
                outputs[1] = (int) ((input/3.1) * 60);
                outputs[2] = (int) ((input/18) * 60);
                outputs[3] = (int) ((input/26.0) * 60);
                outputs[4] = (int) ((input/12.5) * 60);
                break;
        }
        return outputs;
    }
}
