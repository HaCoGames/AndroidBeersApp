package dev.hafnerp.breweryfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dev.hafnerp.breweryfrontend.model.Beer;
import dev.hafnerp.breweryfrontend.model.Category;

public class AddBeerActivity extends AppCompatActivity {

    EditText responseMessage;

    BeerDAO beerDAO = BeerDAO.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer);
    }

    @Override
    protected void onStart() {
        super.onStart();
        responseMessage = findViewById(R.id.responseMessageBeer);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * In further programming, this will be the endpoint for adding a beer to the database via an endpoint
     * @param view This view is unused!
     */
    public void saveBeer(View view) {
        try {
            Beer beer = getBeerFromEditTexts();
            beerDAO.saveBeer(beer);
            responseMessage.setText(R.string.beer_saved);
        }
        catch (Exception exception) {
            responseMessage.setText(exception.getMessage());
        }

    }

    /**
     * Collects the data from the EditText views and makes a beer object
     * @return The beer object based on the user inputs
     * @throws Exception Exception if the user makes a false input
     */
    public Beer getBeerFromEditTexts() throws Exception {
        EditText editText_name = findViewById(R.id.edit_text_name);
        EditText editText_alcohol = findViewById(R.id.edit_text_alcohol);
        EditText editText_calories = findViewById(R.id.edit_text_calories);
        EditText editText_category = findViewById(R.id.edit_text_category);
        Beer beer = new Beer(
                beerDAO.getBeers().size(),
                editText_name.getText().toString(),
                Double.parseDouble(editText_alcohol.getText().toString()),
                Double.parseDouble(editText_calories.getText().toString()),
                Category.fromString(editText_category.getText().toString())
        );

        responseMessage.setText(R.string.created_beer_from_textboxes);
        return beer;
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
