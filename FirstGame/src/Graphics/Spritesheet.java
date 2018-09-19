/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Raku
 */
public class Spritesheet {
    
    public static final Spritesheet def1 = new Spritesheet("/res/Spritesheet.png");
    public  int WIDTH, HEIGHT;
    public  int[] pixels;
    
    public Spritesheet(String path){
        try {
            BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
            WIDTH = image.getWidth();
            HEIGHT =image.getHeight();
            pixels = new int[WIDTH * HEIGHT];
            
            image.getRGB(0,0,WIDTH,HEIGHT,pixels,0,WIDTH);
        } catch (IOException ex) {
            Logger.getLogger(Spritesheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

