package com.mehdighorbani.securepref;

import android.app.Application;

import com.mehdighorbani.scurepref.SecurePref;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SecurePref.initialize(getApplicationContext(), "Hu27jf!:nV,K6C78", "_].MF6p#N7K*b^3j");
    }
}
