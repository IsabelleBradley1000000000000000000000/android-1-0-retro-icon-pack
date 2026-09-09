package com.isabel.android1retro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            
            // Create a simple UI programmatically to avoid layout inflation issues
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ));
            layout.setBackgroundColor(0xFFFFFFFF); // White background
            
            // Title
            TextView title = new TextView(this);
            title.setText("Android 1.0 Retro Pack");
            title.setTextSize(24);
            title.setTextColor(0xFF000000); // Black text
            title.setPadding(16, 16, 16, 16);
            
            // Subtitle
            TextView subtitle = new TextView(this);
            subtitle.setText("4 Icons Included");
            subtitle.setTextSize(16);
            subtitle.setTextColor(0xFF666666); // Gray text
            subtitle.setPadding(16, 0, 16, 16);
            
            layout.addView(title);
            layout.addView(subtitle);
            
            setContentView(layout);
            
        } catch (Exception e) {
            Log.e("MainActivity", "Error in onCreate", e);
            e.printStackTrace();
        }
    }
}
