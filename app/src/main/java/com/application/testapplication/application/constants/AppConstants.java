package com.application.testapplication.application.constants;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

public class AppConstants {

    public static final String USER_LOGIN_ID = "0468874507";

    @IntDef({SCREEN_LOGIN})
    public @interface SCREEN_TYPE {
    }

    public static final int SCREEN_LOGIN = 101;

    @StringDef({TYPE_ACCOUNT, TYPE_SERVICES, TYPE_SUBSCRIPTIONS, TYPE_PRODUCTS})
    public @interface DATA_TYPE{}

    public static final String  TYPE_ACCOUNT= "accounts";
    public static final String  TYPE_SERVICES= "services";
    public static final String  TYPE_SUBSCRIPTIONS= "subscriptions";
    public static final String  TYPE_PRODUCTS= "products";


}
