package ItemCollection;

import java.util.ArrayList;

/**
 * This is a class that represents the catalog that contains all items in the system.
 */
public class Catalog
{
    /**
     * The list of items in the catalog
     */
    private ArrayList<Items> items = new ArrayList<Items>();
    /**
     * The list of categories in the catalog
     */
    private ArrayList<Category> categories = new ArrayList<Category>();
    /**
     * Returns the list of categories in the catalog
     * @return categories in the catalog
     */
    public ArrayList<Category> getCategories()
    {
        return categories;
    }
    /**
     * Returns the list of items in the catalog
     * @return items in the catalog
     */
    public ArrayList<Items> getItems()
    {
        return items;
    }
}
