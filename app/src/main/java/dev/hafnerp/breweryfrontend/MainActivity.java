package dev.hafnerp.breweryfrontend;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import dev.hafnerp.breweryfrontend.model.Beer;
import dev.hafnerp.breweryfrontend.model.Category;

public class MainActivity extends AppCompatActivity {

    private EditText responseMessage;

    private List<Beer> beerList;

    private BeerDAO beerDAO = BeerDAO.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        beerList = beerDAO.getBeers();
    }

    @Override
    protected void onStart() {
        super.onStart();
        responseMessage = findViewById(R.id.responseMessage);

        refreshBeersTable();
    }

    public Beer getBeerFromEditTexts() throws Exception {
        //Getting the references...
        EditText editText_name = findViewById(R.id.edit_text_name);
        EditText editText_alcohol = findViewById(R.id.edit_text_alcohol);
        EditText editText_calories = findViewById(R.id.edit_text_calories);
        EditText editText_category = findViewById(R.id.edit_text_category);

        //Values parsed...
        int id = beerList.size();
        String name = editText_name.getText().toString();
        double alcohol = Double.parseDouble(editText_alcohol.getText().toString());
        double calories = Double.parseDouble(editText_calories.getText().toString());
        Category category = Category.fromString(editText_category.getText().toString());

        //Business constraints...
        if (alcohol > 100) throw new IllegalStateException("Alcohol " + alcohol + " to high!");

        //Creating the beer...
        Beer beer = new Beer(
                id,
                name,
                alcohol,
                calories,
                category
        );

        responseMessage.setText(R.string.created_beer_from_textboxes);
        return beer;
    }

    public List<Beer> getBeers() {
        List<Beer> beers = new ArrayList<>();
        beers.add(new Beer());
        beers.add(new Beer(1, "Hannah", 8d, 234d, Category.Larger));
        beers.add(new Beer(2, "Peter", 8d, 234d, Category.Larger));
        beers.add(new Beer(3, "Max", 8d, 234d, Category.Larger));
        beers.add(new Beer(4, "Justin", 8d, 234d, Category.Larger));
        beers.add(new Beer(5, "Tobias", 8d, 234d, Category.Larger));
        beers.add(new Beer(6, "Samuel", 8d, 234d, Category.Larger));
        beers.add(new Beer(7, "Charlie", 8d, 234d, Category.Larger));
        beers.add(new Beer(8, "Theresa", 8d, 234d, Category.Larger));
        beers.add(new Beer(9, "Katharina", 8d, 234d, Category.Larger));

        return beers;
    }

    public void setBeerSource(List<Beer> beers) {
        TableLayout tableLayout;

        tableLayout= (TableLayout) findViewById(R.id.table_beers);
        tableLayout.removeAllViews();

        TableRow tableRow_headers = new TableRow(getApplicationContext());
        TextView    textView_id_header = new TextView(getApplicationContext());
                    textView_id_header.setText(String.valueOf("ID"));
                    textView_id_header.setPadding(6,3,6,3);
                    textView_id_header.setTextColor(Color.GRAY);
                    tableRow_headers.addView(textView_id_header);
        TextView    textView_name_header = new TextView(getApplicationContext());
                    textView_name_header.setText(R.string.name);
                    textView_name_header.setPadding(6,3,6,3);
                    textView_name_header.setTextColor(Color.GRAY);
                    tableRow_headers.addView(textView_name_header);
        TextView    textView_alcohol_header = new TextView(getApplicationContext());
                    textView_alcohol_header.setText(R.string.alcohol);
                    textView_alcohol_header.setPadding(6,3,6,3);
                    textView_alcohol_header.setTextColor(Color.GRAY);
                    tableRow_headers.addView(textView_alcohol_header);
        TextView    textView_calories_header = new TextView(getApplicationContext());
                    textView_calories_header.setText(R.string.calories);
                    textView_calories_header.setPadding(6,3,6,3);
                    textView_calories_header.setTextColor(Color.GRAY);
                    tableRow_headers.addView(textView_calories_header);
        TextView    textView_category_header = new TextView(getApplicationContext());
                    textView_category_header.setText(R.string.category);
                    textView_category_header.setPadding(6,3,6,3);
                    textView_category_header.setTextColor(Color.GRAY);
                    tableRow_headers.addView(textView_category_header);
        tableLayout.addView(tableRow_headers);

        for (Beer beer : beers)
        {
            TableRow    tableRow = new TableRow(getApplicationContext());
            TextView    textView_id = new TextView(getApplicationContext());
                        textView_id.setText(String.valueOf(beer.getId()));
                        textView_id.setPadding(6,3,6,3);
                        tableRow.addView(textView_id);
            TextView    textView_name = new TextView(getApplicationContext());
                        textView_name.setText(beer.getName());
                        textView_name.setPadding(6,3,6,3);
                        tableRow.addView(textView_name);
            TextView    textView_alcohol = new TextView(getApplicationContext());
                        textView_alcohol.setText(String.valueOf(beer.getAlcohol()));
                        textView_alcohol.setPadding(6,3,6,3);
                        tableRow.addView(textView_alcohol);
            TextView    textView_calories = new TextView(getApplicationContext());
                        textView_calories.setText(String.valueOf(beer.getCalories()));
                        textView_calories.setPadding(6,3,6,3);
                        tableRow.addView(textView_calories);
            TextView    textView_category = new TextView(getApplicationContext());
                        textView_category.setText(beer.getCategory().toString());
                        textView_category.setPadding(6,3,6,3);
                        tableRow.addView(textView_category);
            tableRow.setOnClickListener((view) -> {
                String text = "Clicked" + beer.toString();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
            });
            tableLayout.addView(tableRow);
        }

        responseMessage.setText(R.string.set_beers_source_to_new_beers);
    }

    public void refreshBeersTable() {
        setBeerSource(beerDAO.getBeers());
        responseMessage.setText(R.string.refreshed_beers_table);
    }

    public void saveBeer(View view) {
        try {
            Beer beer = getBeerFromEditTexts();
            beerList.add(beer);
            refreshBeersTable();
        }
        catch (Exception exception) {
            responseMessage.setText(exception.toString());
        }

    }

    public void loadBeerAddActivity(View view) {
        Intent addBeer = new Intent(MainActivity.this, AddBeerActivity.class);
        startActivity(addBeer);
    }
}