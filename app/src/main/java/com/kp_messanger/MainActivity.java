package com.kp_messanger;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //check the database
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //check the user is login or not if login then see homepage other wise redirect to login page
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() == null){
            Intent intent = new Intent(MainActivity.this,login.class);
            startActivity(intent);
        }

////Get reference to textview
//        TextView textView = findViewById(R.id.textViewMessage);
//// Check if dark mode is enabled
//        boolean isDarkMode = isDarkModeEnabled();
//        // If dark mode is enabled, set text color to a lighter color
//        if (isDarkMode) {
//            textView.setTextColor(ContextCompat.getColor(this, R.color.light_text_color));
//        } else {
//            // If dark mode is not enabled, keep the text color as it is (black)
//            textView.setTextColor(ContextCompat.getColor(this, android.R.color.black));
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
//    private boolean isDarkModeEnabled() {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        return sharedPreferences.getBoolean("dark_mode_enabled", false);
//    }
}