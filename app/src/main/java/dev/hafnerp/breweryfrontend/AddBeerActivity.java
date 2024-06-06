package dev.hafnerp.breweryfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddBeerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * In further programming, this will be the endpoint for adding a beer to the database via an endpoint
     * @param view This view is unused!
     */
    public void saveBeer(View view) {
    }

    /**
     * This is the button to go back to the MainPage activity...
     * @param view This view is unused!
     */
    public void backButton(View view) {
        Intent intent = new Intent(AddBeerActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
