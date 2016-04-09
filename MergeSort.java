package sorting.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;

class MergeSort extends JFrame implements Runnable{
  private int tot = 100;
    private int max = 500;
    private int[] my_array;
    private Thread th;
    private DrawPanel mypanel;
   
    int count = 0;

    public MergeSort(){
        //This is to initialise everything 
        setSize(tot*5 + 100, max + 300);//first we set the window size
        setLayout(new GridLayout(1, 1));//we set the layout
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // we set  the default operation so that the program terminates
        setTitle("MERGE SORT");
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
  private int[] temp;
    private int len;
 
    
    private void my_MergeSort(int low, int high) {
         
        if (low < high) {
            int mid = low + (high - low) / 2;
            // we sort the left side of the array first recursively
            my_MergeSort(low, mid);
            // secondly we sort the right side of the array recursively
            my_MergeSort(mid + 1, high);
            // Now after both sides are sorted we perform the merge step
            mergeintoone(low, mid, high);
        }
    }
 
    private void mergeintoone(int low, int mid, int high) {
 // storeee the array in a temp array.
        for (int i = low; i <= high; i++) {
            temp[i] = my_array[i];
count++;      
            try{
                th.sleep(50);
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
        int i = low;            
        int j = mid + 1;
        int m = low;
        while (i <= mid && j <= high) {
            //condition check for every element in the two left and right arrays 
            if (temp[i] <= temp[j]) {
               //store the appropriate value in the array
                my_array[m] = temp[i];
                i++;
            } else {
                // store it in the array
                my_array[m] = temp[j];
                j++;
            }
            m++;
        }
        while (i <= mid) {
            //condition check -2 if the index is equal or less than mid 
            my_array[m] = temp[i];
            m++;
            i++;
        }
 
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void run(){
        {
        
        count++;  
        this.my_array = my_array;
        this.len = my_array.length;
        this.temp = new int[len];
        my_MergeSort(0, len - 1);
          
            
            try{
                th.sleep(10);
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
                new MergeSort().setVisible(true);
            }
        });
    }
}