import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;

public class ControllerFrame extends JFrame {
    private Model m;
    private ViewPanel p;
    private JLabel footer;

    //.......................................................................................
    public ControllerFrame(){
    super("Drawing program");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(990, 800);
    setLocation(500,200);
    m = new Model();
    p = new ViewPanel(m);
    
    //BUTTON PANEL.............................................................................................................
    JPanel buttonPanel = new JPanel(new FlowLayout(0,40,0));
    buttonPanel.setBackground(Color.gray);
    JButton black = new JButton("black");
    JButton red = new JButton("red");
    JButton green = new JButton("green");
    JButton dot = new JButton("dot");
    JButton oval = new JButton("oval");
    JButton rect = new JButton("rect");
    JButton undo = new JButton("undo");
    JButton save = new JButton("save");
    JButton load = new JButton("load");

    buttonPanel.add(black);
    buttonPanel.add(red);
    buttonPanel.add(green);
    buttonPanel.add(dot);
    buttonPanel.add(oval);
    buttonPanel.add(rect);
    buttonPanel.add(undo);
    buttonPanel.add(save);
    buttonPanel.add(load);

    //...............................................................MouseListener()........
    p.addMouseListener(new MouseListener(){
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {
            Figure f = new Figure(e.getX(),e.getY(),m.getColor(),m.getForm());
            m.addShape(f);
            p.repaint();

        }
        public void mouseReleased(MouseEvent e) {
            
        }
    });
   p.addMouseMotionListener(new MouseMotionListener(){
    public void mouseDragged(MouseEvent e){
        Figure f = m.getLast();
        f.setEndXY(e.getX(), e.getY());
        p.repaint();
    }
    public void mouseMoved(MouseEvent e){}
   }); 

   black.addActionListener(new buttonBox());
   red.addActionListener(new buttonBox());
   green.addActionListener(new buttonBox());
   dot.addActionListener(new buttonBox());
   oval.addActionListener(new buttonBox());
   rect.addActionListener(new buttonBox());
   undo.addActionListener(new buttonBox());
   save.addActionListener(new buttonBox());
   load.addActionListener(new buttonBox());  
   
   //FOOTER PANEL............................................................................................................
   footer = new JLabel();
   footer.setText(m.toString());
   footer.setSize(990, 100);
   add(buttonPanel, BorderLayout.NORTH);
   add(footer,BorderLayout.SOUTH);
   add(p);
   setVisible(true);
    
}
    //...................................................................................
    private class buttonBox implements ActionListener{
        String  str;
    public void actionPerformed(ActionEvent e){
        Object obj  = e.getSource();
        JButton b;
        b = (JButton) obj;
        str = b.getText();
        if(str.equals("black")){
            m.setColor(Color.BLACK);
            footer.setText(m.toString());
        }
        if(str.equals("red")){
            m.setColor(Color.RED);
            footer.setText(m.toString());

        }
        if(str.equals("green")){
            m.setColor(Color.GREEN);  
            footer.setText(m.toString());

        }
        if(str.equals("dot")){
            m.setForm("dot");
            footer.setText(m.toString());

        }
        if(str.equals("oval")){
            m.setForm("oval");
            footer.setText(m.toString());

        }
        if(str.equals("rect")){
            m.setForm("rect");// 
            footer.setText(m.toString());

        }
        if(str.equals("undo")){
            Figure f = m.getLast();
            m.remove(f);
            p.repaint();
        }
        if(str.equals("save")){         
             save();
        }
        if(str.equals("load")){
            load();
            p.repaint();
        }
    
    
    }
    
    }
    private void save(){
        try{
            String inputValue = JOptionPane.showInputDialog("Give a file name to save operation:");
            FileOutputStream output = new FileOutputStream(inputValue);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
            objectOutputStream.writeObject(this.m);
            objectOutputStream.flush();
            objectOutputStream.close();  
        }catch(IOException eSave){
            System.out.println("something went wrong!");
        }
    }
    private void load(){
        try {
            String inputValue = JOptionPane.showInputDialog("Give a file name load operation:");
            FileInputStream input = new FileInputStream(inputValue);
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            m = (Model) (objectInputStream.readObject());
            p.setModel(m);
            objectInputStream.close();
        } catch (Exception eLoad) {
            System.out.println("Read failed");
        }
    }
    //......................................................main...........................................................//

    public static void main(String[] args){

            ControllerFrame win = new ControllerFrame();

    }
}
