package com.toumi.foodfacts.module.scan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.toumi.foodfacts.R;
import com.toumi.foodfacts.common.base.BaseActivity;
import com.toumi.foodfacts.common.base.BaseViewModel;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ScanBarcodeActivity extends BaseActivity implements BarcodeReader.BarcodeReaderListener {

    private BarcodeReader barcodeReader;

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingUtil.setContentView(this, R.layout.activity_scanbarcode);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcodeFragment);
    }

    @Override
    public void onScanned(Barcode barcode) {
        barcodeReader.playBeep();

        if (!TextUtils.isEmpty(barcode.displayValue)) {
            showMessage("Scanned code: " + barcode.displayValue);

            barcodeReader.pauseScanning();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("productCode", barcode.displayValue);
            setResult(RESULT_OK, resultIntent);
            finish();
        } else {
            showMessage("empty scanned code");
        }
    }

    @Override
    public void onScannedMultiple(List<Barcode> list) {
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {
    }

    @Override
    public void onScanError(String s) {
    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(getApplicationContext(), "Camera permission denied!", Toast.LENGTH_LONG).show();
        finish();
    }

    private void showMessage(String message) {
        new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());
    }
}