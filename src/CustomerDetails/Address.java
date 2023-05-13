package CustomerDetails;

/**
 * This is a class that represents the account of the customer.
 */
public class Address {
    /**
     * The governorate of the address.
     */
    private String governorate;
    /**
     * The street of the address.
     */
    private String street;
    /**
     * The district of the address.
     */
    private String district;
    /**
     * The building number of the address.
     */
    private int buildingNo;
    /**
     * The floor number of the address.
     */
    private int floorNo;
    /**
     * The flat number of the address.
     */
    private int flatNo;
    /**
     * The landmark of the address.
     */
    private String landmark;
    /**
     * Account constructor with all fields as parameters except the landmark
     * @param gov the governorate of the address
     * @param street the street of the address
     * @param district the district of the address
     * @param buildingNo the building number of the address
     * @param floorNo the floor number of the address
     * @param flatNo the flat number of the address
     */

    public Address(String gov, String street, String district, int buildingNo, int floorNo, int flatNo)
    {
        this.governorate = gov;
        this.street = street;
        this.district = district;
        this.buildingNo = buildingNo;
        this.floorNo = floorNo;
        this.flatNo = flatNo;
    }

    /**
     * Sets a landmark for the address
     * @param landmark the username to be set
     */
    public void setLandmark(String landmark)
    {
        this.landmark = landmark;
    }
}
