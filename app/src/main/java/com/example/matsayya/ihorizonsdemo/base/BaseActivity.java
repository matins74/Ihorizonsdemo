package com.example.matsayya.ihorizonsdemo.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;


import com.example.matsayya.ihorizonsdemo.application.CommonApplication;
import com.example.matsayya.ihorizonsdemo.di.components.CommonApplicationComponent;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity
{
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = LayoutInflater.from(this).inflate(getContentView(), null);
        setContentView(view);
        ButterKnife.bind(this, view);
        onViewReady(savedInstanceState, getIntent());
    }

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        // to be used  bt child activity
        resolveDaggerDependancy();
    }

    protected void resolveDaggerDependancy() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void showDialog(String message)
    {
        if(mProgressDialog == null)
        {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected  void hideDilaog()
    {
        if(mProgressDialog!=null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
        }
    }

    protected abstract int getContentView();

    protected CommonApplicationComponent getApplicationComponent()
    {
        return ((CommonApplication) getApplication()).getApplicationComponent();
    }
}
