
package Graphics;


public class Sprite {
    public int x,y,spriteWidth,spriteHeight;
    public Spritesheet sp;
    
    public Sprite(int x, int y, int height,int width, Spritesheet sp)
    {
        this.x = x;
        this.y = y;
        this.spriteHeight = height;
        this.spriteWidth = width;
        this.sp = sp;
    }
}
