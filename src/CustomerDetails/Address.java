package CustomerDetails;

public class Address {
    private String governorate;
    private String street;
    private String district;
    private int buildingNo;
    private int floorNo;
    private int flatNo;
    private String landmark;

    public Address(String gov, String street, String district, int buildingNo, int floorNo, int flatNo) {
        this.governorate = gov;
        this.street = street;
        this.district = district;
        this.buildingNo = buildingNo;
        this.floorNo = floorNo;
        this.flatNo = flatNo;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
