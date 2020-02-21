package com.asodc.citysim.mvc;

import java.util.Random;

class Business extends Tile {
    private BusinessType businessType;
    private String name;
    private Integer ownerId;
    private static final TileType tileType = TileType.BUSINESS;

    Business() {
        super(tileType);
        this.businessType = BusinessType.random();
        this.ownerId = null;
        this.name = "dummy";
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

enum BusinessType {
    ACCOUNTANCY,
    ANTIQUES_DEALER,
    AUCTION_ROOMS,
    AUTO_DEALERS,
    BANK,
    BOOK_STORE,
    BUTCHERS,
    CAB_COMPANY,
    COFFIN_MAKERS,
    CONVENIENCE_STORE,
    DEPARTMENT_STORE,
    DETECTIVE_AGENCY,
    DOCTORS,
    DRUG_STORE,
    FINANCE_COMPANY,
    GIFT_STORE,
    GLASSWARE,
    GYM,
    HABERDASHERY,
    HARDWARE_STORE,
    HOTEL,
    JEWELERS,
    LAWYERS,
    LIBRARY,
    NEWS_AGENCY,
    PAWNBROKERS,
    PLUMBERS,
    POOL_HALL,
    PRINTERS,
    RESTAURANT,
    STATIONERS,
    TATTOO_PARLOR;

    private static final Random RANDOM = new Random();

    static BusinessType random() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
