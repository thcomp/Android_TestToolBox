package jp.co.thcomp.testtoolbox;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by H_Tatsuguchi on 2016/11/19.
 */

public class MockIntent extends Intent {
    private HashMap<String, Object> mValueMap = new HashMap<String, Object>();

    @Override
    public Intent addCategory(String category) {
        return super.addCategory(category);
    }

    @Override
    public Intent addFlags(int flags) {
        return super.addFlags(flags);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public Intent cloneFilter() {
        return super.cloneFilter();
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public int fillIn(Intent other, int flags) {
        return super.fillIn(other, flags);
    }

    @Override
    public boolean filterEquals(Intent other) {
        return super.filterEquals(other);
    }

    @Override
    public int filterHashCode() {
        return super.filterHashCode();
    }

    @Override
    public String getAction() {
        return super.getAction();
    }

    @Override
    public boolean[] getBooleanArrayExtra(String name) {
        return (boolean[]) mValueMap.get(name);
    }

    @Override
    public boolean getBooleanExtra(String name, boolean defaultValue) {
        boolean ret = defaultValue;

        if (mValueMap.containsKey(name)) {
            ret = (boolean) mValueMap.get(name);
        }

        return ret;
    }

    @Override
    public Bundle getBundleExtra(String name) {
        return (Bundle) mValueMap.get(name);
    }

    @Override
    public byte[] getByteArrayExtra(String name) {
        return (byte[]) mValueMap.get(name);
    }

    @Override
    public byte getByteExtra(String name, byte defaultValue) {
        byte ret = defaultValue;

        if (mValueMap.containsKey(name)) {
            ret = (byte) mValueMap.get(name);
        }

        return ret;
    }

    @Override
    public Set<String> getCategories() {
        return super.getCategories();
    }

    @Override
    public char[] getCharArrayExtra(String name) {
        return (char[]) mValueMap.get(name);
    }

    @Override
    public char getCharExtra(String name, char defaultValue) {
        char ret = defaultValue;

        if (mValueMap.containsKey(name)) {
            ret = (char) mValueMap.get(name);
        }

        return ret;
    }

    @Override
    public CharSequence[] getCharSequenceArrayExtra(String name) {
        return (CharSequence[]) mValueMap.get(name);
    }

    @Override
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String name) {
        return (ArrayList<CharSequence>) mValueMap.get(name);
    }

    @Override
    public CharSequence getCharSequenceExtra(String name) {
        return (CharSequence) mValueMap.get(name);
    }

    @Override
    public ClipData getClipData() {
        return super.getClipData();
    }

    @Override
    public ComponentName getComponent() {
        return super.getComponent();
    }

    @Override
    public Uri getData() {
        return super.getData();
    }

    @Override
    public String getDataString() {
        return super.getDataString();
    }

    @Override
    public double[] getDoubleArrayExtra(String name) {
        return (double[]) mValueMap.get(name);
    }

    @Override
    public double getDoubleExtra(String name, double defaultValue) {
        return (double) mValueMap.get(name);
    }

    @Override
    public Bundle getExtras() {
        return super.getExtras();
    }

    @Override
    public int getFlags() {
        return super.getFlags();
    }

    @Override
    public float[] getFloatArrayExtra(String name) {
        return (float[]) mValueMap.get(name);
    }

    @Override
    public float getFloatExtra(String name, float defaultValue) {
        float ret = defaultValue;

        if (mValueMap.containsKey(name)) {
            ret = (float) mValueMap.get(name);
        }

        return ret;
    }

    @Override
    public int[] getIntArrayExtra(String name) {
        return (int[]) mValueMap.get(name);
    }

    @Override
    public ArrayList<Integer> getIntegerArrayListExtra(String name) {
        return (ArrayList<Integer>) mValueMap.get(name);
    }

    @Override
    public int getIntExtra(String name, int defaultValue) {
        int ret = defaultValue;

        if (mValueMap.containsKey(name)) {
            ret = (int) mValueMap.get(name);
        }

        return ret;
    }

    @Override
    public long[] getLongArrayExtra(String name) {
        return (long[]) mValueMap.get(name);
    }

    @Override
    public long getLongExtra(String name, long defaultValue) {
        long ret = defaultValue;

        if (mValueMap.containsKey(name)) {
            ret = (long) mValueMap.get(name);
        }

        return ret;
    }

    @Override
    public String getPackage() {
        return super.getPackage();
    }

    @Override
    public Parcelable[] getParcelableArrayExtra(String name) {
        return (Parcelable[]) mValueMap.get(name);
    }

    @Override
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String name) {
        return (ArrayList<T>) mValueMap.get(name);
    }

    @Override
    public <T extends Parcelable> T getParcelableExtra(String name) {
        return (T) mValueMap.get(name);
    }

    @Override
    public String getScheme() {
        return super.getScheme();
    }

    @Override
    public Intent getSelector() {
        return super.getSelector();
    }

    @Override
    public Serializable getSerializableExtra(String name) {
        return (Serializable) mValueMap.get(name);
    }

    @Override
    public short[] getShortArrayExtra(String name) {
        return (short[]) mValueMap.get(name);
    }

