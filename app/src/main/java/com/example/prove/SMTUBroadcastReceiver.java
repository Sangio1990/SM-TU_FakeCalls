package com.example.prove;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

public class SMTUBroadcastReceiver extends BroadcastReceiver {

    public static final String SMTU_INTENT_FILTER_PICTURE = "com.example.prove.picture";
    public static final String SMTU_INTENT_FILTER_VIDEO = "com.example.prove.video";

    private SMTUCallBack smtuCallBack;


    @Override
    public void onReceive(Context context, @NonNull Intent intent) {
        if (smtuCallBack != null) {
            if (intent.getExtras() != null && intent.getAction() != null) {
                switch (intent.getAction()) {
                    case SMTU_INTENT_FILTER_PICTURE:
                        Uri data = intent.getData();
                        smtuCallBack.onImageRecieverd(data);
                        break;
                    case SMTU_INTENT_FILTER_VIDEO:
                        break;
                    default:
                }
            }
            smtuCallBack = null;
        } else Log.i("MIMMO", "SIRED CALLBACK NULL");
    }

    public void setSmtuCallBack(SMTUCallBack smtuCallBack) {
        this.smtuCallBack = smtuCallBack;
    }

    public interface SMTUCallBack {
        void onImageRecieverd(Uri image);
    }
}