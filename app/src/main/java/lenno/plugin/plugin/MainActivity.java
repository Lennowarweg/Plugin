package lenno.plugin.plugin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean headphones = true;
    AudioManager audioManager;
    MediaPlayer mp = new MediaPlayer();
    HeadsetIntentReceiver receiver = new HeadsetIntentReceiver();
    Random rand = new Random();
    PowerReceiver powerReceiver = new PowerReceiver();
    public class HeadsetIntentReceiver extends BroadcastReceiver {

        public HeadsetIntentReceiver() {

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
                int state = intent.getIntExtra("state", -1);
                switch (state) {
                    case (0):
                        break;
                    case (1):
                        int n = rand.nextInt(2);


                        switch (n) {
                            case 0:
                                if(headphones) {
                                    audioManager.setMode(AudioManager.MODE_NORMAL);
                                    audioManager.setSpeakerphoneOn(false);
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_1);
                                    mp.start();

                                } else {
                                    audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                                    audioManager.setSpeakerphoneOn(true);
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_1);
                                    addListener(mp);
                                    mp.start();
                                }
                                break;
                            case 1:
                                if(headphones) {
                                    audioManager.setMode(AudioManager.MODE_NORMAL);
                                    audioManager.setSpeakerphoneOn(false);
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_2);
                                    mp.start();
                                } else {
                                    audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                                    audioManager.setSpeakerphoneOn(true);
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_2);
                                    addListener(mp);
                                    mp.start();
                                }

                                break;

                            case 2:
                                if(headphones) {
                                    audioManager.setMode(AudioManager.MODE_NORMAL);
                                    audioManager.setSpeakerphoneOn(false);
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_3);
                                    mp.start();
                                } else {
                                    audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                                    audioManager.setSpeakerphoneOn(true);
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_3);
                                    addListener(mp);
                                    mp.start();
                                }
                                break;

                            case 3:
                                if(headphones) {
                                    audioManager.setMode(AudioManager.MODE_NORMAL);
                                    audioManager.setSpeakerphoneOn(false);
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_4);
                                    mp.start();
                                } else {
                                    audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                                    audioManager.setSpeakerphoneOn(true);
                                    mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_4);
                                    addListener(mp);
                                    mp.start();
                                }
                                break;
                        }


                        break;
                }
            }
        }
    }

    public class PowerReceiver extends BroadcastReceiver {

        @Override public void onReceive(Context context, Intent intent) {
            if(intent.getAction() == Intent.ACTION_POWER_CONNECTED) {
                int n = rand.nextInt(3);

                switch (n) {
                    case 0:
                        if(headphones) {
                            audioManager.setMode(AudioManager.MODE_NORMAL);
                            audioManager.setSpeakerphoneOn(false);
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_1);
                            mp.start();

                        } else {
                            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                            audioManager.setSpeakerphoneOn(true);
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_1);
                            addListener(mp);
                            mp.start();
                        }
                        break;
                    case 1:
                        if(headphones) {
                            audioManager.setMode(AudioManager.MODE_NORMAL);
                            audioManager.setSpeakerphoneOn(false);
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_2);
                            mp.start();
                        } else {
                            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                            audioManager.setSpeakerphoneOn(true);
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_2);
                            addListener(mp);
                            mp.start();
                        }

                        break;

                    case 2:
                        if(headphones) {
                            audioManager.setMode(AudioManager.MODE_NORMAL);
                            audioManager.setSpeakerphoneOn(false);
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_3);
                            mp.start();
                        } else {
                            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                            audioManager.setSpeakerphoneOn(true);
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_3);
                            addListener(mp);
                            mp.start();
                        }
                        break;

                    case 3:
                        if(headphones) {
                            audioManager.setMode(AudioManager.MODE_NORMAL);
                            audioManager.setSpeakerphoneOn(false);
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_4);
                            mp.start();
                        } else {
                            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
                            audioManager.setSpeakerphoneOn(true);
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.sound_file_4);
                            addListener(mp);
                            mp.start();
                        }
                        break;
                }
            }
        }
    }




    public void onClick1(View view) {
        Switch mswitch = (Switch) findViewById(R.id.switch1);
        if(mswitch.isChecked()) {
            headphones = true;
        }   else {
            headphones = false;
        }
    }

    public void addListener(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.stop();
                audioManager.setMode(AudioManager.MODE_NORMAL);
                audioManager.setSpeakerphoneOn(false);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
        registerReceiver(powerReceiver, intentFilter);
        registerReceiver(receiver, receiverFilter);
        audioManager = (AudioManager)getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        unregisterReceiver(powerReceiver);
    }
}