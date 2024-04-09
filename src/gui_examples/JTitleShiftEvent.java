/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_examples;

import java.awt.AWTEvent;

/**
 *
 * @author a.yusupova
 */
public class JTitleShiftEvent extends AWTEvent{
    private int shiftValue = 0;
    
    public JTitleShiftEvent(Object source, int id, int shiftVal){
        super(source,id);
        shiftValue = shiftVal;
    }
    
    public int getShift(){
        return shiftValue;
    }
    
}
