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
import core.GameStateManager;
import input.Keyboard;
import java.awt.event.KeyEvent;

/**
 *
 * @author Raku
 */
public class GS_Menu extends GameState {
    public static final Sprite s_bg =       new Sprite(0, 0, Spritesheet.bg_menu.HEIGHT , Spritesheet.bg_menu.WIDTH, Spritesheet.bg_menu);
    public static final Sprite s_pointer =    new Sprite(16, 0, 16,16,Spritesheet.def1);
    public static final Sprite s_logo =     new Sprite(0, 16, 32, 64, Spritesheet.def1);
    public static final Sprite s_newGame =  new Sprite(0, 16 * 3, 16, 64, Spritesheet.def1);
    public static final Sprite s_continue = new Sprite(0, 16 * 4, 16, 64, Spritesheet.def1);
    public static final Sprite s_credits =  new Sprite(0, 16 * 5, 16, 64, Spritesheet.def1);
    public static final Sprite s_exit =     new Sprite(0, 16 * 6, 16, 32, Spritesheet.def1);
    
    private int choose = 0 ;
    private float pointerPosition = 0;
    
    public GS_Menu(){
        
    }

  
    public void update(){
        if(Keyboard.getKey(KeyEvent.VK_ENTER)){
            if(choose == 0)GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_GAME);
            if(choose == 3)GameStateManager.ChangeGameState(GameStateManager.GAME_STATE_EXIT);
        }
        
        if(Keyboard.getKeyOnce(KeyEvent.VK_DOWN)){
            choose++;}
        if(Keyboard.getKeyOnce(KeyEvent.VK_UP)){
            choose--;
        }
        
        if(choose > 3) choose = 0;
        if(choose < 0) choose = 3;
        
        if(choose == 0 ) setPointer(26);
        if(choose == 1 ) setPointer(36);
        if(choose == 2 ) setPointer(46);
        if(choose == 3 ) setPointer(56);
        }
    private void setPointer(int d){
        pointerPosition += (d - pointerPosition)/4;
    }
    public void render(Screen s){
        s.clear(0x000f00);
        s.renderSprite(0, 0, s_bg);
        s.renderSprite(0, 0, s_logo);
        s.renderSprite(20, 26, s_newGame);
        s.renderSprite(20, 36, s_continue);
        s.renderSprite(20, 46, s_credits);
        s.renderSprite(20, 56, s_exit);
        s.renderSprite(10, (int)pointerPosition, s_pointer);
        
    }
}
