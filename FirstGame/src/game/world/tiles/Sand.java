/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.world.tiles;

import Graphics.Screen;
import Graphics.Sprite;
import Graphics.Spritesheet;
import game.world.Tile;
import static game.world.tiles.Stone.texture;

/**
 *
 * @author Raku
 */
public class Sand extends  Tile{
    public static final Sprite texture = new Sprite(2*16, 0, 16, 16, Spritesheet.def1);
    public Sand(){
        id = 2;
        colider =   true;
        ladder  =   false;
    }
    
   
    public void render (Screen s, int x, int y){
       
        
    s.renderSprite(x*16, y*16, texture);}
}
