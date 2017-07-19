package com.sarvan.recyclerviewtest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        fragment = new RetrofitFragment();
        transaction.add(R.id.container, fragment, "Retrofit");
        transaction.commit();
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle_button);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                transaction = manager.beginTransaction();
                String keyName;
                if (!isChecked) {
                    fragment = new RetrofitFragment();
                    keyName = "Retrofit";
                } else {
                    fragment = new VolleyFragment();
                    keyName = "Volley";
                }
                transaction.replace(R.id.container, fragment, keyName);
                transaction.commit();
            }
        });
    }
}
