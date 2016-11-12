package jp.co.thcomp.testtoolbox;

import android.support.annotation.AnimRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MockSupportFragmentTransaction extends FragmentTransaction {
    @Override
    public FragmentTransaction add(Fragment fragment, String tag) {
        return this;
    }

    @Override
    public FragmentTransaction add(@IdRes int containerViewId, Fragment fragment) {
        return this;
    }

    @Override
    public FragmentTransaction add(@IdRes int containerViewId, Fragment fragment, @Nullable String tag) {
        return this;
    }

    @Override
    public FragmentTransaction replace(@IdRes int containerViewId, Fragment fragment) {
        return this;
    }

    @Override
    public FragmentTransaction replace(@IdRes int containerViewId, Fragment fragment, @Nullable String tag) {
        return this;
    }

    @Override
    public FragmentTransaction remove(Fragment fragment) {
        return this;
    }

    @Override
    public FragmentTransaction hide(Fragment fragment) {
        return this;
    }

    @Override
    public FragmentTransaction show(Fragment fragment) {
        return this;
    }

    @Override
    public FragmentTransaction detach(Fragment fragment) {
        return this;
    }

    @Override
    public FragmentTransaction attach(Fragment fragment) {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public FragmentTransaction setCustomAnimations(@AnimRes int enter, @AnimRes int exit) {
        return this;
    }

    @Override
    public FragmentTransaction setCustomAnimations(@AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        return this;
    }

    @Override
    public FragmentTransaction addSharedElement(View sharedElement, String name) {
        return this;
    }

    @Override
    public FragmentTransaction setTransition(int transit) {
        return this;
    }

    @Override
    public FragmentTransaction setTransitionStyle(@StyleRes int styleRes) {
        return this;
    }

    @Override
    public FragmentTransaction addToBackStack(@Nullable String name) {
        return this;
    }

    @Override
    public boolean isAddToBackStackAllowed() {
        return false;
    }

    @Override
    public FragmentTransaction disallowAddToBackStack() {
        return this;
    }

    @Override
    public FragmentTransaction setBreadCrumbTitle(@StringRes int res) {
        return this;
    }

    @Override
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        return this;
    }

    @Override
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int res) {
        return this;
    }

    @Override
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        return this;
    }

    @Override
    public int commit() {
        return 0;
    }

    @Override
    public int commitAllowingStateLoss() {
        return 0;
    }

    @Override
    public void commitNow() {

    }

    @Override
    public void commitNowAllowingStateLoss() {

    }
}
