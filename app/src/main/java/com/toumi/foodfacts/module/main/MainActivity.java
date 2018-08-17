package com.toumi.foodfacts.module.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.toumi.foodfacts.R;
import com.toumi.foodfacts.common.base.BaseActivity;
import com.toumi.foodfacts.databinding.ActivityMainBinding;
import com.toumi.foodfacts.module.scan.ScanBarcodeActivity;

import timber.log.Timber;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class MainActivity extends BaseActivity<MainViewModel> {
    private static final int SCAN_REQUEST_CODE = 0;

    private ActivityMainBinding binding;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBinding();
        setupActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    private void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(getViewModel());

        getViewModel().showMessage.observe(this, message -> {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });

//        getViewModel().showPhotoPreviewScreen.observe(this, imageUrl -> {
//            getSupportFragmentManager().beginTransaction()
//                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
//                    .replace(android.R.id.content, PhotoPreviewFragment.newInstance(imageUrl))
//                    .commitAllowingStateLoss();
//        });
    }

    private void setupActionBar() {
        setSupportActionBar(binding.toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }

    private void toggleSideMenu() {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) binding.guideline.getLayoutParams();
        if (params.guidePercent == 0.3f) {
            params.guidePercent = 0f;
        } else {
            params.guidePercent = 0.3f;
        }
        binding.guideline.setLayoutParams(params);
    }

    private void showBarcodeRequestDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                Timber.w(e, "");
            }
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
        alertDialogBuilder.setTitle(this.getString(R.string.request_barcode));
        View dialogView = this.getLayoutInflater().inflate(R.layout.layout_inputcode_dialog, null);
        alertDialogBuilder.setView(dialogView);

        final EditText barcodeEditText = dialogView.findViewById(R.id.barcodeEditText);

        // Set up the buttons
        alertDialogBuilder.setPositiveButton(R.string.ok, (dialog, which) -> {

            String barcode = barcodeEditText.getText().toString();
            if (!TextUtils.isEmpty(barcode)) {
                getViewModel().fetchProductByBarcodeNumber(barcode);
            }
        });
        alertDialogBuilder.setNegativeButton(R.string.cancel, (dialog, which) -> {
        });

        try {
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } catch (Exception e) {
            Timber.w(e, "");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toggleSideMenu();
                break;
            case R.id.scan_barcode_action:
                Intent intent = new Intent(this, ScanBarcodeActivity.class);
                startActivityForResult(intent, SCAN_REQUEST_CODE);
                return true;
            case R.id.request_barcode_action:
                showBarcodeRequestDialog();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SCAN_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String productCode = data.getStringExtra("productCode");
            Timber.d("productCode: %s", productCode);

            if (!TextUtils.isEmpty(productCode)) {
                getViewModel().fetchProductByBarcodeNumber(productCode);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
