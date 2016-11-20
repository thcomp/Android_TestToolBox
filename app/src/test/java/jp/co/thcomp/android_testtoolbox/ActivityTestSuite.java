package jp.co.thcomp.android_testtoolbox;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;

import org.junit.Test;

import jp.co.thcomp.testtoolbox.AbstractActivityTestSuite;
import jp.co.thcomp.testtoolbox.MockIntent;
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

        MockIntent intent = new MockIntent();
        Bundle bundle = new Bundle();
        ParcelableClass instance = new ParcelableClass();

        if(intent == null){
            System.out.println("intent == null");
        }else{
            intent.putExtra("boolean", true);
            intent.putExtra("int", 1);
            intent.putExtra("String", "string is not null");
            System.out.println("boolean = " + intent.getBooleanExtra("boolean", false) + ", int = " + intent.getIntExtra("int", -1) + ", String = " + intent.getStringExtra("String"));
        }
        if(bundle == null){
            System.out.println("bundle == null");
        }else{
            bundle.putBoolean("boolean", true);
            bundle.putInt("int", 1);
            bundle.putString("String", "string is not null");
            System.out.println("boolean = " + bundle.getBoolean("boolean", false) + ", int = " + bundle.getInt("int", -1) + ", String = " + bundle.getString("String"));
        }

        if(instance == null){
            System.out.println("instance == null");
        }
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

    private static class ParcelableClass implements Parcelable{
        public ParcelableClass(){

        }

        protected ParcelableClass(Parcel in) {
        }

        public static final Creator<ParcelableClass> CREATOR = new Creator<ParcelableClass>() {
            @Override
            public ParcelableClass createFromParcel(Parcel in) {
                return new ParcelableClass(in);
            }

            @Override
            public ParcelableClass[] newArray(int size) {
                return new ParcelableClass[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }
    }
}
