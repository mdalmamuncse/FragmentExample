package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
               implements LoginFragment.LoginListener{
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        ft.add(R.id.fragmentcontainerId,loginFragment);
        ft.commit();
    }

    @Override
    public void loginComplet(String msg) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        WellcomeFragment wellcomeFragment = new WellcomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg",msg);
        wellcomeFragment.setArguments(bundle);
        ft.replace(R.id.fragmentcontainerId,wellcomeFragment);
        ft.addToBackStack(null);
        ft.commit();

    }
}
