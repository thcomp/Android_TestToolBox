package jp.co.thcomp.testtoolbox;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.test.mock.MockContext;

import org.mockito.Mockito;

/**
 * Created by H_Tatsuguchi on 2016/11/11.
 */

abstract public class AbstractActivityTest<TApp extends Application, TAct extends Activity> {
    protected MockSharedPreferences mMockSharedPreferences;
    protected TApp mApplication;
    protected Context mApplicationContext;
    protected Activity mActivity;
    protected FragmentManager mSupportFragmentManager;
    protected android.app.FragmentManager mFragmentManager;

    public AbstractActivityTest(TApp app, Class<TAct> actClass) {
        mMockSharedPreferences = MockSharedPreferences.getGlobalInstance();
        mApplication = app;
        mApplicationContext = new MockContext();
        mSupportFragmentManager = new MockSupportFragmentManager();

        mActivity = Mockito.spy(actClass);
        Mockito.when(mActivity.getApplication()).thenReturn(mApplication);
        Mockito.when(mActivity.getApplicationContext()).thenReturn(mApplicationContext);
        if (mActivity instanceof FragmentActivity) {
            Mockito.when(((FragmentActivity) mActivity).getSupportFragmentManager()).thenReturn(mSupportFragmentManager);
        }

        setMockitoForGetSharedPreferences();
    }

    public Activity getActivity() {
        return mActivity;
    }

    protected void setMockitoForGetSharedPreferences(){
        // TODO 他の引数でも対応できるようにどうにかすべき
        Mockito.when(mActivity.getSharedPreferences("", Context.MODE_PRIVATE)).thenReturn(mMockSharedPreferences);
    }
}
