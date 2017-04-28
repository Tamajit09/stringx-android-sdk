package android.support.v7.app;


import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Window;

import mobi.klimaszewski.linguist.LinguistFactory;

public class LinguistAppCompatDelegate extends AppCompatDelegateImplV9 {


    public LinguistAppCompatDelegate(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }

    @Override
    public void installViewFactory() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (layoutInflater.getFactory() == null) {
            LayoutInflaterCompat.setFactory(layoutInflater, new LinguistFactory(this));
        } else {
            if (!(LayoutInflaterCompat.getFactory(layoutInflater)
                    instanceof AppCompatDelegateImplV9)) {
                Log.i(TAG, "The Activity's LayoutInflater already has a Factory installed"
                        + " so we can not install AppCompat's");
            }
        }

    }
}
