class Business extends Tile {
    private BusinessType businessType;
    private String name;
    private Integer ownerId;
    private static final TileType tileType = TileType.BUSINESS;

    Business() {
        super(tileType);
        this.businessType = BusinessType.random();
        this.ownerId = null;
        this.name = "dummy"; // TODO implement naming method
    }

    BusinessType getBusinessType() {
        return businessType;
    }

    void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    Integer getOwnerId() {
        return ownerId;
    }

    void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return this.getBusinessType().toString();
    }
}
