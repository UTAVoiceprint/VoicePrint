package com.varvet.barcodereadersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.varvet.barcodereadersample.barcode.BarcodeCaptureActivity;
import android.support.v7.widget.Toolbar;
//import org.jetbrains.annotations.Nullable;
import android.view.View;
import android.graphics.Point;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final int BARCODE_READER_REQUEST_CODE = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView mResultTextView;
    private TextInputLayout mResultIP;
    private static String savedAPI = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        mResultTextView = findViewById(R.id.result_textview);
        Button btn = (Button) findViewById(R.id.scan_barcode_button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), BarcodeCaptureActivity.class);
                MainActivity.this.startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);

            }
        });

        RadioButton saveButton = (RadioButton) findViewById(R.id.saveButton);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedAPI = mResultTextView.getText().toString();
                Toast.makeText(MainActivity.this,savedAPI, Toast.LENGTH_SHORT).show();
            }
        });



        RadioButton saveIP = (RadioButton) findViewById(R.id.saveIPButton1);

        saveIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText IP_add =  (TextInputEditText) findViewById(R.id.IP_input);
                String str = IP_add.getText().toString();
                Toast.makeText(MainActivity.this,str, Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == BARCODE_READER_REQUEST_CODE)
        {
            if (resultCode == 0)
            {
                if (data != null)
                {
                    Barcode barcode = (Barcode) data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    mResultTextView.setText(barcode.displayValue);
                }
                else {
                    mResultTextView.setText(getString(R.string.no_barcode_captured));
                }

            } else {
                Log.e(LOG_TAG, String.format(getString(R.string.barcode_error_format),
                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void NextButton(View view)
    {
        Intent intent = new Intent(this,homeActivity.class);
        startActivity(intent);
    }



 }
