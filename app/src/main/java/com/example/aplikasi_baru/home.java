package com.example.aplikasi_baru;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import java.util.Timer;
import java.util.TimerTask;

public class home extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] imageIds = new int[]{
            R.drawable.cooking_mamabg,
            R.drawable.cooking_mamabg1,
            R.drawable.cooking_mamabg2
    };
    private int currentPage = 0;
    private Timer timer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Change the status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.purple));

        viewPager = findViewById(R.id.viewPager);

        ImageAdapter adapter = new ImageAdapter(this, imageIds);
        viewPager.setAdapter(adapter);

        // Apply edge-to-edge behavior
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        // Set up a handler for updating the ViewPager
        handler = new Handler(Looper.getMainLooper());

        // Set up a timer to change images automatically every 3 seconds
        timer = new Timer(); // Initialize Timer Object
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.post(() -> {
                    if (currentPage == imageIds.length - 1) {
                        currentPage = 0;
                    } else {
                        currentPage++;
                    }
                    viewPager.setCurrentItem(currentPage, true);
                });
            }
        }, 3000, 3000); // Update every 3 seconds
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel the timer to prevent memory leaks
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    public void to_detail(View view) {
        // Implement the action for this method
        Intent intent = new Intent(home.this, detail_menus.class);
        startActivity(intent);
    }
}
