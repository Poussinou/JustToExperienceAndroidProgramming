package foss.poussinou.textview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


//Seulement la premiere partie du tutoriel 7, tuto 8
//animation pour le scroll également


public class ListViewActivity extends AppCompatActivity{

    private static final String TAG = "ListViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        renseignements("Activity Created");

        ListView notreListView = (ListView) findViewById(R.id.listView);

        ArrayList<String> animaux = new ArrayList<>();
        animaux.add("Requin");
        animaux.add("Poulet");
        animaux.add("Saumon");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, animaux);
        notreListView.setAdapter(adapter);


        Button retourMain = (Button) findViewById(R.id.btnListViewRetour);

        retourMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void renseignements(String message){
        Log.d(TAG, message);
        Toast.makeText(ListViewActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
