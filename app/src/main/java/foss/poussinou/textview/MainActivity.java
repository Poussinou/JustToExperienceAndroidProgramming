package foss.poussinou.textview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        renseignements("Activity Created");

        Button btnTextView = (Button) findViewById(R.id.btnMain_TextView);
        Button btnListView = (Button) findViewById(R.id.btnMain_ListView);
        Button btnImageView = (Button) findViewById(R.id.btnMain_ImageView);
        Button btnScrollView = (Button) findViewById(R.id.btnMain_ScrollView);
        Button btnSharedPreferences = (Button) findViewById(R.id.btnMain_SharedPreferences);

        btnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renseignements("Bouton TextView cliqué");

                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(intent);
            }
        });

        btnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renseignements("Bouton ImageView cliqué");

                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renseignements("Bouton ListView cliqué");

                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        btnScrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renseignements("Bouton ScrollView cliqué");

                Intent intent = new Intent(MainActivity.this, ScrollViewActivity.class);
                startActivity(intent);
            }
        });

        btnSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                renseignements("Bouton SharedPreferences cliqué");

                Intent intent = new Intent(MainActivity.this, SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });

    }


    private void renseignements(String message){
        Log.d(TAG, message);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
