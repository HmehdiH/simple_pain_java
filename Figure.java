import java.awt.*;
import java.util.*;
import java.io.*;

import javax.swing.JLabel;
import javax.swing.text.AttributeSet.ColorAttribute;
public class Figure implements Serializable{
    private int x;
    private int y;
    private int x1;
    private int y1;
    private Color c;
    private String form;
    public Figure(){}
    public Figure(int x, int y, Color c, String form){
        this.x = x;
        this.y = y;
        this.c = c;
        this.form = form;
        this.x1 = x;
        this.y1= y;

    
    }
    public void setEndXY(int x, int y){
        
        this.x = x;
        this.y = y;

    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getX1(){
        return this.x1;
    }
    public int getY1(){
        return this.y1;
    }
    public Color getColor(){
        return this.c;
    }
    public String getForm(){
        return this.form;
    }

}
