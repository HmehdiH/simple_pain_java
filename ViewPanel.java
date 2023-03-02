import java.awt.*;
import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import java.lang.Math;
import java.awt.event.*;
import org.w3c.dom.events.MouseEvent;


/**
 * denna klass är panelen som ska ha denna model som sin ritning Graphic
 */
public class ViewPanel extends JPanel{
private Model m ;

public  ViewPanel(Model m){
    setBackground(Color.white);
    this.m = m;
}
public void paintComponent(Graphics g) {
    super.paintComponent(g);    
for(Figure f : m.getShapes()){
    int x = f.getX();
    int y = f.getY();
    int x1 = f.getX1();
    int y1 = f.getY1();
    Color c = f.getColor();
    String shape = f.getForm();
    int width = x-x1;
    int height = y-y1;
    if(x<x1){
        width = x1-x;
        x1=x;
        
    }
    if(y<y1){
        height = y1-y;
        y1=y;  
    }
    g.setColor(c);
    if(shape.equals("dot")){
        g.fillOval(f.getX(),f.getY(),10,10);        
    }
    if(shape.equals("oval")){
        g.fillOval(x1,y1,width,height);          
    }
    if(shape.equals("rect")){
        g.fillRect(x1,y1,width,height);        
    }
    else if(!(shape.equals("oval"))){
    g.fillOval(f.getX(),f.getY(),10,10);

    }    
 }
}
public void setModel(Model m) {
    this.m = m;
}
}




 