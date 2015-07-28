package riotapi.staticdata.item;

public class GoldDto {
    private int base;
    private boolean purchasable;
    private int sell;
    private int total;

    public int get_base(){
        return base;
    }
    public void set_base(int base){
        this.base = base;
    }
    public boolean get_purchasable(){
        return purchasable;
    }
    public void set_purchasable(boolean purchasable){
        this.purchasable = purchasable;
    }
    public int get_sell(){
        return sell;
    }
    public void set_sell(int sell){
        this.sell = sell;
    }
    public int get_total(){
        return total;
    }
    public void set_total(int total){
        this.total = total;
    }
}