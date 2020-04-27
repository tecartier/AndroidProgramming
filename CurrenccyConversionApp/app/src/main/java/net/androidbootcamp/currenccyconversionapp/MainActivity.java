package net.androidbootcamp.currenccyconversionapp;

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
    double usDollarsEntered;
    double convertedTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText usDollars = (EditText)findViewById(R.id.txtUSDollars);
        final RadioButton euros = (RadioButton)findViewById(R.id.radEuros);
        final RadioButton pesos = (RadioButton)findViewById(R.id.radPesos);
        final RadioButton canadian = (RadioButton)findViewById(R.id.radCanadian);
        final TextView convertedAmnt = (TextView)findViewById(R.id.txtConvertedAmnt);
        Button convert = (Button)findViewById(R.id.btnConvert);
        convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                usDollarsEntered = Integer.parseInt(usDollars.getText().toString());
                DecimalFormat currency = new DecimalFormat("###,###.##");
                if (usDollarsEntered<= 100000) {
                    if (euros.isChecked()) {
                        convertedTotal = (usDollarsEntered * 0.91412);

                        convertedAmnt.setText(currency.format(convertedTotal)+ " euros");
                    }
                    if (pesos.isChecked()) {
                        convertedTotal = (usDollarsEntered * 23.5264);

                        convertedAmnt.setText(currency.format(convertedTotal)+ " pesos");
                    }
                    if (canadian.isChecked()) {
                        convertedTotal = (usDollarsEntered * 1.38738);

                        convertedAmnt.setText(currency.format(convertedTotal)+ " Canadian Dollars");
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Please enter no more than $100,000", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
