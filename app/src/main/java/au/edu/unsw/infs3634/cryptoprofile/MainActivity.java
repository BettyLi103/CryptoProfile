package au.edu.unsw.infs3634.cryptoprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import au.edu.unsw.infs3634.cryptoprofile.api.Coin;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnLaunchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("INFS3634 CryptoProfile");
        Log.d(TAG,"MainActivity launched");
        btnLaunchActivity = findViewById(R.id.btnLaunch);
        btnLaunchActivity.setText("Launch Detail Activity");
        btnLaunchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDetailActivity("Message from MainActivity");
            }
        });
    }

    // Called when the user taps launch button
    public void launchDetailActivity(String msg) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        Coin coin = Coin.getCoins().get(0);
        intent.putExtra(DetailActivity.INTENT_MESSAGE ,msg);
        startActivity(intent);
    }

}