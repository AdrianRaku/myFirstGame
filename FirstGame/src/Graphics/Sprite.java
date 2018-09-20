
package Graphics;


public class Sprite {
    public int x,y,size;
    public Spritesheet sp;
    
    public Sprite(int x, int y, int size, Spritesheet sp)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.sp = sp;
    }
}
