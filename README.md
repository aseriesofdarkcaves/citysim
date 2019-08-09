Class City\
    - String name\
    - int width\
    - int height\
    - CityType type\
    - CityState state\
Class CityState\
    - static Tile[][] tiles\
    - static ArrayList<Business> businesses\
Class TileFactory\
    - static HashMap<TileType, Tile> instancedTiles\
Class Tile\
    - final TileType tileType\
Class Business extends Tile\
    - String name\
    - BusinessType businessType\
Enum TileType\
Enum BusinessType

