public class MainProduct {
    public static void main(String[] args) {
        ProductSales s = new ProductSales();

        s.addSale("Apple",2);
        s.addSale("Peach",1);
        s.addSale("Banana",3);
        s.addSale("Cucumber",6);

        s.getAllSales();
        System.out.println(s.getCountSales() +"\n");

        s.addSale("Peach",8);

        s.getAllSales();
        System.out.println(s.getCountSales()+"\n");
        System.out.println(s.mostPopularProduct());
    }
}
