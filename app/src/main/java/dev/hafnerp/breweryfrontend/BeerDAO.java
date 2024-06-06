package dev.hafnerp.breweryfrontend;

import java.util.ArrayList;
import java.util.List;

import dev.hafnerp.breweryfrontend.model.Beer;
import dev.hafnerp.breweryfrontend.model.Category;

public class BeerDAO {

    /**
     * The one and only instance of the BeerDAO.
     */
    private static final BeerDAO beerDAO = new BeerDAO();

    /**
     * Temporary use for storing the beers that should be created in the db...
     * For testing purposes they will be stored in here...
     */
    private final List<Beer> beers;

    private BeerDAO() {
        //TODO:: Initialize the connection to the backend (if needed in further usage...)
        beers = new ArrayList<>();
    }

    /**
     * Get the actual Instance of the BeerDAO.
     * @return Current instance of the BeerDAO
     */
    public static BeerDAO getInstance() {
        return beerDAO;
    }

    /**
     * Get all beers stored in the database...
     * @return List of beers
     */
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
        beers.addAll(this.beers);

        return beers;
    }

    /**
     * Saves a given beer to the database
     * @param beer The beer that should be saved to the database
     * @return True... if the beer was added successfully | False... if there was a problem adding the beer
     */
    public boolean saveBeer(Beer beer) {
        return beers.add(beer);
    }

}
