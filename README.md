# Android_TestToolBox
JUnitでAndroidのコードを試験する際に役に立つものを追加していく。

## MockSharedPreferences
試験対象のコードにSharedPreferencesへのアクセスが存在しているとJUnit上では正常に動作しないことがある。
その場合に以下のようなコードを記載し、LocalTestActivityを引き渡すことで解消することを目指す。
---------------------------------
public class LocalTestActivity extends TestActivity{    // TestActivityが試験対象のActivity
    private MockSharedPreferences mPreferences = new MockSharedPreferences();

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return mPreferences;
    }
}
---------------------------------
