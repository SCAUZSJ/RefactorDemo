package gildedRose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    private Strategy strategy;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.strategy = newStrategy();
    }

    public Strategy newStrategy() {
        switch (this.name) {
            case "Aged Brie":
                return new AgedBrieStrategy();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstageStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasStrategy();
            default:
                return new OtherStrategy();
        }
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void change(){
        this.strategy.doChange(this);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
