/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import core.Main;
import java.awt.event.MouseMotionListener;
import javax.swing.event.MouseInputListener;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author Raku
 */
public class Mouse implements MouseInputListener, MouseMotionListener{

    public static int x,y,Xpixel,Ypixel;
    public static boolean button_left, button_right;
    public static void update(){
        
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent me) {
        x = me.getX();
        y = me.getY();
        Xpixel = (int)((float)x*( (16.0f * 20.0f) / (float)Main.WIDTH ));
        Ypixel = (int)((float)y*( (9.0f * 20.0f) / (float)Main.HEIGHT ));
    }
    
}
