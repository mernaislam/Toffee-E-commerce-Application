package CustomerDetails;

public class Address {
    private String governorate;
    private String street;
    private String district;
    private int buildingNo;
    private int buildingFloor;
    private int buildingFlat;
    private String landmark;

    public Address(String gov, String street, String district, int buildingNo, int buildingFloor, int buildingFlat) {
        this.governorate = gov;
        this.street = street;
        this.district = district;
        this.buildingNo = buildingNo;
        this.buildingFloor = buildingFloor;
        this.buildingFlat = buildingFlat;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
