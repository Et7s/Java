public class Main {
    public static void main(String[] args) {
        Sword sword = new Sword("Excalibur", 500,"Excellent", "Leather",true);
        Archery archery = new Archery("BEAR MOTIVE-6",1000,"Average", "40",6);
        TheMagicWand theMagicWand = new TheMagicWand("Elderberry wand", 1500,"Poor",15,8);
        sword.describeFeatures();
        System.out.println();
        sword.magicon();
        sword.magicoff();
        System.out.println();
        archery.describeFeatures();
        System.out.println();
        theMagicWand.describeFeatures();
        System.out.println();
        theMagicWand.magicon();
        System.out.println();
        System.out.println("Number of items: " + Gun.getCounter());
    }
}
abstract class Gun{
    public String name;
    public int price;
    public String quality;

    private static int counter = 0;

    public Gun(){
        counter++;
    }

    public Gun(String name,int price, String quality){
        this.name = name;
        this.price = price;
        this.quality = quality;
        counter++;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPrice() {return price; }
    public void setPrice(int price) {this.price = price;}
    public String getQuality() {return quality;}
    public void setQuality(String quality) {this.quality = quality;}
    public static int getCounter() {return counter;}


    public abstract void magicon();
    public abstract void magicoff();
    public abstract void describeFeatures();
}

class Sword extends Gun {
    private String rarity;
    private boolean ishereal;
    public Sword(String name, int price, String quality,String rarity,boolean ishereal){
        super(name,price,quality);
        this.rarity = rarity;
        this.ishereal = ishereal;
    }

    public String getRarity() {return rarity;}

    public void setRarity(String rarity) {this.rarity = rarity;}

    public boolean ishereal() {return ishereal;}

    public void setIshereal(boolean ishereal) {this.ishereal = ishereal;}

    @Override
    public void magicon() {
        System.out.println("Magic is on ");
    }

    @Override
    public void magicoff() {
        System.out.println("Magic off");
    }

    @Override
    public void describeFeatures() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price + " gold");
        System.out.println("Quality: " + quality);
        System.out.println("Rarity: " + rarity);
        System.out.println("Is he real: " + ishereal);
    }
}
class Archery extends Gun{

    private String Range;
    private int bowlength;

    public Archery(String name, int price,String quality,String Range, int bowlength) {
        super(name,price,quality);
        this.Range = Range;
        this.bowlength = bowlength;
    }
    public String getRange() {return Range;}
    public void setRange(String Range) {this.Range = Range;}

    public int getBowlength() {return bowlength;}

    public void setBowlength(int bowlength) {this.bowlength = bowlength;}
    @Override
    public void magicon() {
        System.out.println("Magic is on");
    }

    @Override
    public void magicoff() {
        System.out.println("Magic is off");
    }

    @Override
    public void describeFeatures() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price + " gold");
        System.out.println("Quality: " + quality);
        System.out.println("Range: " + Range + " m");
        System.out.println("Bow length: " + bowlength + " m");
    }
}
class TheMagicWand extends Gun {
    private int bowWand;
    private int elemental;

    public TheMagicWand(String name, int price, String quality, int bowWand, int elemental) {
        super(name, price, quality);
        this.bowWand = bowWand;
        this.elemental = elemental;
    }

    public int getBowWand() {return bowWand;}
    public void setBowWand(int bowWand) {this.bowWand = bowWand;}
    public int getElemental() {return elemental;}
    public void setElemental(int elemental) {this.elemental = elemental;}


    @Override
    public void magicon() {
        System.out.println("Magic is on");
    }

    @Override
    public void magicoff() {
        System.out.println("Magic is off");
    }

    @Override
    public void describeFeatures() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price + " gold");
        System.out.println("Quality: " + quality);
        System.out.println("Bow wand: " + bowWand + " m");
        System.out.println("Elemental: " + elemental);
    }
}