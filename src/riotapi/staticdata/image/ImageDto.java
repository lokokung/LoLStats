package riotapi.staticdata.image;

public class ImageDto {
    private String full;
    private String group;
    private int h;
    private String sprite;
    private int w;
    private int x;
    private int y;

    public String get_full(){
        return full;
    }
    public void set_full(String full){
        this.full = full;
    }
    public String get_group(){
        return group;
    }
    public void set_group(String group){
        this.group = group;
    }
    public int get_h(){
        return h;
    }
    public void set_h(int h){
        this.h = h;
    }
    public String get_sprite(){
        return sprite;
    }
    public void set_sprite(String sprite){
        this.sprite = sprite;
    }
    public int get_w(){
        return w;
    }
    public void set_w(int w){
        this.w = w;
    }
    public int get_x(){
        return x;
    }
    public void set_x(int x){
        this.x = x;
    }
    public int get_y(){
        return y;
    }
    public void set_y(int y){
        this.y = y;
    }
}