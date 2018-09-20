/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Raku
 */
public class Keyboard implements KeyListener{
    
    private static final int  Count = 200;
    public static boolean keys[] = new boolean[Count];
    public static boolean keys_prev[] = new boolean[Count];
    public Keyboard()
    {
        for(int i  = 0; i < Count; i++)
        {
            keys[i] = false;
            keys_prev[i] = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent ke) {
      
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }
    public void update(){
        for(int i  = 0; i < Count; i++)
        {
            if(!keys[i])
                keys_prev[i] = false;
        }
      }
     public static boolean getKey(int key){
    return keys[key];
    }
    public static boolean getKeyOnce(int key)    
    {
       if(!keys_prev[key] && keys[key]) {
           keys_prev[key] = true;
           return true;}
       return false;
    }
        
   }

