package com.application.testapplication.ui;

import com.application.testapplication.ui.base.BaseActivity;

public class MIVIActivity extends BaseActivity {

    @Override
    protected void initViews() {
        getNavigator().launchLoginScreen();
    }
}
