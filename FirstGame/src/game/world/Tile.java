/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.world;

import Graphics.Screen;
import game.world.tiles.Air;
import game.world.tiles.Sand;
import game.world.tiles.Stone;

/**
 *
 * @author Raku
 */
public class Tile {
    public int id;
    public  boolean colider, ladder;
    
    public static Tile getTile(int id){
        if (id == 1 ) return new Stone();
         if (id == 2 ) return new Sand(); 
        return new Air();
    }
    
    public void update(){}
    
    public void render (Screen s, int x, int y){}
    
}
