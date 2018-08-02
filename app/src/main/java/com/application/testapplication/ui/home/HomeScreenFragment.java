package com.application.testapplication.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.testapplication.R;
import com.application.testapplication.databinding.FragmentHomeScreenBinding;
import com.application.testapplication.ui.AccountAdapter;
import com.application.testapplication.ui.base.BaseFragment;
import com.application.testapplication.ui.model.data.UserAccountModel;
import com.application.testapplication.ui.model.view.HomeViewModel;

import javax.inject.Inject;

public class HomeScreenFragment extends BaseFragment {

    @Inject
    HomeViewModel mViewModel;
    private AccountAdapter mAdapter;

    public static HomeScreenFragment newInstance() {
        return new HomeScreenFragment();
    }

    @Override
    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeScreenBinding binding = DataBindingUtil.inflate(inflater, getFragmentLayoutId(), container, false);
        seUpRecyclerView(binding);
        return binding.getRoot();
    }

    private void seUpRecyclerView(FragmentHomeScreenBinding binding) {
        binding.rvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new AccountAdapter();
        binding.rvUser.setAdapter(mAdapter);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home_screen;
    }

    @Override
    protected void initViews(View view) {
        mViewModel.getLiveData().observe(this, this::updateUI);
        mViewModel.getData();
    }

    private void updateUI(UserAccountModel userAccountModel) {
        mAdapter.setData(userAccountModel.getData());
    }
}
