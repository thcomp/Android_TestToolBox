package jp.co.thcomp.android_testtoolbox;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import org.junit.Test;

import jp.co.thcomp.testtoolbox.AbstractActivityTest;
import jp.co.thcomp.testtoolbox.AbstractSupportFragmentTest;
import jp.co.thcomp.testtoolbox.MockSharedPreferences;
import jp.co.thcomp.testtoolbox.MockSupportFragmentManager;

/**
 * Created by H_Tatsuguchi on 2016/11/11.
 */

public class AbstractSupportFragmentTestUnitTest {
    private LocalActivityTest mLocalActivityTest;
    private LocalSupportFragmentTest mLocalSupportFragmentTest;
    private TargetApplication mApp;
    private Activity mActivity;
    private Fragment mFragment;

    public AbstractSupportFragmentTestUnitTest() {
        mApp = new TargetApplication();
        mLocalActivityTest = new LocalActivityTest(mApp, TargetActivity.class);
        mActivity = mLocalActivityTest.getActivity();
        mLocalSupportFragmentTest = new LocalSupportFragmentTest((FragmentActivity) mActivity, TargetFragment.class);
        mFragment = mLocalSupportFragmentTest.getFragment();
    }

    @Test
    public void test() throws Exception {
        assert mActivity instanceof TargetActivity;
        assert mActivity.getApplication() instanceof TargetApplication;
        assert mActivity.getSharedPreferences("", Context.MODE_PRIVATE) instanceof MockSharedPreferences;
        assert ((TargetActivity) mActivity).getSupportFragmentManager() instanceof MockSupportFragmentManager;
        assert mFragment instanceof TargetFragment;
        assert mFragment.getActivity() instanceof TargetActivity;
// cannot support Fragment.getFragmentManager       assert mFragment.getFragmentManager() instanceof MockSupportFragmentManager;
    }

    private class LocalActivityTest extends AbstractActivityTest<TargetApplication, TargetActivity> {
        public LocalActivityTest(TargetApplication targetApplication, Class<TargetActivity> targetActivityClass) {
            super(targetApplication, targetActivityClass);
        }
    }

    private class LocalSupportFragmentTest extends AbstractSupportFragmentTest<TargetFragment> {
        public LocalSupportFragmentTest(FragmentActivity activity, Class<TargetFragment> targetFragmentClass) {
            super(activity, targetFragmentClass);
        }
    }

    public static class TargetApplication extends Application {

    }

    public static class TargetActivity extends FragmentActivity {

    }

    public static class TargetFragment extends Fragment {

    }
}
