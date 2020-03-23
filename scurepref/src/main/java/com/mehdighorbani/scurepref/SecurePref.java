package com.mehdighorbani.scurepref;

import android.content.Context;
import android.content.ContextWrapper;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;
import com.pixplicity.easyprefs.library.Prefs;


public class SecurePref {


    public static void initialize(Context context, String iv, String secretKey) {

        new Prefs.Builder()
                .setContext(context)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(context.getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        if (iv != null) MCrypt.setIvKey(iv);
        if (secretKey != null) MCrypt.setSecretKey(secretKey);


    }

    public static void put(String key, Object object) throws Exception {


        String value = new Gson().toJson(object);
        String encrypt = new MCrypt().encrypt(value);
        Prefs.putString(key, encrypt);


    }

    public static <T> T get(String key, Class<T> classOfT) {

        Object object = null;
        try {
            object = new Gson().fromJson(new MCrypt().decrypt(Prefs.getString(key, null)), classOfT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Primitives.wrap(classOfT).cast(object);
    }

    public static void putString(String key, String value) throws Exception {

        String encrypt = new MCrypt().encrypt(value);
        Prefs.putString(key, encrypt);
    }

    public static String getString(String key, String defValue) throws Exception {

        return new MCrypt().decrypt(Prefs.getString(key, defValue));


    }

    public static void putInt(String key, int value) throws Exception {

        String encrypt = new MCrypt().encrypt(String.valueOf(value));
        Prefs.putString(key, encrypt);
    }

    public static int getInt(String key) throws Exception {

        return Integer.valueOf(new MCrypt().decrypt(Prefs.getString(key, null)));


    }

    public static void putLong(String key, long value) throws Exception {

        String encrypt = new MCrypt().encrypt(String.valueOf(value));
        Prefs.putString(key, encrypt);
    }

    public static long getLong(String key) throws Exception {

        return Long.valueOf(new MCrypt().decrypt(Prefs.getString(key, null)));


    }

    public static void putDouble(String key, Double value) throws Exception {

        String encrypt = new MCrypt().encrypt(String.valueOf(value));
        Prefs.putString(key, encrypt);
    }

    public static Double getDouble(String key) throws Exception {

        return Double.valueOf(new MCrypt().decrypt(Prefs.getString(key, null)));


    }

    public static void putFloat(String key, Float value) throws Exception {

        String encrypt = new MCrypt().encrypt(String.valueOf(value));
        Prefs.putString(key, encrypt);
    }

    public static Float getFloat(String key) throws Exception {


        return Float.valueOf(new MCrypt().decrypt(Prefs.getString(key, null)));


    }

    public static void putBoolean(String key, Boolean value) throws Exception {

        String encrypt = new MCrypt().encrypt(String.valueOf(value));
        Prefs.putString(key, encrypt);
    }

    public static Boolean getBoolean(String key) throws Exception {

        return Boolean.valueOf(new MCrypt().decrypt(Prefs.getString(key, null)));


    }


}
