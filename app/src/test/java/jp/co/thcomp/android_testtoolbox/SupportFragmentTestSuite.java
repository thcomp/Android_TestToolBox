package jp.co.thcomp.android_testtoolbox;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import org.junit.Test;

import jp.co.thcomp.testtoolbox.AbstractSupportFragmentTestSuite;
import jp.co.thcomp.testtoolbox.MockSharedPreferences;
import jp.co.thcomp.testtoolbox.MockSupportFragmentManager;

/**
 * Created by H_Tatsuguchi on 2016/11/16.
 */

public class SupportFragmentTestSuite extends AbstractSupportFragmentTestSuite<SupportFragmentTestSuite.TargetApplication, SupportFragmentTestSuite.TargetActivity, SupportFragmentTestSuite.TargetFragment> {

    @Test
    public void test() throws Exception {
        assert mTestActivity instanceof TargetActivity;
        assert mTestActivity.getApplication() instanceof TargetApplication;
        assert mTestActivity.getSharedPreferences("", Context.MODE_PRIVATE) instanceof MockSharedPreferences;
        assert ((TargetActivity) mTestActivity).getSupportFragmentManager() instanceof MockSupportFragmentManager;
        assert mTestFragment instanceof TargetFragment;
        assert mTestFragment.getActivity() instanceof TargetActivity;
// cannot support Fragment.getFragmentManager       assert mFragment.getFragmentManager() instanceof MockSupportFragmentManager;
    }

    @Override
    protected TargetApplication getApplicationInstance() {
        return new TargetApplication();
    }

    @Override
    protected Class<TargetActivity> getActivityClass() {
        return TargetActivity.class;
    }

    @Override
    protected Class<TargetFragment> getFragmentClass() {
        return TargetFragment.class;
    }

    public static class TargetApplication extends Application {

    }

    public static class TargetActivity extends FragmentActivity {

    }

    public static class TargetFragment extends Fragment {

    }
}
