package foss.poussinou.textview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//tutoriel 2


public class TextViewActivity extends AppCompatActivity {

    private static final String TAG = "TextView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_view);
        renseignements("Activity Created");

        TextView notreTextView = (TextView) findViewById(R.id.textView);

        //String recuperationString = notreTextView.getText().toString();

        notreTextView.setText("coucou");

        Button retourMain = (Button) findViewById(R.id.btnTextViewRetour);

        retourMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TextViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //notreTextView.

        //Log.d(TAG, "String prise")
    }


    private void renseignements(String message){
        Log.d(TAG, message);
        Toast.makeText(TextViewActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
