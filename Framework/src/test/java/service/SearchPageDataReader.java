package service;

public class SearchPageDataReader {

    public static final String TESTDATA_SEARCH_QUERY = "testdata.searchQuery";
    public static final String TESTDATA_FILTER_MAX_PRICE = "testdata.filter.max.price";
    public static final String TESTDATA_SEARCH_WRONG_LAYOUT = "testdata.wrongLayoutSearchQuery";

    public static String getSearchQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_QUERY);
    }

    public static String getFilterMaxPrice(){
        return TestDataReader.getTestData(TESTDATA_FILTER_MAX_PRICE);
    }

    public static String getWrongKeyboardLayoutSearchQuery() {
        return TestDataReader.getTestData(TESTDATA_SEARCH_WRONG_LAYOUT);
    }

}
