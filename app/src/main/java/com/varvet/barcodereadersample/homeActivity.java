package com.varvet.barcodereadersample;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }
    public void BackButton(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
