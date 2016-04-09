package sorting.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.util.Random;

class normalquick extends JFrame implements Runnable{
   private int tot = 100;
    private int max = 500;
    private int[] my_array;
    private Thread th;
    private DrawPanel mypanel;
   
   
    int count = 0;

    public normalquick(){
        //This is to initialise everything 
        setSize(tot*5 + 100, max + 300);//first we set the window size
        setLayout(new GridLayout(1, 1));//we set the layout
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // we set  the default operation so that the program terminates
        setTitle("QUICK SORT");
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

    
    
    
    private int length;
 
    
    private void quickSort(int low, int high) {
         

        int i = low;
        int j = high;
        // take pivot to be the middle element of the array
        int pivot = my_array[low+(high-low)/2];
        // Now we split our array into two arrays 
        while (i <= j) {// just a normal condn check
     
           count++;
                try{
                th.sleep(100);
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
            
       
        System.out.println();
        
             // 
              //is greater then the pivot value, and also we will identify a number
              //from right side which is less then the pivot value. Once the search
             //is done, then we exchange both numbers.
             
            while (my_array[i] < pivot)
            // we find a number from the left of the array which is greater than the pivot
            {
                i++;
            }
            
            while (my_array[j] > pivot) {
            // we find a number from the right of the array which is less than the pivot
                j--;
            }
            if (i <= j) {
                //now since we have found the numbers we exchange them
   
       int temp = my_array[i];
        my_array[i] = my_array[j];
        my_array[j] = temp;
                   
//move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }    
    @Override
    @SuppressWarnings("empty-statement")
    public void run(){
        {
        
        count++;  
        this.my_array = my_array;
        this.length = my_array.length;
        quickSort(0, length - 1);  
            
            try{
                th.sleep(100);
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
                new normalquick().setVisible(true);
            }
        });
    }
}