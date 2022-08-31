package com.example.prove;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;


public class ProvaService {
    public static final String UO = "uo";
    public static final String IDWOA = "idWoa";
    public static final String APP = "app";
    public static final String LABEL_CIT = "cit";
    public static final String MATERIALI = "materiali";


    private static ServiceConnection mConnection;

    public static void provaService(Activity activity, ProvaDone onProvaDone) {
        mConnection = new ServiceConnection() {
            Messenger mService;

            public void onServiceConnected(ComponentName className, IBinder service) {
                Log.d("MIMMO", "onServiceConnected");
                mService = new Messenger(service);
                Bundle bundle = new Bundle();
                bundle.putString(IDWOA, "987653678");
                bundle.putString(LABEL_CIT, "510");
                bundle.putString(UO, "D81CB1");
                bundle.putString(APP, "ME-MIMMO");
                bundle.putString(MATERIALI, "{   \"materiali\":[\n" +
                        "{\n" +
                        "\"matricolaMateriale\":\"516221\",\n" +
                        "\"qntPosata\":1.0,\n" +
                        "\"qntRecuperata\":0.0,\n" +
                        "\"barcodeMateriali\":[\n" +
                        "{\n" +
                        "\"barcode\":\"1234565162218585956555559\",\n" +
                        "\"matricolaMateriale\":\"516221\",\n" +
                        "\"qntPosata\":1,\n" +
                        "\"qntRecuperata\":0\n" +
                        "}\n" +
                        "]\n" +
                        "},\n" +
                        "{\n" +
                        "\"matricolaMateriale\":\"516250\",\n" +
                        "\"qntPosata\":0.0,\n" +
                        "\"qntRecuperata\":1.0\n" +
                        "},\n" +
                        "{\n" +
                        "\"matricolaMateriale\":\"286101\",\n" +
                        "\"qntPosata\":1.0,\n" +
                        "\"qntRecuperata\":0.0\n" +
                        "}\n" +
                        "]\n" +
                        "}");
                Message msg = Message.obtain(null, 0, 0, 0, bundle);
                msg.replyTo = new Messenger(new IncomingHandler(activity));
                try {
                    mService.send(msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            public void onServiceDisconnected(ComponentName className) {
                Log.d("MIMMO", "onServiceDisconnected");
            }

            class IncomingHandler extends Handler {
                private Context applicationContext;

                public IncomingHandler(Context applicationContext) {
                    this.applicationContext = applicationContext;
                }

                @Override
                public void handleMessage(Message msg) {
                    Bundle b = (Bundle) msg.obj;
                    Log.d("MIMMO", "messaggio ricevuto");
                    onProvaDone.onProvaDone();
                }
            }
        };
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("wfm.in.enel.com.smtu", "wfm.in.enel.com.smtu.materiali.UploadMaterialService"));
        activity.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    public interface ProvaDone {
        void onProvaDone();
    }
}
