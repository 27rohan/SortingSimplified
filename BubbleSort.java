package sorting.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;

class BubbleSort extends JFrame implements Runnable{
    private int tot = 100;
    private int max = 500;
    private int[] my_array;
    private Thread th;
    private DrawPanel mypanel;
   
    int count = 0;

    public BubbleSort(){
        //This is to initialise everything 
        setSize(tot*5 + 100, max + 300);//first we set the window size
        setLayout(new GridLayout(1, 1));//we set the layout
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // we set  the default operation so that the program terminates
        setTitle("BUBBLE SORT");
        addpanel();
        
    }
    public void addpanel()
    {
        mypanel = new DrawPanel();//This draws the panel window which we display
        getContentPane().add(mypanel); // adds the display panel to the display content window
        callthread();
    
    }
    public void callthread()
    {
        my_array = generaterandArray(tot, max); // random array generator
        th = new Thread(this); 
        th.start(); //starts the thread
        
    }

    
    public static int[] generaterandArray(int N, int max){
        int[] my_array = new int[N];
        for(int i = 0; i < N; i++){
            my_array[i] = (int) (Math.random() * max);
        }
        return my_array;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void run(){
        //LOGIC FOR BUBBLE SORT
        for(int i = 0; i < tot - 1; i++){
            count++;
            for(int j=1;j< tot-i;j++)
            { // if the value of prev elem is greater than next
            if(my_array[j-1] > my_array[j]){ 
               int tmp = my_array[j-1];//swap the two elements
               my_array[j-1] = my_array[j];
               my_array[j] = tmp;
               
            }
            
            try{
                th.sleep(20); // This causes the delay due to which we see the optical illusion
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
          mypanel.repaint();
          
       System.out.println("the array after pass:" );
       for(int k=0;k<my_array.length;k++)
       {
           System.out.print(my_array[k] + " ");
       }
       
       System.out.println();
            
        }
        
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
        //we run the thread inside main.
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new BubbleSort().setVisible(true);
            }
        });
    }
}