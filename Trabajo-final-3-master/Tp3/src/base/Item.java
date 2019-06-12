/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Juan
 */
public class Item extends GameObject{
     private double weight;
     private int sellPrice;
     private int buyPrice;
     private int total;
     private int stackSize;

     public Item(){
         super();
         weight=0;
         sellPrice=0;
         buyPrice=0;
         total=0;
         stackSize=0;
     }
     public Item(String name){
         super(name);
         weight=0;
         sellPrice=0;
         buyPrice=0;
         total=0;
         stackSize=0;
     }
     
    public Item(double weight, int sellPrice, int buyPrice, int total, int stackSize, String name, int id) {
        super(name, id);
        this.weight = weight;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.total = total;
        this.stackSize = stackSize;
        
        
    }
    
    public Item(Item i){
        super(i.getName(),i.getId());
        this.weight = i.weight;
        this.sellPrice = i.sellPrice;
        this.buyPrice = i.buyPrice;
        this.total = i.total;
        this.stackSize = i.stackSize;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }
     
    
    
}