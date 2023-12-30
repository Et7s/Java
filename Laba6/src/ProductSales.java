import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class ProductSales {
    private static TreeMap<String,Integer> sales;
    private static int countSales;

    public ProductSales(){
        sales=new TreeMap<>();
        countSales=0;
    }

    public void addSale(String product, int count){
        if(sales.containsKey(product)){
            sales.put(product,sales.get(product)+count);
        }else {
            sales.put(product,count);
        }
        countSales+=count;
    }

    public void getAllSales(){
        System.out.println(sales.toString());
    }

    public int getCountSales(){
        return countSales;
    }

    public String mostPopularProduct(){
        List<Integer> values = new ArrayList<>(sales.values());
        Collections.sort(values);
        int c = values.get(values.size()-1);
        for (String key: sales.keySet()){
            if(sales.get(key).equals(c)){
                return key;
            }
        }
        return null;
    }
}
