package jp.co.thcomp.android_testtoolbox;

import android.content.SharedPreferences;

import org.junit.Test;

import jp.co.thcomp.testtoolbox.MockSharedPreferences;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MockSharedPreferencesUnitTest {

    @Test
    public void testIntegerValue() throws Exception {
        MockSharedPreferences preferences = new MockSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("test", 1);
        assert preferences.getInt("test", 0) != 1;
        editor.apply();
        assert preferences.getInt("test", 0) == 1;
    }

    @Test
    public void testFloatValue() throws Exception {
        MockSharedPreferences preferences = new MockSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();

        editor.putFloat("test", 1f);
        assert preferences.getFloat("test", 0f) != 1f;
        editor.apply();
        assert preferences.getFloat("test", 0f) == 1f;
    }

    @Test
    public void testStringValue() throws Exception {
        MockSharedPreferences preferences = new MockSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("test", "1");
        assert !preferences.getString("test", "0").equals("1");
        editor.apply();
        assert preferences.getString("test", "0").equals("1");
    }

    @Test
    public void testBooleanValue() throws Exception {
        MockSharedPreferences preferences = new MockSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean("test", true);
        assert !preferences.getBoolean("test", false);
        editor.apply();
        assert preferences.getBoolean("test", false);
    }

    @Test
    public void testLongValue() throws Exception {
        MockSharedPreferences preferences = new MockSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();

        editor.putLong("test", 1);
        assert preferences.getLong("test", 0) != 1;
        editor.apply();
        assert preferences.getLong("test", 0) == 1;
    }

    @Test
    public void testContainAndRemove() throws Exception {
        MockSharedPreferences preferences = new MockSharedPreferences();
        SharedPreferences.Editor editor = preferences.edit();

        assert !preferences.contains("test");
        editor.putLong("test", 1);
        editor.apply();
        assert preferences.contains("test");
        editor.remove("test");
        assert preferences.contains("test");
        editor.apply();
        assert !preferences.contains("test");
        editor.putLong("test", 2);
        editor.putLong("test2", 2);
        editor.putLong("test3", 2);
        editor.putLong("test4", 2);

        editor.apply();
        editor.clear();
        // applyしていないのでcontainsはtrueを返却する必要がある
        assert preferences.contains("test");
        assert preferences.contains("test2");
        assert preferences.contains("test3");
        assert preferences.contains("test4");

        editor.apply();
        assert !preferences.contains("test");
        assert !preferences.contains("test2");
        assert !preferences.contains("test3");
        assert !preferences.contains("test4");
    }
}
