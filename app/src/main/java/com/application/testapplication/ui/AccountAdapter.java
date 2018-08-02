package com.application.testapplication.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.testapplication.R;
import com.application.testapplication.ui.model.data.AccountAttributeModel;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountViewHolder> {
    private List<AccountAttributeModel> mData;

    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_account, parent, false);
        return new AccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AccountViewHolder holder, int position) {
        AccountAttributeModel data = mData.get(position);
        holder.bindData(data.getType(), data);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<AccountAttributeModel> data) {
        mData = data;
    }
}
