/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import Graphics.Screen;
import Graphics.Sprite;
import Graphics.Spritesheet;
import input.Keyboard;
import input.Mouse;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import javax.swing.JFrame;
import sun.java2d.pipe.BufferedBufImgOps;

/**
 *
 * @author Raku
 */
public class Main extends Canvas implements Runnable  {
    public static final int WIDTH=1024, HEIGHT = 576;
    public static final int FRAMERATE = 60;
    private JFrame frame;
    private boolean RUNNING = false;
   
   
    private Screen screen;
    private Keyboard keyboard = new Keyboard();
    private Mouse mouse = new Mouse();
    
    
    private GameStateManager gsm ;
    
   public Main(){
       setPreferredSize(new Dimension(WIDTH,HEIGHT));
       setMaximumSize(new Dimension(WIDTH,HEIGHT));
       setMinimumSize(new Dimension(WIDTH,HEIGHT));
      
       addKeyListener(keyboard);
       addMouseListener(mouse);
       addMouseMotionListener(mouse);
       
       frame = new JFrame("gra");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       frame.add(this, new BorderLayout().CENTER);
      
       
       frame.pack();
       
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
       frame.setVisible(true);
       int i = 20;
       screen = new Screen(16 * i,9 * i);
       
       gsm= new GameStateManager();
       
   }
   private void start(){
       if(RUNNING)return;
       RUNNING=true;
       new Thread( this,"Game").start();
   }
   
   private void stop(){
       if(!RUNNING)return;
       RUNNING=false;
       frame.dispose();
       System.exit(0);
   }
   private double timer = System.currentTimeMillis();
   private int FPS = 0;
   private int UPS = 0;
   private double delta;
   private double framtime = 1000000000 / FRAMERATE;
   private long timeNow = System.nanoTime();
   private long timeLast = System.nanoTime();
   
    public void run() {
        while(RUNNING && !gsm.exit){
            timeNow  = System.nanoTime();
            delta +=(timeNow - timeLast) / framtime;
            timeLast = timeNow;
            
            while(delta >=1){
                update();
                delta -= 1;
                UPS++;
            }
            render();
            FPS++;
            
            if(System.currentTimeMillis() - timer >= 1000){
                timer = System.currentTimeMillis();
               // System.out.println("FPS: " + FPS);
               // System.out.println("UPS: " + UPS);
                frame.setTitle("FPS: " + FPS + ' ' + "UPS: " + UPS);
                FPS = 0;
                UPS = 0;
            }
        }stop();
    }
    
    
    private void update(){
        keyboard.update();
//       
        gsm.update();
        System.out.println(" normal " +Mouse.x);
        System.out.println(Mouse.Xpixel);
        
    }
    
    
     private void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs==null){
            createBufferStrategy(3);
            return;
        }
         Graphics g = bs.getDrawGraphics();
         g.setColor(Color.black);
         g.fillRect(0, 0, WIDTH+10, HEIGHT+10);
         
         screen.clear(0xFF9900);
         gsm.render(screen);
         
        g.drawImage(screen.getImage(),0,0,WIDTH+10,HEIGHT+10,null);
         g.dispose();
         bs.show();
            
    }
    public static void main(String[] args) {
      new Main().start();
    }

   
   

    
    
}
