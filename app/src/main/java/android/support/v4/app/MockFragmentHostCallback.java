package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;

/**
 * Created by H_Tatsuguchi on 2016/11/12.
 */

public class MockFragmentHostCallback extends FragmentHostCallback {
    public MockFragmentHostCallback(Activity activity, Context context, Handler handler, int windowAnimations) {
        super(activity, context, handler, windowAnimations);
    }

    public MockFragmentHostCallback(FragmentActivity activity) {
        super(activity);
    }

    public MockFragmentHostCallback(Context context, Handler handler, int windowAnimations) {
        super(context, handler, windowAnimations);
    }

    @Nullable
    @Override
    public Object onGetHost() {
        return null;
    }
}
