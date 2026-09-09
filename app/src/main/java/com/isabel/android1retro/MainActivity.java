package com.isabel.android1retro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.Log;
import android.graphics.Color;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate called");
        
        try {
            // Create root layout
            LinearLayout root = new LinearLayout(this);
            root.setOrientation(LinearLayout.VERTICAL);
            root.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ));
            root.setBackgroundColor(Color.WHITE);
            root.setGravity(android.view.Gravity.CENTER);
            
            // Create title
            TextView title = new TextView(this);
            title.setText("Android 1.0 Retro");
            title.setTextSize(32);
            title.setTextColor(Color.BLACK);
            title.setGravity(android.view.Gravity.CENTER);
            LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );
            titleParams.setMargins(0, 0, 0, 16);
            title.setLayoutParams(titleParams);
            
            // Create subtitle
            TextView subtitle = new TextView(this);
            subtitle.setText("Icon Pack");
            subtitle.setTextSize(18);
            subtitle.setTextColor(Color.GRAY);
            subtitle.setGravity(android.view.Gravity.CENTER);
            LinearLayout.LayoutParams subtitleParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );
            subtitle.setLayoutParams(subtitleParams);
            
            root.addView(title);
            root.addView(subtitle);
            
            setContentView(root);
            Log.d("MainActivity", "UI created successfully");
            
        } catch (Exception e) {
            Log.e("MainActivity", "Exception in onCreate: " + e.getMessage(), e);
            
            // Fallback: Create a simple text view if everything fails
            TextView errorView = new TextView(this);
            errorView.setText("Icon Pack Loaded");
            errorView.setTextSize(24);
            errorView.setTextColor(Color.BLACK);
            errorView.setBackgroundColor(Color.WHITE);
            setContentView(errorView);
        }
    }
}
