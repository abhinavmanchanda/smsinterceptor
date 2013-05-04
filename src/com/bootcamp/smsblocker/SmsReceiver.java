package com.bootcamp.smsblocker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.Gravity;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "This is indeed an sms", Toast.LENGTH_SHORT).show();
        System.out.println("++++++++++++++++++++++++++");
        Bundle bundle = intent.getExtras();
        Object messages[] = (Object[]) bundle.get("pdus");
        SmsMessage smsMessage[] = new SmsMessage[messages.length];
        for (int n = 0; n < messages.length; n++) {
            smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
        }
        String incomingNumber = smsMessage[0].getOriginatingAddress();
        Toast.makeText(context, "This is indeed a phone number - " + incomingNumber, Toast.LENGTH_SHORT).show();
        System.out.println("++++++++++++++++"+ incomingNumber);
        abortBroadcast();
    }


}
