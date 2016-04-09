package sorting.simulation;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ComboBoxes extends JApplet {
  private String[] description = { "BUBBLE SORT-RANDOM", "INSERTION SORT-RANDOM", "SELECTION SORT-RANDOM",
      "MERGE SORT-RANDOM", "QUICK SORT-RANDOM", "BUBBLE SORT-NORMAL","INSERTION SORT-NORMAL", "SELECION SORT-NORMAL","MERGE SORT-NORMAL","QUICK SORT-NORMAL" };

  private JTextField t = new JTextField("WELCOME TO VISUALISATION OF SORTING");

  private JComboBox c = new JComboBox();

 private JButton b = new JButton("RUN SORT");

  private int count = 0;

  
  public void init() {
    for (int i = 0; i < 10; i++)
    c.addItem(description[count++]);
        t.setEditable(false);
 
    c.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
           int choice=c.getSelectedIndex();
            System.out.println(choice);
   
                 t.setText("YOUR CHOICE:" + c.getSelectedIndex()+" "
            + ((JComboBox) e.getSource()).getSelectedItem());
      
if(choice==0)
{
                 BubbleSort v = new BubbleSort();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new BubbleSort().setVisible(true);
       
            
            }
            
            
    
   });
      }
else if(choice==1) 
{
               InsertionSort is = new InsertionSort();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new InsertionSort().setVisible(true);
       
            
            }
            
            
    
   });

}
else if(choice==2) 
{
               SelectionSort is = new SelectionSort();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SelectionSort().setVisible(true);
       
            
            }
            
            
    
   });

}

else if(choice==3) 
{
               MergeSort is = new MergeSort();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new MergeSort().setVisible(true);
       
            
            }
            
            
    
   });

}
else if(choice==4) 
{
               Quicksort is = new Quicksort();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Quicksort().setVisible(true);
       
            
            }
            
            
    
   });

}
else if(choice==5)
    {
               normaldistri nm = new normaldistri();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new normaldistri().setVisible(true);
       
            
            }
            
            
    
   });

}
else if (choice==6)
    {
               normalinsertion is = new normalinsertion();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new normalinsertion().setVisible(true);
       
            
            }
            
            
    
   });

}
else if(choice==7)
    {
               normalselection is = new normalselection();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new normalselection().setVisible(true);
       
            
            }
            
            
    
   });

}
else if(choice==8)
    {
               normalmerge is = new normalmerge();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new normalmerge().setVisible(true);
       
            
            }
            
            
    
   });

}
else if(choice==9)
    {
               normalquick is = new normalquick();
   SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new normalquick().setVisible(true);
       
            
            }
            
            
    
   });

}
      }
    });
    
     Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(t);
    cp.add(c);
    cp.add(b);
  }

  public static void main(String[] args) {
    run(new ComboBoxes(), 450, 225);
  }

  public static void run(JApplet applet, int width, int height) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(applet);
    frame.setSize(width, height);
    applet.init();
    applet.start();
    frame.setVisible(true);
  }
}