    @Override
    public short getShortExtra(String name, short defaultValue) {
        short ret = defaultValue;

        if (mValueMap.containsKey(name)) {
            ret = (short) mValueMap.get(name);
        }

        return ret;
    }

    @Override
    public Rect getSourceBounds() {
        return super.getSourceBounds();
    }

    @Override
    public String[] getStringArrayExtra(String name) {
        return (String[]) mValueMap.get(name);
    }

    @Override
    public ArrayList<String> getStringArrayListExtra(String name) {
        return (ArrayList<String>) mValueMap.get(name);
    }

    @Override
    public String getStringExtra(String name) {
        return (String) mValueMap.get(name);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public boolean hasCategory(String category) {
        return super.hasCategory(category);
    }

    @Override
    public boolean hasExtra(String name) {
        return super.hasExtra(name);
    }

    @Override
    public boolean hasFileDescriptors() {
        return super.hasFileDescriptors();
    }

    public MockIntent() {
        super();
    }

    public MockIntent(String action) {
        super(action);
    }

    public MockIntent(String action, Uri uri) {
        super(action, uri);
    }

    public MockIntent(String action, Uri uri, Context packageContext, Class<?> cls) {
        super(action, uri, packageContext, cls);
    }

    public MockIntent(Intent o) {
        super(o);
    }

    public MockIntent(Context packageContext, Class<?> cls) {
        super(packageContext, cls);
    }

    @Override
    public Intent putCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, boolean value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, boolean[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, Bundle value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, byte value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, byte[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, char value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, char[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, CharSequence value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, CharSequence[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, double value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, double[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, float value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, float[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, int value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, int[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, long value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, long[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, Parcelable value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, Parcelable[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, Serializable value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, short value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, short[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, String value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtra(String name, String[] value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putExtras(Bundle extras) {
        return super.putExtras(extras);
    }

    @Override
    public Intent putExtras(Intent src) {
        return super.putExtras(src);
    }

    @Override
    public Intent putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public Intent putStringArrayListExtra(String name, ArrayList<String> value) {
        mValueMap.put(name, value);
        return this;
    }

    @Override
    public void readFromParcel(Parcel in) {
        super.readFromParcel(in);
    }

    @Override
    public void removeCategory(String category) {
        super.removeCategory(category);
    }

    @Override
    public void removeExtra(String name) {
        super.removeExtra(name);
    }

    @Override
    public Intent replaceExtras(Bundle extras) {
        return super.replaceExtras(extras);
    }

    @Override
    public Intent replaceExtras(Intent src) {
        return super.replaceExtras(src);
    }

    @Override
    public ComponentName resolveActivity(PackageManager pm) {
        return super.resolveActivity(pm);
    }

    @Override
    public ActivityInfo resolveActivityInfo(PackageManager pm, int flags) {
        return super.resolveActivityInfo(pm, flags);
    }

    @Override
    public String resolveType(Context context) {
        return super.resolveType(context);
    }

    @Override
    public String resolveType(ContentResolver resolver) {
        return super.resolveType(resolver);
    }

    @Override
    public String resolveTypeIfNeeded(ContentResolver resolver) {
        return super.resolveTypeIfNeeded(resolver);
    }

    @Override
    public Intent setAction(String action) {
        return super.setAction(action);
    }

    @Override
    public Intent setClass(Context packageContext, Class<?> cls) {
        return super.setClass(packageContext, cls);
    }

    @Override
    public Intent setClassName(Context packageContext, String className) {
        return super.setClassName(packageContext, className);
    }

    @Override
    public Intent setClassName(String packageName, String className) {
        return super.setClassName(packageName, className);
    }

    @Override
    public void setClipData(ClipData clip) {
        super.setClipData(clip);
    }

    @Override
    public Intent setComponent(ComponentName component) {
        return super.setComponent(component);
    }

    @Override
    public Intent setData(Uri data) {
        return super.setData(data);
    }

    @Override
    public Intent setDataAndNormalize(Uri data) {
        return super.setDataAndNormalize(data);
    }

    @Override
    public Intent setDataAndType(Uri data, String type) {
        return super.setDataAndType(data, type);
    }

    @Override
    public Intent setDataAndTypeAndNormalize(Uri data, String type) {
        return super.setDataAndTypeAndNormalize(data, type);
    }

    @Override
    public void setExtrasClassLoader(ClassLoader loader) {
        super.setExtrasClassLoader(loader);
    }

    @Override
    public Intent setFlags(int flags) {
        return super.setFlags(flags);
    }

    @Override
    public Intent setPackage(String packageName) {
        return super.setPackage(packageName);
    }

    @Override
    public void setSelector(Intent selector) {
        super.setSelector(selector);
    }

    @Override
    public void setSourceBounds(Rect r) {
        super.setSourceBounds(r);
    }

    @Override
    public Intent setType(String type) {
        return super.setType(type);
    }

    @Override
    public Intent setTypeAndNormalize(String type) {
        return super.setTypeAndNormalize(type);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String toURI() {
        return super.toURI();
    }

    @Override
    public String toUri(int flags) {
        return super.toUri(flags);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
    }
}
