package net.androidbootcamp.concerttickets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicket = 79.99;
    int numberOfTickets;
    double totalCost;
    String groupOfChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText tickets = (EditText) findViewById(R.id.txtTickets);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        Button cost = (Button) findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = costPerTicket * numberOfTickets;
                groupOfChoice = group.getSelectedItem().toString();

                DecimalFormat currency = new DecimalFormat("$###,###.##");
                result.setText("Cost for " + groupOfChoice + " is " + currency.format(totalCost));
            }
        });
    }
}
