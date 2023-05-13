package ItemCollection;

import DataManager.WritingToFile;

import java.util.ArrayList;

/**
 * This is a class that manages the collection of items in the system.
 */
public class CollectionManager
{
    /**
     * The catalog the class manages
     */
    private Catalog catalog = new Catalog();
    /**
     * The categories lidt the class manages
     */
    private ArrayList<Category> categorries = new ArrayList<>();

    /**
     * Add item to a specified category
     * @param item item to be added
     * @param category the category where to add the item in
     */
    public void addItemCategory(Items item, Category category)
    {
        category.getItems().add(item);
    }
    /**
     * Delete item from a specified category
     * @param item item to be deleted
     * @param category the category where to delet the item from
     */
    public void deleteItemCategory(Items item, Category category)
    {
        for (int i = 0; i < category.getItems().size(); i++)
        {
            if(category.getItems().get(i) == item)
            {
                category.getItems().remove(i);
            }
        }
    }
    /**
     * Add item to the catalog
     * @param item item to be added
     */
    public void addItemCatalog(Items item)
    {
        catalog.getItems().add(item);
    }
    /**
     * Delete item from the catalog
     * @param item item to be deleted
     */

    public void deleteItemCatalog(Items item)
    {
        for (int i = 0; i < catalog.getItems().size(); i++)
        {
            if(catalog.getItems().get(i) == item)
            {
                catalog.getItems().remove(i);
            }
        }
    }
    /**
     * Display items by category
     */
    public void displayByCategory()
    {
        for (Category cat: catalog.getCategories())
        {
            System.out.println("Category: " + cat.getName());
            System.out.println("ID\t\tItem\t\tPrice\t\tQuantity");
            for (Items item: cat.getItems())
            {
                System.out.println( item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity());
            }
            System.out.println();
        }
    }
    /**
     * Display all items
     */
    public void displayAllItems()
    {
        System.out.println("ID\t\tItem\t\tPrice\t\tQuantity");
        for (Items item: catalog.getItems())
        {
            System.out.println(item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity());
        }
    }
    /**
     * Add a new category to the catalog
     * @param category category to be added
     */
    public void addCategoryToCatalog(Category category)
    {
        catalog.getCategories().add(category);
    }
    /**
     * Returns items in the desired category
     * @param category the desired category
     * @return items items in the desired category
     */
    public ArrayList<Items> getCategoryItems(Category category)
    {
        return category.getItems();
    }
    /**
     * Returns items in the catalog
     * @return items in the catalog
     */
    public ArrayList<Items> getCatalogItems()
    {
        return catalog.getItems();
    }
    /**
     * Returns the catalog
     * @return catalog
     */
    public Catalog getCatalog()
    {
        return catalog;
    }
    /**
     * Write the full data of the item in the item data files
     * @param item that needs to be added
     */
    public void writeItemToFile(Items item)
    {
        String ItemFullData = item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity() + "\t\t" + item.getCategory() + "\t\t" + item.getBrand();
        String ItemData = item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getQuantity();

        WritingToFile writeItem = new WritingToFile("ItemList", ItemData);
        WritingToFile writeFullItem = new WritingToFile("ItemFullData", ItemFullData);
    }
}
