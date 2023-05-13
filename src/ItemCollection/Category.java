package ItemCollection;

import java.util.ArrayList;

/**
 * This is a class that represents a specific category in the catalog.
 */
public class Category
{
    /**
     * The list of items in the category
     */
    private ArrayList<Items> items = new ArrayList<Items>();
    /**
     * The list of names of all categories
     */
    private ArrayList<String> names = new ArrayList<String>();
    /**
     * The name of the category
     */
    private String name;

    /**
     * Returns the items in the category
     * @return items in the category
     */
    public ArrayList<Items> getItems()
    {
        return items;
    }

    /**
     * Returns the name of the category
     * @return name of the category
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name of the category
     * @param name name of th category
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Returns names of the categories
     * @return names of the categories
     */
    public ArrayList<String> getNames()
    {
        return names;
    }
}
