/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package gui_examples;

import java.beans.*;
import java.io.Serializable;
import javax.swing.*;               // добавлено вручную
import java.awt.*;                  // добавлено вручную
import java.awt.geom.Rectangle2D;   // добавлено вручную

/**
 *
 * @author a.yusupova
 */
public class JTitledPanel extends JPanel implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "title";
    
    private String title="Заголовок"; //добавлено вручную
    private Color titleColor = Color.red; // добавлено вручную
    private Font titleFont = new Font("Courier New", Font.ITALIC, 12);
    
    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
    /**
    * Holds value of property titleShift.
    */
    private int titleShift;
    
    private transient java.awt.event.TextListener titleChangedListener = null;
    private transient JTitleShiftEventListener titleShiftChangedListener = null;
    
   
    public JTitledPanel() {
        super();
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public JTitledPanel(LayoutManager layout, boolean isDoubleBuffered)
    {
        super(layout, isDoubleBuffered);
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public JTitledPanel(LayoutManager layout) {
        super(layout);
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public JTitledPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getTitle() {
        return title;
    }
    
    public Color getTitleColor() {
        return titleColor;
    }
    
    public Font getTitleFont() {
        return titleFont;
    }
    
    /**
    * Getter for property titleShift.
    * @return Value of property titleShift.
    */
    public int getTitleShift() {
        return this.titleShift;
    }
    
    public void setTitle(String value) {
        String oldValue = title;
        title = value;
        fireTitleChangedListenerTitleValueChanged(this, java.awt.event.TextEvent.TEXT_VALUE_CHANGED);
        propertySupport.firePropertyChange("title", oldValue, title);
        repaint(); //добавлено вручную
    }
    
    public void setTitleColor(Color value) {
        Color oldValue = titleColor;
        titleColor = value;
        propertySupport.firePropertyChange("titleColor", oldValue, titleColor);
        repaint(); //добавлено вручную
    }
    
    public void setTitleFont(Font value) {
        Font oldValue = titleFont;
        titleFont = value;
        propertySupport.firePropertyChange("titleFont", oldValue, titleFont);
        repaint(); //добавлено вручную
    }
    /**
     * Setter for property titleShift.
    * @param titleShift New value of property titleShift.
    */
    public void setTitleShift(int titleShift) {
        int oldTitleShift = this.titleShift;
        this.titleShift = titleShift;
        
        fireTitleShiftChangedListenerTitleShiftValueChanged(this,
                java.awt.event.ComponentEvent.COMPONENT_MOVED, 
                this.titleShift);
        
        propertySupport.firePropertyChange ("titleShift",
            oldTitleShift,
            titleShift);
        repaint();//добавлено вручную
    }
//    public String getSampleProperty() {
//        return sampleProperty;
//    }
//    
//    public void setSampleProperty(String value) {
//        String oldValue = sampleProperty;
//        sampleProperty = value;
//        propertySupport.firePropertyChange(title, oldValue, sampleProperty);
//    }
    
    public synchronized void addTitleChangedListener(java.awt.event.TextListener newListener)
    {
        titleChangedListener = newListener;
    }
    
    public synchronized void removeTitleChangedListener(java.awt.event.TextListener newListener)
    {
        titleChangedListener = null;
    }
    
    private void fireTitleChangedListenerTitleValueChanged(java.lang.Object object,int i){
        if (titleChangedListener == null) return;
        java.awt.event.TextEvent e = new java.awt.event.TextEvent (object, i);
        titleChangedListener.textValueChanged (e);
    }
    
    public synchronized void addTitleShiftChangedListener(JTitleShiftEventListener newListener)
    {
        titleShiftChangedListener = newListener;
    }
    
    public synchronized void removeTitleShiftChangedListener(JTitleShiftEventListener newListener)
    {
        titleShiftChangedListener = null;
    }
    
    private void fireTitleShiftChangedListenerTitleShiftValueChanged(java.lang.Object object,int i, int shift){
        if (titleShiftChangedListener == null) return;
        JTitleShiftEvent e = new JTitleShiftEvent (object, i,shift);
        titleShiftChangedListener.titleShiftChanged(e);
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if(propertySupport != null)
            propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public void paint(Graphics g){ // добавлен вручную
        super.paint(g);
        FontMetrics fontMetrics=g.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(title, g);
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString(title,(int)Math.round((this.getWidth() -
                                rect.getWidth())/2)+titleShift, 10);
    }
}
