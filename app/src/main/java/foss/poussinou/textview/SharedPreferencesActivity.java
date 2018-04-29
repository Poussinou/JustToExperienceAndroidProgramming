package foss.poussinou.textview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class SharedPreferencesActivity extends AppCompatActivity {

    private static final String TAG = "SharedPreferencesActivi";
    private SharedPreferences mesSharedPreferences;
    private SharedPreferences.Editor monEditeurdeSharedPreferences;
    private EditText nom, motdepasse;
    private Button buttonLogin;
    private CheckBox maCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);
        renseignements("Activity Created");

        mesSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        monEditeurdeSharedPreferences = mesSharedPreferences.edit();
        nom = (EditText) findViewById(R.id.etNomSharedPreferences);
        motdepasse = (EditText) findViewById(R.id.etMotdePasseSharedPreferences);
        buttonLogin = (Button) findViewById(R.id.btnLoginSharedPreferences);
        maCheckBox = (CheckBox) findViewById(R.id.checkboxsharedpreferences);

        checkSharedPreferences();

        buttonLogin.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {
                 if (maCheckBox.isChecked()) {
                     monEditeurdeSharedPreferences.putString(getString(R.string.checkbox), "True");
                     monEditeurdeSharedPreferences.commit();

                     String newname = nom.getText().toString();
                     monEditeurdeSharedPreferences.putString(getString(R.string.nom), newname);
                     monEditeurdeSharedPreferences.commit();

                     String newpassword = motdepasse.getText().toString();
                     monEditeurdeSharedPreferences.putString(getString(R.string.motdepasse), newpassword);
                     monEditeurdeSharedPreferences.commit();
                 } else {
                     monEditeurdeSharedPreferences.putString(getString(R.string.checkbox), "False");
                     monEditeurdeSharedPreferences.commit();

                     monEditeurdeSharedPreferences.putString(getString(R.string.nom), "");
                     monEditeurdeSharedPreferences.commit();

                     monEditeurdeSharedPreferences.putString(getString(R.string.motdepasse), "");
                     monEditeurdeSharedPreferences.commit();
                 }
             }
        });


        Button retourMain = (Button) findViewById(R.id.btnSharedPreferencesRetour);

        retourMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharedPreferencesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /*monEditeurdeSharedPreferences.putString("clé", "Poussinou");
        monEditeurdeSharedPreferences.commit();

        String nom = mesSharedPreferences.getString("clés", "nompardéfaut"); //renvoie le mot associé au premier paramètre s'il le trouve, et sinon le nom par défaut

        renseignements("enregistre " + nom);*/

    private void checkSharedPreferences(){
        String contenuCheckBox = mesSharedPreferences.getString(getString(R.string.checkbox), "False");
        String nomCheckBox = mesSharedPreferences.getString(getString(R.string.nom), "UtilisateurDéfaut");
        String motdepasseCheckBox = mesSharedPreferences.getString(getString(R.string.motdepasse), "Motdepassedéfaut");

        nom.setText(nomCheckBox);
        motdepasse.setText(motdepasseCheckBox);

        if(contenuCheckBox.equals("True")){
            maCheckBox.setChecked(true);
        }
        else{
            maCheckBox.setChecked(false);
        }
    }

    private void renseignements(String message){
        Log.d(TAG, message);
        Toast.makeText(SharedPreferencesActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
