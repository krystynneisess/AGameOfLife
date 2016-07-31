package com.kn.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Context context = this.getApplicationContext();

        Button btnStart = (Button) findViewById(R.id.mmaBTNstart);
        Button btnTutorial = (Button) findViewById(R.id.mmaBTNtutorial);
        Button btnOptions = (Button) findViewById(R.id.mmaBTNoptions);
        Button btnAchievements = (Button) findViewById(R.id.mmaBTNachievements);

        btnStart.setOnClickListener(generateButtonListener(context, ModeSelectActivity.class));
//        btnTutorial.setOnClickListener(generateButtonListener(context, TutorialActivity.class));
        btnOptions.setOnClickListener(generateButtonListener(context, OptionsActivity.class));
//        btnAchievements.setOnClickListener(generateButtonListener(context, AchievementsActivity
// .class));

//        btnStart.setOnClickListener(generateButtonListener(context, TitleActivity.class));
        btnTutorial.setOnClickListener(generateButtonListener(context, TitleActivity.class));
//        btnOptions.setOnClickListener(generateButtonListener(context, TitleActivity.class));
        btnAchievements.setOnClickListener(generateButtonListener(context, TitleActivity.class));
    }


    private Button.OnClickListener generateButtonListener(final Context cntx, final Class cls) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cntx, cls);
                startActivity(intent);
            }
        };
    }
}
