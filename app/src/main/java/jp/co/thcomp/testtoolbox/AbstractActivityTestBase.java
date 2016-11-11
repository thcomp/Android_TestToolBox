package jp.co.thcomp.testtoolbox;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.test.mock.MockContext;

import org.mockito.Mockito;

/**
 * Created by H_Tatsuguchi on 2016/11/11.
 */

abstract public class AbstractActivityTestBase<TApp extends Application, TAct extends Activity> {
    protected MockSharedPreferences mMockSharedPreferences;
    protected TApp mApplication;
    protected Context mApplicationContext;
    protected Activity mActivity;

    public AbstractActivityTestBase(TApp app, Class<TAct> actClass){
        mMockSharedPreferences = new MockSharedPreferences();
        mApplication = app;
        mApplicationContext = new MockContext();

        mActivity = Mockito.spy(actClass);
        Mockito.when(mActivity.getApplication()).thenReturn(mApplication);
        Mockito.when(mActivity.getApplicationContext()).thenReturn(mApplicationContext);

        // TODO 他の引数でも対応できるようにどうにかすべき
        Mockito.when(mActivity.getSharedPreferences("", Context.MODE_PRIVATE)).thenReturn(mMockSharedPreferences);
    }

    public Activity getActivity(){
        return mActivity;
    }
}
