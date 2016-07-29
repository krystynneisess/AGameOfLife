package com.kn.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TitleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        final Context context = this.getApplicationContext();

        Button startButton = (Button) findViewById(R.id.taBTNstart);

        startButton.setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
