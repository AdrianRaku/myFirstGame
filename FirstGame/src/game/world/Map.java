/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.world;

import Graphics.Screen;

/**
 *
 * @author Raku
 */
public class Map {
    public final int WIDTH, HEIGHT;
    public Tile[][] tiles;
    public Map(int w, int h){
        WIDTH = w;
        HEIGHT = h;
        tiles = new Tile[w][h];
        
        clear(2);
    }
    public void clear(int id){
        for(int y = 0; y< HEIGHT; y++)
            for(int x = 0; x<WIDTH; x++)
            {
                tiles[x][y] = Tile.getTile(id);
            }
    }
    
    public void render(Screen s)
    {
        for(int y = 0; y< HEIGHT; y++)
            for(int x = 0; x<WIDTH; x++)
            {
                tiles[x][y].render(s, x, y);
            }
    }
}
