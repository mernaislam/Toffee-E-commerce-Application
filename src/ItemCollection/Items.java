package ItemCollection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is a class that represents the item in the catalog or category.
 */
public class Items
{
    /**
     * ID of the item
     */
    private int id;
    /**
     * Name of the item
     */
    private String name;
    /**
     * Price of the item
     */
    private double price;
    /**
     * Quantity of the item
     */
    private int quantity;
    /**
     * Unit Type of the item
     */
    private UnitType unitType;
    /**
     * Category of the item
     */
    private String category;
    /**
     * Brand of the item
     */
    private String brand;
    /**
     * Status of the item
     */
    private ItemStatus itemStatus;
    /**
     * Description of the item
     */
    private String description;

    /**
     * Items constructor with important fields
     * @param name name of the item
     * @param quantity quantity of the item
     * @param category category of the item
     * @param brand brand of the item
     */
    public Items(String name, double price, int quantity, String category, String brand)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.brand = brand;
        BufferedReader read;
        String lastId = null;
        int newId = 1;
        String line;
        try
        {
            read = new BufferedReader(new FileReader("Toffee-E-commerce-Application/ItemList.txt"));
            while((line = read.readLine()) != null)
            {
                String[] words = line.split("\t\t");
                lastId = words[0];
            }
            if(lastId != null)
            {
                newId = Integer.parseInt(lastId);
                newId++;
            }
            read.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        this.id = newId;
    }
    /**
     * Sets status of the item
     * @param itemStatus name of the item
     */

    public void setItemStatus(ItemStatus itemStatus)
    {
        this.itemStatus = itemStatus;
    }
    /**
     * Sets quantity of the item
     * @param quantity name of the item
     */

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    /**
     * Sets description of the item
     * @param description name of the item
     */

    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * Returns price of the item
     * @return price of the item
     */
    public double getPrice()
    {
        return price;
    }
    /**
     * Returns quantity of the item
     * @return quantity of the item
     */
    public int getQuantity()
    {
        return quantity;
    }
    /**
     * Returns category of the item
     * @return category of the item
     */
    public String getCategory()
    {
        return category;
    }
    /**
     * Sets unit type of the item
     * @param unitType unit Type name of the item
     */

    public void setUnitType(UnitType unitType)
    {
        this.unitType = unitType;
    }
    /**
     * Returns ID of the item
     * @return ID of the item
     */
    public int getId()
    {
        return id;
    }
    /**
     * Sets ID of the item
     * @param  id  ID of the item
     */

    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Returns name of the item
     * @return name of the item
     */
    public String getName()
    {
        return name;
    }
    /**
     * Returns brand of the item
     * @return brand of the item
     */
    public String getBrand()
    {
        return brand;
    }
}
