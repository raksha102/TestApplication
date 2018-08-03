package com.application.testapplication.utils;

import com.application.testapplication.application.MIVIApplication;
import com.application.testapplication.application.constants.AppConstants;
import com.application.testapplication.injection.scope.ApplicationScope;
import com.application.testapplication.ui.model.data.AccountAttributeModel;
import com.application.testapplication.ui.model.data.UserAccountModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@ApplicationScope
public class DataParser {

    private final FileUtil mFileUtil;
    private final UserAccountModel mUserAccountModel;
    private String mMsnId;

    @Inject
    public DataParser(FileUtil fileUtil) {
        mFileUtil = fileUtil;
        mUserAccountModel = parseData();
    }

    private UserAccountModel parseData() {
        UserAccountModel userAccountModel = new UserAccountModel();
        try {
            InputStream inputStream =
                    MIVIApplication.getApplicationInstance().getAssets().open("collection.json");
            String jsonString = mFileUtil.readFromFle(inputStream);
            JSONObject accountObj = new JSONObject(jsonString);
            List<AccountAttributeModel> list = new ArrayList<>();
            JSONObject dataObj = accountObj.getJSONObject("data");
            list.add(parseJsonObjectData(dataObj));
            JSONArray includedObj = accountObj.getJSONArray("included");
            for (int i = 0; i < includedObj.length(); i++) {
                list.add(parseJsonObjectData((JSONObject) includedObj.get(i)));
            }
            userAccountModel.setData(list);

        } catch (IOException io) {
            io.printStackTrace();
        } catch (JSONException je) {
            je.printStackTrace();
        }
        return userAccountModel;
    }

    private AccountAttributeModel parseJsonObjectData(JSONObject dataObj) throws JSONException {
        AccountAttributeModel model = new AccountAttributeModel();
        String type = dataObj.getString("type");
        model.setType(type);
        JSONObject attributeObj = dataObj.getJSONObject("attributes");

        if (AppConstants.TYPE_ACCOUNT.equalsIgnoreCase(type)) {
            model.setFirstName(attributeObj.getString("first-name"));
            model.setLastName(attributeObj.getString("last-name"));
            model.setTitle(attributeObj.getString("title"));
            model.setDob(attributeObj.getString("date-of-birth"));
            model.setContactNumber(attributeObj.getString("contact-number"));
            model.setEmail(attributeObj.getString("email-address"));
            model.setPaymentType(attributeObj.getString("payment-type"));
        }

        if (AppConstants.TYPE_SERVICES.equalsIgnoreCase(type)) {
            model.setCredit(attributeObj.getInt("credit"));
            model.setCreditExpiry(attributeObj.getString("credit-expiry"));
            mMsnId = attributeObj.getString("msn");
            model.setMsn(mMsnId);
        }

        if (AppConstants.TYPE_PRODUCTS.equalsIgnoreCase(type)) {
            model.setProductName(getString(attributeObj, "name"));
            model.setProductPrice(getInt(attributeObj, "price"));
            model.setUnlimitedTalk(attributeObj.getBoolean("unlimited-talk"));
            model.setUnlimitedText(attributeObj.getBoolean("unlimited-text"));
            model.setUnlimitedIntTalk(attributeObj.getBoolean("unlimited-international-talk"));
            model.setUnlimitedIntText(attributeObj.getBoolean("unlimited-international-text"));
        }

        if (AppConstants.TYPE_SUBSCRIPTIONS.equalsIgnoreCase(type)) {
            model.setAutoRenewal(getBoolean(attributeObj, "auto-renewal"));
            model.setPrimarySubscription(getBoolean(attributeObj, "primary-subscription"));
            model.setBalance(getInt(attributeObj, "included-data-balance"));
            model.setExpiryDate(getString(attributeObj, "expiry-date"));
        }

        return model;
    }

    private boolean getBoolean(JSONObject obj, String key) throws JSONException {
        if (obj.has(key) && !obj.isNull(key))
            return obj.getBoolean(key);
        return false;
    }

    private String getString(JSONObject obj, String key) throws JSONException {
        if (obj.has(key) && !obj.isNull(key))
            return obj.getString(key);
        return null;
    }

    private int getInt(JSONObject obj, String key) throws JSONException {
        if (obj.has(key) && !obj.isNull(key))
            return obj.getInt(key);
        return -1;
    }

    public UserAccountModel getUserData() {
        return mUserAccountModel;
    }

    public String getMsnId() {
        return mMsnId;
    }
}
