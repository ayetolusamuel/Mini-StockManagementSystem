package Setnumd;

import java.awt.Container;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Document;

public class HtmlPane extends JScrollPane implements HyperlinkListener{
JEditorPane html;


HtmlPane(String filename){
	try{
		
		File f =new File(filename);
		String s= f.getAbsolutePath();
		s="file:" +s;
		URL url = new URL(s);
		html = new JEditorPane(s);
		html.setEditable(false);
		html.addHyperlinkListener(this);
		JViewport vp = getViewport();
		vp.add(html);
		
	}
	
	catch(MalformedURLException e){}
	
	catch (Exception e) {
		// TODO: handle exception
	}
	
}



	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		// TODO Auto-generated method stub
		if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
			
			
		}
	}

	protected void linkActivated(URL u){
		
		
		Cursor c= html.getCursor();
		Cursor waitCursor=Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
		html.setCursor(waitCursor);
		SwingUtilities.invokeLater(new PageLoader (u, c));
		
		
	}
	class PageLoader implements Runnable{
		
		PageLoader(URL u, Cursor c){
		url =u;
		cursor = c;
	}
public void run(){
	
	
	if(url==null){
		html.setCursor(cursor);
		Container parent = html.getParent();
		parent.repaint();
		
	}
	
	
	else{
		Document doc= html.getDocument();
		try{
			html.setPage(url);
		}
		catch(IOException ioe){
		html.setDocument(doc);
	getToolkit().beep();
	
	}
finally {
	url=null;
	SwingUtilities.invokeLater(this);
	
}
}
}
URL url;

Cursor cursor;}}