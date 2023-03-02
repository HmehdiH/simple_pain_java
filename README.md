
# simple shape painting program:

ControllerFrame contains the main program and it is also the controller in this program.
this program implements Events and Actions (e.g. mouse events). this class manipulates view by model and also directly. 

- this program uses the MVC design to build a simple drawing program that can save and load too.  

- This class use four other classes:
   ```java 
        public class ControllerFrame extends JFrame {
            private Model m;
            private ViewPanel p;
            private JLabel footer;
            ...
        }
    ```
    - ViewPanel.java: as the view and drawing panel, ... 
    - Model.java: as the data handling class, ...
    - Figure.java: to saving the data and properties, ...


- In ControllerFrame class by adding mouse events we get the coordinates:
    ```java
        p.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            
            public void mousePressed(MouseEvent e) {
                Figure f = new Figure(e.getX(),e.getY(),m.getColor(),m.getForm());
                m.addShape(f);
                p.repaint();
            }
            public void mouseReleased(MouseEvent e) {}
        });

        p.addMouseMotionListener(new MouseMotionListener(){
            public void mouseDragged(MouseEvent e){
            Figure f = m.getLast();
            f.setEndXY(e.getX(), e.getY());
            p.repaint();
        }
        public void mouseMoved(MouseEvent e){}
        }); 
    
    ```

- This class has a internal class too:
    ```java
        private class buttonBox implements ActionListener{ 
            // listining to buttons and make actions 
        }
    ```
- In additional the methodes of this class uses the repaint to update/remove shapes on view.




ViewPanel.java: this class is a sub JPanel an implements paintComponent to draw graphics: 

- this class take its data from Model Class. 
    
    ```java 
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

                ...
            }
        }
    ```




Model.java: This class implements Serializable interface and handle the data, it makes a ArrayList of the Figure class to save data in an array. 

```java
    public class Model implements Serializable{
        private Color c;
        private ArrayList<Figure> shapes;

        ...

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
```

Figure.java class implements also the Serializable interface for being able to save and load.




 
    

