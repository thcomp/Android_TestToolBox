package jp.co.thcomp.testtoolbox;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.MockFragmentHostCallback;

import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by H_Tatsuguchi on 2016/11/12.
 */

public class AbstractSupportFragmentTest<SpFragment extends Fragment> {
    protected FragmentActivity mActivity;
    protected Fragment mFragment;

    public AbstractSupportFragmentTest(FragmentActivity activity, Class<SpFragment> fragmentClass) {
        mActivity = activity;

        boolean useReflection = false;
        try {
            mFragment = Mockito.spy(fragmentClass);
            Mockito.when(mFragment.getFragmentManager()).thenReturn(mActivity.getSupportFragmentManager());
            Mockito.when(mFragment.getActivity()).thenReturn(mActivity);
        }catch(Exception e){
            useReflection = true;
        }

        if(useReflection){
            try {
                Constructor constructor = fragmentClass.getConstructor();
                mFragment = (Fragment) constructor.newInstance();

                MockFragmentHostCallback host = new MockFragmentHostCallback(activity);
                Field hostField = Fragment.class.getDeclaredField("mHost");
                hostField.setAccessible(true);
                hostField.set(mFragment, host);

//                Field fragmentManagerField = Fragment.class.getDeclaredField("mFragmentManager");
//                fragmentManagerField.setAccessible(true);
//                fragmentManagerField.set(mFragment, activity.getSupportFragmentManager());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    public Fragment getFragment() {
        return mFragment;
    }
}
