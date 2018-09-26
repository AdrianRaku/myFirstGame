/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gamestates;

import Graphics.Screen;
import Graphics.Sprite;
import Graphics.Spritesheet;
import core.GameState;
import game.world.Map;
import game.world.tiles.Stone;
import input.Keyboard;
import input.Mouse;
import java.awt.event.KeyEvent;

/**
 *
 * @author Raku
 */
public class GS_Game extends GameState {
   
    float x = 40, y = 40;
    public Map mapa;
    public static final Sprite sp = new Sprite(0, 0 , 16, 16 , Spritesheet.def1);
    public GS_Game(){
        mapa = new Map(20,20);
    }
    public void update(){
         float speed = 1f;
        if (Keyboard.getKey(KeyEvent.VK_W))
        {
            y-=speed;
        } else if (Keyboard.getKey(KeyEvent.VK_S))
        {
            y+=speed;
        }
        if (Keyboard.getKey(KeyEvent.VK_A))
        {
            x-=speed;
        } else if (Keyboard.getKey(KeyEvent.VK_D))
        {
            x+=speed;
        }
    }
    public void render(Screen s){
       s.clear(0x0000ff); 
       mapa.render(s);
       s.renderSprite((int)Mouse.Xpixel,(int)Mouse.Ypixel, sp);
      
    }
}
