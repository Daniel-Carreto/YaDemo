package com.naat.yademo.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.naat.yademo.R;
import com.naat.yademo.databinding.ActivityLoginBinding;
import com.naat.yademo.view.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    private LoginFragment loginFragment = null;
    private ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginFragment = new LoginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(activityLoginBinding.loginFrameContainer.getId(),loginFragment)
                .commit();
    }
}
