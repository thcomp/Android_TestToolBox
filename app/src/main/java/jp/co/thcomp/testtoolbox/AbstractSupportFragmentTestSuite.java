package jp.co.thcomp.testtoolbox;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by H_Tatsuguchi on 2016/11/16.
 */

abstract public class AbstractSupportFragmentTestSuite<TApp extends Application, TAct extends FragmentActivity, TFragment extends Fragment> {
    abstract protected TApp getApplicationInstance();

    abstract protected Class<TAct> getActivityClass();

    abstract protected Class<TFragment> getFragmentClass();

    protected TAct mTestActivity;
    protected TApp mMockApplication;
    protected TFragment mTestFragment;

    public AbstractSupportFragmentTestSuite() {
        mMockApplication = getApplicationInstance();
        Class<TAct> activityClass = getActivityClass();
        Class<TFragment> fragmentClass = getFragmentClass();

        AbstractActivityTest activityTest = new AbstractActivityTest<TApp, TAct>(mMockApplication, activityClass) {
        };
        mTestActivity = (TAct) activityTest.getActivity();
        AbstractSupportFragmentTest fragmentTest = new AbstractSupportFragmentTest(mTestActivity, fragmentClass);
        mTestFragment = (TFragment) fragmentTest.getFragment();

        setMockito(mMockApplication, mTestActivity, mTestFragment);
    }

    protected void setMockito(TApp application, TAct activity, TFragment fragment) {
        // 好きなようにmockitoの設定をオーバーライドして設定
    }
}
