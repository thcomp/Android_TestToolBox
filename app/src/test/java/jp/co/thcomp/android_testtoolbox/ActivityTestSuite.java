package jp.co.thcomp.android_testtoolbox;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import org.junit.Test;

import jp.co.thcomp.testtoolbox.AbstractActivityTestSuite;
import jp.co.thcomp.testtoolbox.MockSharedPreferences;

/**
 * Created by H_Tatsuguchi on 2016/11/16.
 */

public class ActivityTestSuite extends AbstractActivityTestSuite<ActivityTestSuite.TargetApplication, ActivityTestSuite.TargetActivity> {

    @Test
    public void test() throws Exception {
        assert mTestActivity instanceof TargetActivity;
        assert mTestActivity.getApplication() instanceof TargetApplication;
        assert mTestActivity.getSharedPreferences("", Context.MODE_PRIVATE) instanceof MockSharedPreferences;
    }

    @Override
    protected TargetApplication getApplicationInstance() {
        return new TargetApplication();
    }

    @Override
    protected Class<TargetActivity> getActivityClass() {
        return TargetActivity.class;
    }

    public static class TargetApplication extends Application {

    }

    public static class TargetActivity extends FragmentActivity{

    }
}
