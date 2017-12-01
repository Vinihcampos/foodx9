package pso.secondphase.foodx9.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import pso.secondphase.foodx9.R;
import pso.secondphase.foodx9.util.SetSocketTask;

public class QRCodeActivity extends Activity {

    private IntentIntegrator mScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        mScanner = new IntentIntegrator(this);
        mScanner.setPrompt("Scan the table QRCode");
        mScanner.setOrientationLocked(false);
        mScanner.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == 99) {
            Log.i("CODE: ", "99 voltei");
            if (mScanner == null) {
                mScanner = new IntentIntegrator(this);
                mScanner.setPrompt("Scan the Android-in QRCode");
                mScanner.setOrientationLocked(false);
            }
            mScanner.initiateScan();
        } else {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            if (result != null) {
                if (result.getContents() == null) {
                    finish();
                } else {
                    String table = result.getContents().toString();
                    Intent newIntent = new Intent(this, MenuActivity.class);
                    newIntent.putExtra("TABLE", table);
                    new SetSocketTask().execute("5220", "192.168.0.120");
                    startActivityForResult(newIntent, 99);

                }
            } else {
                finish();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
