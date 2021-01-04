package service;

public class DeliveryPageDataReader {

    public static final String TESTDATA_DELIVERY_CONDITION = "testData.delivery.condition";

    public static String getDeliveryCondition(){
        return TestDataReader.getTestData(TESTDATA_DELIVERY_CONDITION);
    }

}
