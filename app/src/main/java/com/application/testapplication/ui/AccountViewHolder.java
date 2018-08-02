package com.application.testapplication.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.application.testapplication.R;
import com.application.testapplication.application.constants.AppConstants;
import com.application.testapplication.ui.model.data.AccountAttributeModel;

public class AccountViewHolder extends RecyclerView.ViewHolder {

    TextView mTxtTitle;
    TextView mText1;
    TextView mText2;
    TextView mText3;
    TextView mText4;

    public AccountViewHolder(View itemView) {
        super(itemView);
        mTxtTitle = itemView.findViewById(R.id.txt_title);
        mText1 = itemView.findViewById(R.id.text1);
        mText2 = itemView.findViewById(R.id.text2);
        mText3 = itemView.findViewById(R.id.text3);
        mText4 = itemView.findViewById(R.id.text4);
    }

    public void bindData(String type, AccountAttributeModel data) {
        switch (type) {
            case AppConstants.TYPE_ACCOUNT:
                setAccountData(data);
                break;
            case AppConstants.TYPE_PRODUCTS:
                setProductData(data);
                break;
            case AppConstants.TYPE_SERVICES:
                setServiceData(data);
                break;
            case AppConstants.TYPE_SUBSCRIPTIONS:
                setSubscriptionData(data);
                break;
        }
    }

    private void setSubscriptionData(AccountAttributeModel data) {
        mTxtTitle.setText(getString(R.string.lbl_subscription_detail));
        mText1.setText(format(R.string.lbl_sub_balance, data.getBalance()));
        mText2.setText(format(R.string.lbl_sub_expiry, data.getExpiryDate()));
        mText3.setText(getString(R.string.msg_auto_renewal));
        mText4.setText(getString(R.string.msg_primary_subscription));
    }

    private void setServiceData(AccountAttributeModel data) {
        mTxtTitle.setText(getString(R.string.lbl_service_detail));
        mText1.setText(format(R.string.lbl_service_msn, data.getMsn()));
        mText2.setText(format(R.string.lbl_service_credit, data.getCredit()));
        mText3.setText(format(R.string.lbl_service_expiry, data.getCreditExpiry()));
    }

    private void setProductData(AccountAttributeModel data) {
        mTxtTitle.setText(getString(R.string.lbl_product_detail));
        mText1.setText(format(R.string.lbl_product_name, data.getProductName()));
        mText2.setText(format(R.string.lbl_product_price, data.getProductPrice()));
    }

    private void setAccountData(AccountAttributeModel data) {
        mTxtTitle.setText(format(R.string.lbl_name, data.getTitle(), data.getFirstName(), data.getLastName()));
        mText1.setText(format(R.string.lbl_dob, data.getDob()));
        mText2.setText(format(R.string.lbl_contact, data.getContactNumber()));
        mText3.setText(format(R.string.lbl_email, data.getEmail()));
    }

    private String getString(int id) {
        return itemView.getResources().getString(id);
    }

    private String format(int formatStringId, Object... arg1) {
        return String.format(getString(formatStringId), arg1);
    }

}
