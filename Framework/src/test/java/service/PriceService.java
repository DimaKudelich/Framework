package service;

import java.util.ArrayList;
import java.util.List;

public class PriceService {
    public static List<Integer> getIntFromPrice(List<String> prices){
        List<Integer> intPartsFromPrice = new ArrayList<>();

        for (String price: prices) {
            if(price.length() == 12) {
                intPartsFromPrice.add(Integer.parseInt(price.substring(0,3)));
            }else {
                intPartsFromPrice.add(Integer.parseInt(price.substring(0,2)));
            }
        }

        return intPartsFromPrice;
    }
}
