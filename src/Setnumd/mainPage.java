package Setnumd;

import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.MenuItem;

import javax.swing.*;

public class mainPage extends JFrame {
private Menu mnuFile;
private MenuItem mnuisignout,mnuilogout;
private JPanel pane = new JPanel();

	public mainPage() {
		// TODO Auto-generated constructor stub
		pane.setLayout(null);
		
		mnuFile = new Menu();
		pane.add(pane);
		
		
		getContentPane().add(pane,BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		mainPage sam = new mainPage();
		sam.setVisible(true);
		sam.setSize(600,700);
		sam.setLocationRelativeTo(null);
	
	
		
		
		
		
	
	}
	
}
