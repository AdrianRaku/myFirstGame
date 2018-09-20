/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gamestates;

import Graphics.Screen;
import core.GameState;

/**
 *
 * @author Raku
 */
public class GS_Game extends GameState {
    
    public GS_Game(){
    }
    public void update(){
        
    }
    public void render(Screen s){
       s.clear(0x0000ff); 
    }
}
