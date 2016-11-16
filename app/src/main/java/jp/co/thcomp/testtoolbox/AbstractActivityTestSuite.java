package jp.co.thcomp.testtoolbox;

import android.app.Activity;
import android.app.Application;

abstract public class AbstractActivityTestSuite<TApp extends Application, TAct extends Activity> {

    abstract protected TApp getApplicationInstance();
    abstract protected Class<TAct> getActivityClass();

    protected TAct mTestActivity;
    protected TApp mMockApplication;

    public AbstractActivityTestSuite(){
        mMockApplication = getApplicationInstance();
        Class<TAct> activityClass = getActivityClass();

        AbstractActivityTest activityTest = new AbstractActivityTest(mMockApplication, activityClass){};
        mTestActivity = (TAct) activityTest.getActivity();

        setMockito(mMockApplication, mTestActivity);
    }

    protected void setMockito(TApp application, TAct activity){
        // 好きなようにmockitoの設定をオーバーライドして設定
    }
}
