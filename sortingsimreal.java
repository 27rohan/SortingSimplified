/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author rohan27
 */
public class sortingsimreal extends JFrame implements Runnable{
  public  int[] array=new int[100];
    private Thread th;
    private DrawPanel drawPanel;
    long startTime;
    int iter = 0;
   private int N = 100;
    private int max = 500;
   
    public sortingsimreal()
    {
    this.setSize(N*5 + 100, max + 300);
        this.setLayout(new GridLayout(1, 1));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("BUBBLE SORT");
        drawPanel = new DrawPanel();
        this.getContentPane().add(drawPanel);
        th = new Thread(this);
        th.start();
        startTime = System.nanoTime(); 
    
    }
    
     public void run(){
        for(int i = 0; i < array.length - 1; i++){
            iter++;
            for(int j=1;j< array.length-i;j++)
            {
            if(array[j-1] > array[j]){
               int tmp = array[j-1];
               array[j-1] = array[j];
               array[j] = tmp;
               
            }
            
            try{
                th.sleep(50);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
          drawPanel.repaint();
       System.out.println("the array after pass:" );
        printArray();
        System.out.println();
            
        }
        
        System.out.print((System.nanoTime() - startTime) / 1000 / 1000 / 1000);
        System.out.print(" seconds left on ");
        System.out.print(iter);
        System.out.print(" iterations on sorting an array of ");
        System.out.print(N);
        System.out.print(" integers");
       }
    }
    private void printArray(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            sb.append(array[i]);
            sb.append(" ");
        }
        System.out.println(new String(sb));
    }

    class DrawPanel extends JPanel{            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            g.setColor(Color.yellow);
            
           // g.fillPolygon(array, array, N);
            
            g.fill3DRect(0, 0, getWidth(), getHeight(),true);
            
          //  g.setColor(Color.red);
            
            for(int i = 0; i < array.length; i++){
            
                g.fillRoundRect(i*5 +60,getHeight()- array[i], 8, array[i], i, 0);
                g.setColor(Color.red);
               // g.fillRect(i*2 + 25, getHeight() - array[i], 2, array[i]);
            }
            }
    }
   
 
public static void main(String args[])
{
    
sortingsimreal sr = new sortingsimreal();
sr.readfromcsv();

SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new sortingsimreal().setVisible(true);
            }
        });


}

public void readfromcsv() {

	String csvFile = "C:\\Users\\AadarshSam\\Downloads\\Camera.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
       	try {

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
                        
			String[] money = line.split(cvsSplitBy);
                         String mny[]=money[2].split(" ");
                for(String str:mny)
                {
                  array=addToArray((int) Float.parseFloat(str));
                }
                  
                }

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        
}
 public int[]  addToArray(int addVal)
    {
        
      
ArrayList<Integer> ar = new ArrayList();
ar.add(addVal);

 int arr[] =convertIntegers(ar);
   return arr;

 
    }
 
  public static int[] convertIntegers(ArrayList<Integer> integers)
{
    int[] ret = new int[integers.size()];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] = integers.get(i);
    }
    return ret;
}
 
}