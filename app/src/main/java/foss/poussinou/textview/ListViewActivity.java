package foss.poussinou.textview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


//Seulement la premiere partie du tutoriel 7, puis tuto 8 avec adapter_view_layout
//animation pour le scroll également


public class ListViewActivity extends AppCompatActivity{

    private static final String TAG = "ListViewActivity";

    PersonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        renseignements("Activity Created");

        ListView notreListView = (ListView) findViewById(R.id.listView);

        EditText searchField = (EditText) findViewById(R.id.searchFilterduListView); //ne marche pas car la liste est composée de plusieurs éléments, tuto 11

        //Create the Person objects
        Person john = new Person("John","12-20-1998","Male");
        Person steve = new Person("Steve","08-03-1987","Male");
        Person stacy = new Person("Stacy","11-15-2000","Female");
        Person ashley = new Person("Ashley","07-02-1999","Female");
        Person matt = new Person("Matt","03-29-2001","Male");
        Person matt2 = new Person("Matt2","03-29-2001","Male");
        Person matt3 = new Person("Matt3","03-29-2001","Male");
        Person matt4 = new Person("Matt4","03-29-2001","Male");
        Person matt5 = new Person("Matt5","03-29-2001","Male");
        Person matt6 = new Person("Matt6","03-29-2001","Male");
        Person matt7 = new Person("Matt7","03-29-2001","Male");
        Person matt8 = new Person("Matt8","03-29-2001","Male");
        Person matt9 = new Person("Matt9","03-29-2001","Male");
        Person matt10 = new Person("Matt10","03-29-2001","Male");
        Person matt11 = new Person("Matt11","03-29-2001","Male");

        ArrayList<Person> peopleList = new ArrayList<>();

        //Add the Person objects to an ArrayList
        peopleList.add(john);
        peopleList.add(steve);
        peopleList.add(stacy);
        peopleList.add(ashley);
        peopleList.add(matt);
        peopleList.add(matt2);
        peopleList.add(matt3);
        peopleList.add(matt4);
        peopleList.add(matt5);
        peopleList.add(matt6);
        peopleList.add(matt7);
        peopleList.add(matt8);
        peopleList.add(matt9);
        peopleList.add(matt10);
        peopleList.add(matt11);

        searchField.addTextChangedListener(new TextWatcher() { //na marche pas ca rla liste est composée de plusieurs éléments, tuto 11
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                renseignements("texte changé");
                (ListViewActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
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






//tuto 7, vieux code
    /*@Override
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

    }*/