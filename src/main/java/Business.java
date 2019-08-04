public class Business {

    private BusinessType type;
    private String name;
    private Integer ownerId;

    public Business() {
        this.type = BusinessType.random();
        this.name = "dummy"; // TODO: implement naming method
        this.ownerId = null;
    }

    public BusinessType getType() {
        return type;
    }

    public void setType(BusinessType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Business generateRandomBusiness() {
        return new Business();
    }
}
