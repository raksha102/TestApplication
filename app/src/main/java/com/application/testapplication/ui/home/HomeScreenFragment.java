package com.application.testapplication.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.testapplication.R;
import com.application.testapplication.application.constants.AppConstants;
import com.application.testapplication.databinding.FragmentHomeScreenBinding;
import com.application.testapplication.ui.base.BaseFragment;
import com.application.testapplication.ui.base.recycler_adapter.AdapterItem;
import com.application.testapplication.ui.base.recycler_adapter.RecyclerAdapter;
import com.application.testapplication.ui.model.data.AccountAttributeModel;
import com.application.testapplication.ui.model.data.AppToolbar;
import com.application.testapplication.ui.model.data.UserAccountModel;
import com.application.testapplication.ui.model.view.HomeViewModel;
import com.application.testapplication.ui.viewitem.AccountViewItem;
import com.application.testapplication.ui.viewitem.ProductViewItem;
import com.application.testapplication.ui.viewitem.ServiceViewItem;
import com.application.testapplication.ui.viewitem.SubscriptionViewItem;

import java.util.Map;

import javax.inject.Inject;

public class HomeScreenFragment extends BaseFragment {

    @Inject
    HomeViewModel mViewModel;
    private RecyclerAdapter mAdapter;

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
        mAdapter = new RecyclerAdapter(getRxBus());
        binding.rvUser.setAdapter(mAdapter);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home_screen;
    }

    @Override
    protected void initViews(View view) {
        mViewModel.getLiveData().observe(this, userAccountModel -> updateUI(userAccountModel));
        mViewModel.getData();
    }

    private void updateUI(UserAccountModel userAccountModel) {
        Map<String, AccountAttributeModel> data = userAccountModel.getUserData();
        if (data == null) return;

        addItem(AppConstants.TYPE_ACCOUNT, data, new AccountViewItem());
        addItem(AppConstants.TYPE_SERVICES, data, new ServiceViewItem());
        addItem(AppConstants.TYPE_SUBSCRIPTIONS, data, new SubscriptionViewItem());
        addItem(AppConstants.TYPE_PRODUCTS, data, new ProductViewItem());
        mAdapter.notifyDataSetChanged();
    }

    private void addItem(@AppConstants.DATA_TYPE String type,
                         Map<String, AccountAttributeModel> data, AdapterItem viewItem) {
        if(!data.containsKey(type)) return;
        viewItem.setData(data.get(type));
        mAdapter.add(viewItem);
    }

    @Override
    public AppToolbar getToolBarSetting() {
        return new AppToolbar.AppToolBarBuilder(false)
                .setBackButtonEnabled(false)
                .setTitle(getString(R.string.title_mivi_subscriptions))
                .build();
    }
}
