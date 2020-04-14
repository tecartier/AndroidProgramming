package net.androidbootcamp.phonephotoprintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double printsEntered;
    double totalCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText numOfPPrints = (EditText)findViewById(R.id.txtNumOfPrints);
        final RadioButton fourBySix = (RadioButton)findViewById(R.id.rad4x6);
        final RadioButton fiveBySeven = (RadioButton)findViewById(R.id.rad5x7);
        final RadioButton eightByTen = (RadioButton)findViewById(R.id.rad8x10);
        final TextView cost = (TextView)findViewById(R.id.txtCost);
        Button order = (Button)findViewById(R.id.btnOrder);

        order.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                printsEntered = Integer.parseInt(numOfPPrints.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                if (printsEntered <= 50) {
                    if (fourBySix.isChecked()) {
                        totalCost = (printsEntered * 0.19);

                        cost.setText(printsEntered + " 4x6 prints will cost " + currency.format(totalCost));
                    }
                    if (fiveBySeven.isChecked()) {
                        totalCost = (printsEntered * 0.49);
                        cost.setText(printsEntered + " 5x7 prints will cost " + currency.format(totalCost));
                    }
                    if (eightByTen.isChecked()) {
                        totalCost = (printsEntered * 0.79);
                        cost.setText(printsEntered + " 8x10 prints will cost " + currency.format(totalCost));

                    }
                }
                    else {
                        Toast.makeText(MainActivity.this, "Please enter no more than 50", Toast.LENGTH_LONG).show();
                    }

            }
        });
    }
}
