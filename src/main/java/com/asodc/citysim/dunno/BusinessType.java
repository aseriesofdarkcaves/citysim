package com.asodc.citysim.dunno;

import java.util.Random;

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

    // TODO extract constant and random method to some form of superclass
    private static final Random RANDOM = new Random();

    static BusinessType random() {
        return values()[RANDOM.nextInt(values().length)];
    }
}
