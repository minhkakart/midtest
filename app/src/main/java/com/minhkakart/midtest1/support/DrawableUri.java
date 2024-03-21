package com.minhkakart.midtest1.support;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.minhkakart.midtest1.R;

import java.lang.reflect.Field;

public class DrawableUri {
    public static Uri getDrawableUri (String resName, Context context){
        return Uri.parse("android.resource://"  + context.getPackageName() + "/" + getResId(resName));
    }
    public static int getResId(String resName) {
        try {
            Field idField = R.drawable.class.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            Log.e("Product Adapter", "getResId: ", e);
            return -1;
        }
    }
}
