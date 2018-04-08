package com.example.ysl.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private Fragment[] fragments = {
            new RightFragment(), new AnotherRightFragment()
    };
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.bt_lf_fg);
        button.setOnClickListener(this);

        Button buttonSend = findViewById(R.id.bt_send_msg);
        buttonSend.setOnClickListener(this);

        replaceFragment(index);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_lf_fg:
                index++;
                Log.i(TAG, "onClick: fragments index = " + index);
                if (index > 1)
                    index = 0;
                replaceFragment(index);
                Log.i(TAG, "onClick: After replace, fragment is " + index);
                break;
            case R.id.bt_send_msg:
                LeftFragment fragment = (LeftFragment) getSupportFragmentManager().findFragmentById(R.id.fg_left);
                fragment.showMesage("Message From MainActivity: ");
            default:
                break;
        }
    }

    // We use android.support.v4.app.Fragment but not android.app.Fragment
    private void replaceFragment(int value) {

        // 1. FragmentManager (import android.support.v4.app.FragmentManager;)
        // Not (android.app.FragmentManager)
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 2. FragmentTransaction (import android.support.v7.app.FragmentTransaction;)
        // Not android.app.FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 3. FragmentTransaction.replace()
        if (value > 1 || value < 0)
            return;
        fragmentTransaction.replace(R.id.fl_right, fragments[value]);
        Log.i(TAG, "replaceFragment: " + fragmentManager.getFragments());

        // not necessary
        fragmentTransaction.addToBackStack(null);

        // 4. FragmentTransaction.commit()
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Log.w(TAG, "onBackPressed: " + this.getSupportFragmentManager().getFragments());
    }

    public void showMessage(String str) {
        Toast.makeText(this, str + TAG, Toast.LENGTH_SHORT).show();
    }
}
