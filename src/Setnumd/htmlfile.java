package Setnumd;

import javax.swing.*;

public class htmlfile extends JInternalFrame{

	
	
	
	public htmlfile(String title,String filename){
		//supertittle,Resizable,maximizable,iconifiable()
		super(title,false,true,true,true);
		setSize(440,323);
		HtmlPane html=new HtmlPane(filename);
		setContentPane(html);
		setVisible(true);
		
		
	}
}
