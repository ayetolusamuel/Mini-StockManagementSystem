package Setnumd;


import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.*;

public class textstaffsreport extends JPanel 
{   
   
    
    ImageIcon i=new ImageIcon("images\\rain.gif");
    ImageIcon i2=new ImageIcon("images\\rain.gif");
    ImageIcon i3=new ImageIcon("images\\rain.gif");
	public textstaffsreport()
	{
	 
		/*c sa=new c();
		sa.setVisible(true);
		sa.setSize(100,200);
		sa.setLocation(300,300);*/
	 setBackground(Color.cyan);    
	
	
     
	}
	public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D)g;
		    i.paintIcon(this,g2d,0,-220);
		    i2.paintIcon(this,g2d,250,-150);
		    i3.paintIcon(this,g2d,500,-150);
		    	
			g2d.setFont(new Font("Algerian",Font.ITALIC,17));
		
			
			g2d.setPaint(new GradientPaint(50,50,Color.BLUE,100,100,Color.PINK));
			
			g2d.drawString("              Welcome to Mini Stock Management System",10,20);
		}
   public  Dimension getPreferredSize()
    {
    	return new Dimension(2,30);
    }
	/*public static void main(String[] args) {
		c sa=new c();
		sa.setVisible(true);
		sa.setSize(100,200);
		sa.setLocation(300,300);
	}*/
	
	 	
}
 