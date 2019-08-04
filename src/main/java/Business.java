public class Business extends Tile {

    private BusinessType businessType;
    private String name;
    private Integer ownerId;
    private static final TileType tileType = TileType.BUSINESS;

    public Business() {
        super(tileType);
        this.businessType = BusinessType.random();
        this.ownerId = null;
        this.name = "dummy"; // TODO implement naming method
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
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

    @Override
    public String toString() {
        return this.getBusinessType().toString();
    }
}
