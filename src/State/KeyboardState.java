/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import java.awt.event.KeyEvent;

/**
 *
 * @author okann
 */
public interface KeyboardState {
    	public void pressed(KeyEvent e);
	
	public void released(KeyEvent e);
}
