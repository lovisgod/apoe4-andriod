package hng.tech.apoe_4.activities;

import androidx.appcompat.app.AppCompatActivity;
import hng.tech.apoe_4.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.pixplicity.easyprefs.library.Prefs;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_Launcher);
        super.onCreate(savedInstanceState);

        String accesToken = Prefs.getString("accessToken", "");

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            // Do something after 5s = 5000ms

            if (accesToken.isEmpty() && !Prefs.getBoolean("loggedIn", false)){

                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();
            }
            else if (!Prefs.getBoolean("savedDOB", false)) {
                startActivity(new Intent(SplashActivity.this, DOB_page.class));
                SplashActivity.this.finish();
            }
            else if (Prefs.getBoolean("savedDOB", false) && !Prefs.getBoolean("selectedWHG", false)){
                startActivity(new Intent(SplashActivity.this, WHGActivity.class));
                SplashActivity.this.finish();
            }else if (Prefs.getBoolean("savedDOB", false) && Prefs.getBoolean("selectedWHG", false) && !Prefs.getBoolean("answeredQuestions", false)) {
                startActivity(new Intent(SplashActivity.this, QuestionsActivity.class));
                SplashActivity.this.finish();
            }
            else {
                startActivity(new Intent(SplashActivity.this, Home.class));
                SplashActivity.this.finish();
            }
        }, 2000);


    }


}
