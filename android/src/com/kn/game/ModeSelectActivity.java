package com.kn.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ModeSelectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select);

        final Context context = this.getApplicationContext();

        ImageButton ibtn_1player = (ImageButton) findViewById(R.id.msaIBTN1player);
        ImageButton ibtn_2player_left = (ImageButton) findViewById(R.id.msaIBTN2player_left);
        ImageButton ibtn_2player_right = (ImageButton) findViewById(R.id.msaIBTN2player_right);

        ibtn_1player.setOnClickListener(generateButtonListener(context, AndroidLauncher.class));
        ibtn_2player_left.setOnClickListener(generateButtonListener(context, AndroidLauncher.class));
        ibtn_2player_right.setOnClickListener(generateButtonListener(context, AndroidLauncher.class));
    }

    private ImageButton.OnClickListener generateButtonListener(final Context cntx, final Class
            cls) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cntx, cls);
                startActivity(intent);
            }
        };
    }
}
