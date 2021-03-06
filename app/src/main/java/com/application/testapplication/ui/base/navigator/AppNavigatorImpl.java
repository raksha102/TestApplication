
package com.application.testapplication.ui.base.navigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.application.testapplication.application.constants.BundleConstants;
import com.application.testapplication.injection.scope.ActivityScope;
import com.application.testapplication.injection.scope.ContainerId;
import com.application.testapplication.ui.base.BaseActivity;
import com.application.testapplication.ui.home.HomeScreenFragment;
import com.application.testapplication.ui.home.SplashScreenFragment;
import com.application.testapplication.ui.login.LoginFragment;
import com.application.testapplication.utils.IKeyBoardUtil;

import javax.inject.Inject;

@ActivityScope
public class AppNavigatorImpl implements AppNavigator {

    private final IKeyBoardUtil mKeyBoardUtil;
    private FragmentActivity mActivity;
    private int mContainerId;

    @Inject
    public AppNavigatorImpl(BaseActivity context, @ContainerId int containerId, IKeyBoardUtil keyBoardUtil) {
        mActivity = context;
        mContainerId = containerId;
        mKeyBoardUtil = keyBoardUtil;
    }

    @Override
    public void launchLoginScreen() {
        replaceFragment(mContainerId, LoginFragment.newInstance());
    }

    @Override
    public void launchWelcomeScreen() {
        replaceFragment(mContainerId, SplashScreenFragment.newInstance());
    }

    @Override
    public void launchSubscriptionScreen() {
        replaceFragment(mContainerId, HomeScreenFragment.newInstance());
    }

    @Override
    public void hideKeyBoard() {
        mKeyBoardUtil.hideSoftKeyboard(mActivity);
    }

    // Internal Implementation
    // below code can be moved to separate class for optimization

    private void startActivity(@NonNull Class<? extends Activity> activityClass, Bundle args, Integer requestCode) {
        Intent intent = new Intent();
        intent.putExtra(BundleConstants.EXTRA_ARG, args);
        startActivityInternal(activityClass, intent, requestCode);
    }

    private void addFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment, String backStackTag) {
        addFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, null, null, true, backStackTag);
    }

    private void addFragmentAndAddToBackStack(@IdRes int containerId, @NonNull Fragment fragment) {
        addFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, null, null, true, null);
    }

    private final void replaceFragment(@IdRes int containerId, Fragment fragment) {
        replaceFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, null, null, false, null);
    }

    public final void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag) {
        replaceFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, fragmentTag, null, false, null);
    }

    private final void replaceFragmentAndAddToBackStack(@IdRes int containerId, Fragment fragment, String backStackTag) {
        replaceFragmentInternal(mActivity.getSupportFragmentManager(), containerId, fragment, null, null, true, backStackTag);
    }


    //

    private void startActivityInternal(Class<? extends Activity> activityClass, Intent setArgsAction, Integer requestCode) {
        Intent intent = new Intent(mActivity, activityClass);
        intent.putExtras(setArgsAction.getExtras());
        if (requestCode != null) {
            mActivity.startActivityForResult(intent, requestCode);
        } else {
            mActivity.startActivity(intent);
        }
    }

    private final void replaceFragmentInternal(FragmentManager fm, @IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args, boolean addToBackstack, String backstackTag) {
        if (mActivity.isFinishing()) return;

        if (args != null) {
            fragment.setArguments(args);
        }
        FragmentTransaction ft = fm.beginTransaction().replace(containerId, fragment, fragmentTag);
        if (addToBackstack) {
            ft.addToBackStack(backstackTag).commitAllowingStateLoss();
            fm.executePendingTransactions();
        } else {
            ft.commitAllowingStateLoss();
        }
    }

    private final void addFragmentInternal(FragmentManager fm, @IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args, boolean addToBackstack, String backstackTag) {
        if (mActivity.isFinishing()) return;
        if (args != null) {
            fragment.setArguments(args);
        }
        FragmentTransaction ft = fm.beginTransaction().add(containerId, fragment, fragmentTag);
        if (addToBackstack) {
            ft.addToBackStack(backstackTag).commitAllowingStateLoss();
            fm.executePendingTransactions();
        } else {
            ft.commitAllowingStateLoss();
        }
    }
}
