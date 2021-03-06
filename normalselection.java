package sorting.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.util.Random;

class normalselection extends JFrame implements Runnable{
       private int tot = 100;
    private int max = 500;
    private int[] my_array;
    private Thread th;
    private DrawPanel mypanel;
   
   
    int count = 0;

    public normalselection(){
        //This is to initialise everything 
        setSize(tot*5 + 100, max + 300);//first we set the window size
        setLayout(new GridLayout(1, 1));//we set the layout
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // we set  the default operation so that the program terminates
        setTitle("SELECTION SORT");
        addpanel();
        
    }
    public void addpanel()
    {
        mypanel=new DrawPanel();
        getContentPane().add(mypanel); // adds the display panel to the display content window
        callthread();
    
    }
    public void callthread()
    {
        my_array = generatenormalArray(tot, max); // random array generator
        th = new Thread(this); 
        th.start(); //starts the thread
        
    }

      public static int[] generatenormalArray(int N, int max){
              int[] array = new int[N];
            double mean = 120.0, std = 50.0;
     Random rng = new Random();

    for(int i = 0;i<array.length;i++) {
      array[i] = (Integer)Math.round((float) (mean + std * rng.nextGaussian()));
 
    }   return array;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void run(){
for (int i = 0; i < my_array.length - 1; i++)
        {
            count++; 
            int pos = i; // fix the pos
            for (int j = i + 1; j < my_array.length; j++)
                //check if the curr elem is less than elem at pos
                if (my_array[j] < my_array[pos])
                    pos = j; //if true change pos to j
      //swap the two
            int less = my_array[pos]; 
            my_array[pos] = my_array[i];
            my_array[i] = less;
                    
       try{
                th.sleep(100);
            }
       catch(InterruptedException ie){
                ie.printStackTrace();
            }
            mypanel.repaint();
         System.out.println("the array after pass:" );
       for(int k=0;k<my_array.length;k++)
       {
           System.out.print(my_array[k] + " ");
       }
       
       System.out.println();
            
       
        System.out.println();
            
        }
    
    }
       class DrawPanel extends JPanel{            
        public void paintComponent(Graphics g){
            super.paintComponent(g); // Paints the content pane with the graphics object
            
            g.setColor(Color.LIGHT_GRAY); // sets the background of the graphics object.
            
            
            
            
            for(int i = 0; i < my_array.length; i++){
            
                //this loop fills the object with bars corresponding to the values of the array numbers
                g.fillRoundRect(i*5 +60,getHeight()- my_array[i], 8, my_array[i], i, 0); //fills it
                g.setColor(Color.red); // sets the color of the bar
            }
            }
    }
  public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new normalselection().setVisible(true);
            }
        });
    }
}