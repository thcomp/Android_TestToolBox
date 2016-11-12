package jp.co.thcomp.testtoolbox;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class MockSupportFragmentManager extends FragmentManager {
    protected List<Fragment> mFragmentList = null;
    protected HashMap<String, Fragment.SavedState> mSaveFragmentStateMap = new HashMap<String, Fragment.SavedState>();
    protected HashMap<Fragment.SavedState, Fragment> mSaveFragmentMap = new HashMap<Fragment.SavedState, Fragment>();
    protected List<OnBackStackChangedListener> mListenerList = new ArrayList<OnBackStackChangedListener>();

    public MockSupportFragmentManager() {
        mFragmentList = getFragments();
        if(mFragmentList == null){
            mFragmentList = new ArrayList<Fragment>();
        }
    }

    @Override
    public FragmentTransaction beginTransaction() {
        return new MockSupportFragmentTransaction();
    }

    @Override
    public boolean executePendingTransactions() {
        return false;
    }

    @Override
    public Fragment findFragmentById(@IdRes int id) {
        Fragment ret = null;

        for(Fragment fragment : mFragmentList){
            if(fragment.getId() == id){
                ret = fragment;
                break;
            }
        }

        return ret;
    }

    @Override
    public Fragment findFragmentByTag(String tag) {
        Fragment ret = null;

        for(Fragment fragment : mFragmentList){
            if(fragment.getTag().equals(tag)){
                ret = fragment;
                break;
            }
        }

        return ret;
    }

    @Override
    public void popBackStack() {
        popBackStackImmediate();
    }

    @Override
    public boolean popBackStackImmediate() {

        mFragmentList.add(mFragmentList.remove(0));
        return true;
    }

    @Override
    public void popBackStack(String name, int flags) {
        popBackStackImmediate(name, flags);
    }

    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        Fragment[] fragments = mFragmentList.toArray(new Fragment[mFragmentList.size()]);
        boolean ret = false;

        for(Fragment fragment : fragments){
            if(name.equals(fragment.getTag())){
                mFragmentList.remove(fragment);
                mFragmentList.add(fragment);
                ret = true;
                break;
            }
        }

        return ret;
    }

    @Override
    public void popBackStack(int id, int flags) {
        popBackStackImmediate(id, flags);
    }

    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        Fragment[] fragments = mFragmentList.toArray(new Fragment[mFragmentList.size()]);
        boolean ret = false;

        for(Fragment fragment : fragments){
            if(id == fragment.getId()){
                mFragmentList.remove(fragment);
                mFragmentList.add(fragment);
                ret = true;
                break;
            }
        }

        return ret;
    }

    @Override
    public int getBackStackEntryCount() {
        // FIXME
        return 0;
    }

    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        // FIXME
        return null;
    }

    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        mListenerList.add(listener);
    }

    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        mListenerList.remove(listener);
    }

    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        Fragment.SavedState state = mSaveFragmentStateMap.get(key);

        if(state == null) {
            Parcel tempParcel = Parcel.obtain();
            tempParcel.writeBundle(bundle);
            state = Fragment.SavedState.CREATOR.createFromParcel(tempParcel);
            mSaveFragmentStateMap.put(key, state);
        }

        mSaveFragmentMap.put(state, fragment);
    }

    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        Fragment.SavedState state = mSaveFragmentStateMap.get(key);
        Fragment ret = null;

        if(state != null){
            ret = mSaveFragmentMap.get(state);
        }

        return ret;
    }

    @Override
    public List<Fragment> getFragments() {
        return mFragmentList;
    }

    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment f) {
        Parcel tempParcel = Parcel.obtain();
        tempParcel.writeBundle(new Bundle());
        return Fragment.SavedState.CREATOR.createFromParcel(tempParcel);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        // FIXME
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
