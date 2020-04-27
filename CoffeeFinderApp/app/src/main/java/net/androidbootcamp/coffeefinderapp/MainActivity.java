package net.androidbootcamp.coffeefinderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] companies = {"Kahwa Coffee", "Ohana Coffee Kava Tea", "Beans & Barlour", "Belleair Coffee Company & Roastery"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.shops, companies));
        super.onCreate(savedInstanceState);
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch (position){
            case 0:
                startActivity(new Intent(MainActivity.this, shop1.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, shop2.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, shop3.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, shop4.class));
                break;
        }
    }
}
