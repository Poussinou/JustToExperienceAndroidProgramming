package foss.poussinou.textview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


//Tutoriel 5


public class ImageViewActivity extends AppCompatActivity {

    private static final String TAG = "ImageViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view);
        renseignements("Activity Created");

        ImageView notreImageView = (ImageView) findViewById(R.id.imageView);
        int imageResource = getResources().getIdentifier("@drawable/renard", null, this.getPackageName());
        notreImageView.setImageResource(imageResource);




        Button retourMain = (Button) findViewById(R.id.btnImageViewRetour);

        retourMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void renseignements(String message){
        Log.d(TAG, message);
        Toast.makeText(ImageViewActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
