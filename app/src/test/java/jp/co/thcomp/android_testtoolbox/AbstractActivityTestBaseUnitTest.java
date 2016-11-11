package jp.co.thcomp.android_testtoolbox;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import org.junit.Test;

import jp.co.thcomp.testtoolbox.AbstractActivityTestBase;
import jp.co.thcomp.testtoolbox.MockSharedPreferences;

/**
 * Created by H_Tatsuguchi on 2016/11/11.
 */

public class AbstractActivityTestBaseUnitTest {
    private LocalActivityTest mLocalActivityTest;
    private TargetApplication mApp;
    private Activity mActivity;

    public AbstractActivityTestBaseUnitTest() {
        mApp = new TargetApplication();
        mLocalActivityTest = new LocalActivityTest(mApp, TargetActivity.class);
        mActivity = mLocalActivityTest.getActivity();
    }

    @Test
    public void test() throws Exception {
        assert mActivity instanceof TargetActivity;
        assert mActivity.getApplication() instanceof TargetApplication;
        assert mActivity.getSharedPreferences("", Context.MODE_PRIVATE) instanceof MockSharedPreferences;
    }

    private class LocalActivityTest extends AbstractActivityTestBase<TargetApplication, TargetActivity>{
        public LocalActivityTest(TargetApplication targetApplication, Class<TargetActivity> targetActivityClass) {
            super(targetApplication, targetActivityClass);
        }
    }

    public static class TargetApplication extends Application {

    }

    public static class TargetActivity extends Activity{

    }
}
