package jp.co.thcomp.testtoolbox;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MockSharedPreferences implements SharedPreferences {
    private HashMap<String, Object> mValueMap = new HashMap<String, Object>();
    private ArrayList<OnSharedPreferenceChangeListener> mListenerList = new ArrayList<OnSharedPreferenceChangeListener>();

    @Override
    public Map<String, ?> getAll() {
        return mValueMap;
    }

    @Nullable
    @Override
    public String getString(String key, String defValue) {
        String value = defValue;

        if (mValueMap.containsKey(key)) {
            value = (String) mValueMap.get(key);
        }

        return value;
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String key, Set<String> defValues) {
        throw new UnsupportedOperationException("this");
    }

    @Override
    public int getInt(String key, int defValue) {
        int value = defValue;

        if (mValueMap.containsKey(key)) {
            value = (int) mValueMap.get(key);
        }

        return value;
    }

    @Override
    public long getLong(String key, long defValue) {
        long value = defValue;

        if (mValueMap.containsKey(key)) {
            value = (long) mValueMap.get(key);
        }

        return value;
    }

    @Override
    public float getFloat(String key, float defValue) {
        float value = defValue;

        if (mValueMap.containsKey(key)) {
            value = (float) mValueMap.get(key);
        }

        return value;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        boolean value = defValue;

        if (mValueMap.containsKey(key)) {
            value = (boolean) mValueMap.get(key);
        }

        return value;
    }

    @Override
    public boolean contains(String key) {
        return mValueMap.containsKey(key);
    }

    @Override
    public Editor edit() {
        return new MockEditor();
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        synchronized (mListenerList) {
            mListenerList.add(listener);
        }
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        synchronized (mListenerList) {
            mListenerList.remove(listener);
        }
    }

    private class MockEditor implements Editor {
        private HashMap<String, Object> mWorkValueMap = new HashMap<String, Object>();
        private ArrayList<String> mRemoveKeyList = new ArrayList<String>();
        private boolean mClearPrefs = false;

        @Override
        public Editor putString(String key, String value) {
            mWorkValueMap.put(key, value);
            return this;
        }

        @Override
        public Editor putStringSet(String key, Set<String> values) {
            throw new UnsupportedOperationException("this");
        }

        @Override
        public Editor putInt(String key, int value) {
            mWorkValueMap.put(key, value);
            return this;
        }

        @Override
        public Editor putLong(String key, long value) {
            mWorkValueMap.put(key, value);
            return this;
        }

        @Override
        public Editor putFloat(String key, float value) {
            mWorkValueMap.put(key, value);
            return this;
        }

        @Override
        public Editor putBoolean(String key, boolean value) {
            mWorkValueMap.put(key, value);
            return this;
        }

        @Override
        public Editor remove(String key) {
            mRemoveKeyList.add(key);
            return this;
        }

        @Override
        public Editor clear() {
            mWorkValueMap.clear();
            mClearPrefs = true;
            return this;
        }

        @Override
        public boolean commit() {
            // mockではファイル書き込みはしないのでcommitはapplyと一緒
            apply();
            return true;
        }

        @Override
        public void apply() {
            if(mClearPrefs){
                mValueMap.clear();
            }else{
                for (Map.Entry<String, Object> entry : mWorkValueMap.entrySet()) {
                    String key = entry.getKey();

                    mValueMap.put(key, entry.getValue());
                    synchronized (mListenerList) {
                        for (OnSharedPreferenceChangeListener listener : mListenerList) {
                            listener.onSharedPreferenceChanged(MockSharedPreferences.this, key);
                        }
                    }
                }

                for(String key : mRemoveKeyList){
                    mValueMap.remove(key);
                }
            }

            mWorkValueMap.clear();
            mRemoveKeyList.clear();
            mClearPrefs = false;

        }
    }
}
