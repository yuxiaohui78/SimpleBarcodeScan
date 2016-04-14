package com.example.xiaohui.simplebarcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.library.barcodescan.CaptureActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int BARCODE_REQ_ID = 0X100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnBarcodeScan).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBarcodeScan){
            Intent i = new Intent(this, CaptureActivity.class);
            startActivityForResult(i, BARCODE_REQ_ID);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BARCODE_REQ_ID && resultCode == Activity.RESULT_OK) {
            String barcode = data.getStringExtra("BarcodeNumber");
            TextView tvBarcodeResult = (TextView) findViewById(R.id.tvBarcodeResult);
            tvBarcodeResult.setText(barcode);
        }
    }
}
