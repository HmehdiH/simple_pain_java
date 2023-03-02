
# simple shape painting program:

ControllerFrame contains the main program and it is also the controller in this program.
this program implements Events and Actions (e.g. mouse events). 

- this program uses the MVC design to build a simple drawing program that can save and load too.  

- This class use four other class:
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


 
    

