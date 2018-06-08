package com.example.matsayya.ihorizonsdemo.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.matsayya.ihorizonsdemo.R;
import com.example.matsayya.ihorizonsdemo.base.BaseActivity;
import com.example.matsayya.ihorizonsdemo.di.components.DaggerMainComponent;
import com.example.matsayya.ihorizonsdemo.di.module.MainModule;
import com.example.matsayya.ihorizonsdemo.modules.home.adapters.UserListAdapter;
import com.example.matsayya.ihorizonsdemo.mvp.model.Item;
import com.example.matsayya.ihorizonsdemo.mvp.presenter.MainPresenter;
import com.example.matsayya.ihorizonsdemo.mvp.view.MainView;
import com.example.matsayya.ihorizonsdemo.utilities.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.recyclerUserList)
    public RecyclerView mUserList;

    @Inject protected MainPresenter mPresenter;

    private UserListAdapter userListAdapter;
    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initialise();
        if(NetworkUtils.isNetworkConnected(this))
        {
            mPresenter.getMobiles();
        }
        else
        {
           showDialog("Check Network connection");
        }

    }

    private void initialise() {
        mUserList.setHasFixedSize(true);
        mUserList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        userListAdapter = new UserListAdapter(getLayoutInflater());
        mUserList.setAdapter(userListAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependancy() {
        DaggerMainComponent.builder().commonApplicationComponent(getApplicationComponent()).mainModule(new MainModule(MainActivity.this)).build().inject(this);
    }



    @Override
    public void onListLoaded(List<Item> list) {

        userListAdapter.addMobiles(list);
    }

    @Override
    public void onShowDilaog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDilaog() {
            hideDilaog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearItems() {
        userListAdapter.clearUsers();
    }
}
