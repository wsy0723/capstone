package com.example.younghyun.bnuts;

/**
 * Created by woo on 16. 5. 19..
 */
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class AlarmReceiver extends WakefulBroadcastReceiver {



    ToggleButton toggle;
    public void onReceive(final Context context, Intent intent) {
        //this will update the UI with message

        AlarmActivity inst = AlarmActivity.instance();
        inst.setAlarmText("Alarm! Wake up! Wake up!");
        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        final Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();

        //this will send a notification message
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
//        toggle = (ToggleButton)context.findViewById(R.id.alarmToggle);
//        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(! isChecked){
//                    ringtone.stop();
//                }
//            }
//        });
    }



}