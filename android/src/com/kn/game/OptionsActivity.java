package com.kn.game;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

public class OptionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        final SeekBar sbMusic = (SeekBar) findViewById(R.id.oaSBmusic);

        Log.d("TAG_DEBUG", "SB Max:  " + Integer.toString(sbMusic.getMax()));

        sbMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("TAG_DEBUG", "SB just set to:  " + Integer.toString(sbMusic.getProgress()));
            }
        });
    }
}
