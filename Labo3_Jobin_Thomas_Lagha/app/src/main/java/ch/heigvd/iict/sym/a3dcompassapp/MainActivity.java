/**
 -----------------------------------------------------------------------------------------
 Laboratory  : SYM - Laboratory n°3
 File        : MainActivity.java
 Author      : Lagha Oussama, Jobin Simon, Thomas Benjamin
 Date        : 13.12.2018
 Goal        : Implementation of the mainActivity that lead to the different transfer types
 Remark(s)   : -
 ----------------------------------------------------------------------------------------
 */

package ch.heigvd.iict.sym.a3dcompassapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button NfcActivityButton;
    private Button BarcodeActivityButton;
    private Button BeaconActivityButton;
    private Button CaptorActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    public void initButtons() {

        BarcodeActivityButton = findViewById(R.id.barcodeButton);
        BarcodeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barcodeActivity(v);
            }
        });

        /* TODO */
        /* All other buttons */
    }

    public void barcodeActivity(View v) {
        Intent intentBarcode = new Intent(this, BarcodeActivity.class);
        startActivity(intentBarcode);
    }
}
