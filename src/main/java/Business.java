public class Business {

    private BusinessType businessType;
    private String businessName;
    private Integer businessOwnerId;

    public Business() {
        this.businessType = BusinessType.random();
        this.businessName = "dummy"; // TODO: implement naming method
        this.businessOwnerId = null;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getBusinessOwnerId() {
        return businessOwnerId;
    }

    public void setBusinessOwnerId(Integer businessOwnerId) {
        this.businessOwnerId = businessOwnerId;
    }

    public Business generateRandomBusiness() {
        return new Business();
    }
}
