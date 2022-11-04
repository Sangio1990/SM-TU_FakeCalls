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


public class ProvaCertificateiService {
    public static final String BARCODE = "barcode";
    public static final String MARCA = "marca";
    public static final String MODELLO = "modello";
    public static final String SERIALE = "seriale";
    public static final String CERTIFICATE_AND_COMPLIANCE = "cer&com";
    public static final String XFBTALMATCONCERTIFICATENUMBER_COLUMN = "XFBTALMATCONCERTIFICATENUMBER";
    public static final String XFBTALMATCONCERTIFICATEISSUEDATE_COLUMN = "XFBTALMATCONCERTIFICATEISSUEDATE";
    public static final String XFBTALMATCONCERTIFICATEISSUER_COLUMN = "XFBTALMATCONCERTIFICATEISSUER";
    public static final String XFBTALMATCERTIFICATIONNUMBER_COLUMN = "XFBTALMATCERTIFICATIONNUMBER";
    public static final String XFBTALMATLABORATORY_COLUMN = "XFBTALMATLABORATORY";
    public static final String XFBTALMATCALIBRATIONDATE_COLUMN = "XFBTALMATCALIBRATIONDATE";


    private static ServiceConnection mConnection;

    public static void provaService(Activity activity, ProvaDone onProvaDone) {
        mConnection = new ServiceConnection() {
            Messenger mService;

            public void onServiceConnected(ComponentName className, IBinder service) {
                Log.d("MIMMO", "onServiceConnected");
                mService = new Messenger(service);
                Bundle bundle = new Bundle();
                bundle.putString(BARCODE, "987653678");
                bundle.putString(MARCA, "510");
                bundle.putString(MODELLO, "D81CB1");
                bundle.putString(SERIALE, "ME-MIMMO");
                Message msg = Message.obtain(null, 0, 0, 0, bundle);
                msg.setData(bundle);
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
                    Bundle b = msg.getData();
                    Log.d("MIMMO", "messaggio ricevuto");
                    String result = b.containsKey(CERTIFICATE_AND_COMPLIANCE) ? b.getString(CERTIFICATE_AND_COMPLIANCE) : "no results found";
                    onProvaDone.onProvaDone(result);
                }
            }
        };
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("wfm.in.enel.com.smtu", "wfm.in.enel.com.smtu.materiali.CertificateAndComplianceMaterialService"));
        activity.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    public interface ProvaDone {
        void onProvaDone(String json);
    }
}
