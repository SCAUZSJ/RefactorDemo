package gildedRose;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GildedRoseTest {

    @Test
    public void should_return_correct_object_given_Aged_Brie_and_quality_is_50_and_sellin_less_than_1(){
        Item[] items = new Item[]{new Item("Aged Brie",0,50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(50,gildedRose.getItems()[0].getQuality());
        Assert.assertEquals(-1,gildedRose.getItems()[0].getSellIn());
    }

    @Test
    public void should_return_correct_object_given_Aged_Brie_and_quality_is_49_and_sellin_less_than_1(){
        Item[] items = new Item[]{new Item("Aged Brie",0,49)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(50,gildedRose.getItems()[0].getQuality());

    }
    @Test
    public void should_return_correct_object_given_Aged_Brie_and_quality_is_48_and_sellin_less_than_1(){
        Item[] items = new Item[]{new Item("Aged Brie",0,48)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(50,gildedRose.getItems()[0].getQuality());
    }

    @Test
    public void should_return_correct_object_given_Aged_Brie_and_quality_is_50_and_sellin_more_than_1(){
        Item[] items = new Item[]{new Item("Aged Brie",2,48)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(49,gildedRose.getItems()[0].getQuality());

    }


    @Test
    public void should_return_correct_object_given_backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_50_and_sellin_less_than_1(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",0,50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(0,gildedRose.getItems()[0].getQuality());
        Assert.assertEquals(-1,gildedRose.getItems()[0].getSellIn());
    }
    @Test
    public void should_return_correct_object_given_backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_47_and_sellin_less_than_6(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",5,47)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(50,gildedRose.getItems()[0].getQuality());
    }
    @Test
    public void should_return_correct_object_given_backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_47_and_sellin_less_than_11(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",10,47)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(49,gildedRose.getItems()[0].getQuality());
    }
    @Test
    public void should_return_correct_object_given_backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_47_and_sellin_more_than_11(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",12,47)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(48,gildedRose.getItems()[0].getQuality());
    }
    @Test
    public void should_return_correct_object_given_Sulfuras_Hand_of_Ragnaros_and_quality_is_more_than_1(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros",0,0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(0,gildedRose.getItems()[0].getQuality());
    }
    @Test
    public void should_return_correct_object_given_Sulfuras_Hand_of_Ragnaros_and_quality_is_more_than_0(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros",0,1)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(1,gildedRose.getItems()[0].getQuality());
    }
    @Test
    public void should_return_correct_object_given_other_and_sellin_is_less_than_1(){
        Item[] items = new Item[]{new Item("other",0,2)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(0,gildedRose.getItems()[0].getQuality());
    }
    @Test
    public void should_return_correct_object_given_other_and_sellin_is_more_than_0(){
        Item[] items = new Item[]{new Item("other",1,2)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        Assert.assertEquals(1,gildedRose.getItems()[0].getQuality());
    }

//    @Test
//    public void test(){
//        for(int i=-2;i<4;i++){
//            for(int j=-1;j<12;j++){
//                Item[] items = new Item[]{new Item("other",j,i)};
//                GildedRose gildedRose = new GildedRose(items);
//                gildedRose.updateQuality();
//
//
//                if(i == gildedRose.getItems()[0].getQuality()){
//                    continue;
//                }
//                System.out.print("Q="+i+",S="+j+" -> ");
//                System.out.print(gildedRose.getItems()[0].getQuality());
//                System.out.print(",");
//                System.out.println(gildedRose.getItems()[0].getSellIn());
//            }
//        }
//    }



}