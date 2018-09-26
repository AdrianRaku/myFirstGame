/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 *
 * @author Raku
 */
public class Screen {
    public int WIDTH;
    public int HEIGHT;
    
    private BufferedImage image;
    private int[] pixels;
    
    public Screen(int w,int h){
        WIDTH = w;
        HEIGHT=h;
        
        image= new BufferedImage(16 *20, 10 *20, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }
    
    
    
    public void clear(int color)
    {
        for(int i = 0;i <WIDTH*HEIGHT;i++)
        {
            pixels[i]=color;
    }}
    public BufferedImage getImage(){
            return image; 
        }
    
    
    public void renderSprite(int px, int py,  Sprite s)  
    {
        for(int y = 0 ;y < s.spriteHeight; y++)
        {
            for (int x = 0; x < s.spriteWidth;x++)
            {
                pixel( px + x, py + y, s.sp.pixels[s.x + x + (s.y + y) * s.sp.WIDTH]); 
            }
        }
    }   
    public void renderSprite(int px, int py, int sx, int sy, int size, Spritesheet sp)  
    {
        for(int y = 0 ;y < size; y++)
        {
            for (int x = 0; x < size;x++)
            {
                pixel( px + x, py + y, sp.pixels[sx + x + (sy + y * sp.WIDTH)]); 
            }
        }
    }
    private void pixel(int x,int y, int color){
       if( x < 0 || x >= WIDTH || y < 0 || y > HEIGHT || color == 0xFFFF00FF) return;
       pixels[x+y*WIDTH] = color;
    }
    
      
    public void frect(int px, int py, int w, int h,int color){   
        for(int y=0;y < h; y++)
        {
            for (int x=0; x<w;x++)
            {
                pixel( x + px, y + py, color); 
            }
        }
    }
}
