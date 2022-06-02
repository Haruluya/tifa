package com.tifa.framework.web.util;

public class TifaConstant {
    public static String MONGODB_DATABASE = "recommender";

    public static String DB_PRODUCT_COLLECTION_NAME = "Product";

    public static String DB_RATING_COLLECTION_NAME = "Rating";

    public static String DB_USER_COLLECTION_NAME = "User";

    public static String AVERAGE_RATE_CLOUD_PRODUCTS = "AverageProducts";

    public static String PRODUCT_SIMILARITY_RECS_COLLECTION = "ProductRecs";

    public static String MONGODB_STREAM_RECS_COLLECTION = "StreamRecs";

    public static String HIGH_RATE_CLOUD_PRODUCTS = "RateMoreProducts";

    public static String HIGH_RATE_RECENTLY_CLOUD_PRODUCTS = "RateMoreRecentlyProducts";

    public static String ONLINE_RECS_COLLECTION = "StreamRecs";

    public static String USER_RECS_COLLECTION = "UserRecs";

    public static String ITEMCF_COLLECTION = "ItemCFProductRecs";

    public static String CONTENTBASED_COLLECTION = "ContentBasedProductRecs";

    public static String TIFA_RATING_BEHAIVER_TAG = "PRODUCT_RATING_PREFIX";

    public static int REDIS_PRODUCT_RATING_QUEUE_SIZE = 40;
}
