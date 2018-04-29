package foss.poussinou.textview;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//tuto 13


public class ScrollViewActivity extends AppCompatActivity{

    private static final String TAG = "ScrollViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_view);
        renseignements("Activity Created");

        TextView titleWindow = (TextView) findViewById(R.id.textViewduScrollView);
        TextView messageWindow = (TextView) findViewById(R.id.textViewduScrollView2);

        titleWindow.setText("Un titre ici");

        String messagerandom = "Le message super important";

        StringBuilder stringbuilder = new StringBuilder();

        for(int x = 0; x <100; x++){
            stringbuilder.append(messagerandom);
        }
        messageWindow.setText(stringbuilder.toString());

        Button retourMain = (Button) findViewById(R.id.btnScrollViewRetour);

        retourMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void renseignements(String message){
        Log.d(TAG, message);
        Toast.makeText(ScrollViewActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}
