package ch.heigvd.iict.sym.a3dcompassapp.nfc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import ch.heigvd.iict.sym.a3dcompassapp.R;

/**
 * NFC connected activity
 *
 * @author Amel Dussier
 * @author Thibaud Besseau
 */
public class connectedActivity extends NFCActivity {

    // security level
    private int AUTHENTICATE_MAX = 10;
    private int AUTHENTICATE_MEDIUM = 7;
    private int AUTHENTICATE_LOW = 3;

    // actual security level
    private int securityLevel;

    // UI
    private Button btnMax = null;
    private Button btnMedium = null;
    private Button btnLow = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // get UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected);
        securityLevel = 10;
        btnMax = findViewById(R.id.btn_max);
        btnMedium = findViewById(R.id.btn_medium);
        btnLow = findViewById(R.id.btn_min);

        // listener button MAX
        btnMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // level ok
            if (securityLevel > AUTHENTICATE_MEDIUM) {
                Toast.makeText(getApplicationContext(), "Niveau suffisant", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Niveau insuffisant.", Toast.LENGTH_LONG).show();
            }
            }
        });

        // listener button Medium
        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //level ok
            if (securityLevel > AUTHENTICATE_LOW) {
                Toast.makeText(getApplicationContext(), "Niveau suffisant", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Niveau insuffisant.", Toast.LENGTH_LONG).show();
            }
            }
        });

        // listener button Low
        btnLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //level ok
            if (securityLevel > 0) {
                Toast.makeText(getApplicationContext(), "Niveau suffisant", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Niveau insuffisant.", Toast.LENGTH_LONG).show();
            }
            }
        });

        // launch a timer to decrement the security level every 5 sec
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    securityLevel--;
                }
            });
            }
        };
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 5000);
    }

    // inherited from NFCActivity
    protected void additionalAction() {
        Log.d("NFC", "Reset the security level to the maximum level");
        securityLevel = AUTHENTICATE_MAX;
    }
}
