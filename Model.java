import java.awt.*;
import java.util.*;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.io.*;
public class Model implements Serializable{
    private Color c;
    private ArrayList<Figure> shapes;
    private String form;   
    public Model(){
        shapes = new ArrayList();
        this.c = Color.BLACK;
        this.form = "DOT";
    }
    
    //.....................................................................
    
    public String toString(){
            String footer = "Mode: ";
            footer += this.getForm() +" ";
            footer = footer.toUpperCase();
            footer += c;
            return footer;
    }
    
    public Color getColor(){
        return this.c;
    }
    public void setColor(Color c){
        this.c = c;
    }
    
    public String getForm(){
        return form;
    }
    public void setForm(String form){
        this.form = form;
    }
    public void addShape(Figure f){
    shapes.add(f);      

    }
    public ArrayList<Figure> getShapes(){
        return this.shapes;   
    
    }
    public Figure getLast(){
        if(!(shapes.isEmpty())){
          return shapes.get(shapes.size()-1);
        }
        return new Figure();
    }

    public void remove(Figure f){
        shapes.remove(f);
    }
    
   
}

