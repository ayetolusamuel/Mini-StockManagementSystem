package Setnumd;


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("serial")
public class stockmanagement2 extends JFrame implements ActionListener, FocusListener {
	CheckboxGroup cbmf;
	Checkbox cbm, cbf;
	ResultSet rs = null;
	Statement stmt = null;
	Connection conn = null;
	private JScrollPane p;
	Container cont;
	String user = "ayets";
	String pass = "setonji04";
	private JPanel pAdmin = new JPanel();
	private JLabel lblDate, lblTime, lblcId, lblsoldout,lblinstore,
	lblqty, lblpname, lblprice,	lblpassword,lblposition;
	JLabel lbl1, lbldd;
	String txting = "ggts";
	String txt1=txting.toUpperCase();
	private JTextArea txtrAddress;
	String[] name={"Select","User","Manager"};
	private JComboBox jcmbposition;
	private JTextField txtDate, txtTime, txtstaffID, txtsoldout,txtinstore,
	txtqty,txtpname,txtprice, txtaNumber, txtbName;
		
	TextArea txtOthers;
	private JPasswordField txtpassword;
	PreparedStatement ps = null;

	JButton btnSave, btnRemove, btnRefresh, btnExit, btnModify, btnNew,	btnOk,
	btnClear;

	private java.util.Date currDate = new java.util.Date(); // Creating Object.
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
			Locale.getDefault()); // Changing Format.
	private String d = sdf.format(currDate); // Storing Date.

	String timeStamp = new SimpleDateFormat("hh :mm: ss").format(Calendar
			.getInstance().getTime());

	// Statement for Getting the Required Table.
	private long id = 0; // To Hold the BookId.
	private JLabel lblpdetails;
	private JLabel lblcat;
	private JTextField txtcat;
	private JButton btnsave2;
	private JButton btnref;
	private JButton btnckproduct;

	// Constructor of Class.

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public stockmanagement2() {
		pAdmin =new JPanel(){
			
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("images//plain.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,500,550,null);
			}
		}
		
		
	;
		setTitle("Staff Payroll System");
		setSize(397, 510);
		setLocation(100, 60);
	
		pAdmin.setLayout(null);

		lblDate = new JLabel("<html><b><b>Date :</i></b></html>");
		lblDate.setForeground(Color.white);
		lblDate.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblDate).setBounds(10, -40, 70, 120);

		txtDate = new JTextField(d);
		txtDate.setFont(new Font("Algerian", Font.ITALIC, 16));
		txtDate.setEditable(false);
		pAdmin.add(txtDate).setBounds(90, 12, 130, 20);

		lblTime = new JLabel("<html><i><b>Time :</i></b></html>");
		lblTime.setForeground(Color.white);
		lblTime.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		pAdmin.add(lblTime).setBounds(10, -10, 70, 120);
		txtTime = new JTextField(timeStamp);
		txtTime.setEditable(false);
		txtTime.setFont(new Font("Algerian", Font.ITALIC, 14));
		pAdmin.add(txtTime).setBounds(90, 40, 130, 20);

	

		lblcId = new JLabel("<html><i><b>Product Code:</i></b></html>");
		lblcId.setForeground(Color.white);
		lblcId.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		pAdmin.add(lblcId).setBounds(10, 16, 180, 120);
		String txt= "Set";
		
		txtstaffID = new JTextField(txt);
		txtstaffID.setEditable(true);
		txtstaffID.setCaretPosition(3);
		txtstaffID.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtstaffID.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		pAdmin.add(txtstaffID).setBounds(90, 68, 70, 20);
		
		
		btnOk = new JButton(new ImageIcon("images//sam.gif"));
		pAdmin.add(btnOk).setBounds(180, 65, 38, 25);
		btnOk.addActionListener(this);
		
		
		
		
		

		
		lblsoldout = new JLabel("<html><b>Sold-Out :</i></b></html>");
		lblsoldout.setForeground(Color.white);
		lblsoldout.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		pAdmin.add(lblsoldout).setBounds(10, 48, 180, 120);
		txtsoldout = new JTextField();
		txtsoldout.setText("0");
		txtsoldout.setCaretPosition(1);
		txtsoldout.setEnabled(false);
		txtsoldout.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtsoldout.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!(c == KeyEvent.VK_BACK_SPACE)) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		pAdmin.add(txtsoldout).setBounds(90, 100, 100, 20);
	
		
		

		
		lblinstore = new JLabel("<html><b>In - Store :</i></b></html>");
		lblinstore.setForeground(Color.white);
		lblinstore.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		pAdmin.add(lblinstore).setBounds(10, 78, 180, 120);
		txtinstore = new JTextField();
		txtinstore.setEditable(false);
		txtinstore.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtinstore.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!(c == KeyEvent.VK_BACK_SPACE)) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		pAdmin.add(txtinstore).setBounds(90, 132, 100, 20);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		lblqty = new JLabel("<html><b>Qty :</i></b></html>");
		lblqty.setForeground(Color.white);
		lblqty.setEnabled(false);
		lblqty.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		pAdmin.add(lblqty).setBounds(120, 118, 180, 120);
		txtqty= new JTextField();
		txtqty.setEnabled(false);
		txtqty.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtqty.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!(c == KeyEvent.VK_BACK_SPACE)) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		pAdmin.add(txtqty).setBounds(150, 170, 60, 20);
	
		lblpname = new JLabel("<html><b>Product Name :</i></b></html>");
		lblpname.setForeground(Color.white);
		lblpname.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		pAdmin.add(lblpname).setBounds(10, 148, 180, 120);
		txtpname = new JTextField();
		txtpname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtpname.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {
					if (!(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7'
							|| c == '8' || c == '9' || c == '_' || c == '@'
							|| c == '-' || c == '.')) {

						getToolkit().beep();
						ke.consume();
					}
				}

			}
		});
		pAdmin.add(txtpname).setBounds(90, 202, 370, 20);
	
		
		
	
		
		lblprice = new JLabel("<html><b>Price :</i></b></html>");
		lblprice.setForeground(Color.white);
		lblprice.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		pAdmin.add(lblprice).setBounds(10, 118, 180, 120);
		txtprice = new JTextField("₦");
		txtprice.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtprice.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!((Character.isAlphabetic(c)) || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE))) {

					getToolkit().beep();
					ke.consume();
				}

			}
		});
		pAdmin.add(txtprice).setBounds(50, 170, 60, 20);
	
		
		lblcat = new JLabel("<html><b>Product Cat.:</i></b></html>");
		lblcat.setForeground(Color.white);
		lblcat.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		pAdmin.add(lblcat).setBounds(10, 230, 180, 20);
		txtcat = new JTextField();
		txtcat.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				char c = ke.getKeyChar();

				if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
						|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
					getToolkit().beep();
					ke.consume();

				}
			}
		});
		txtcat.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		pAdmin.add(txtcat).setBounds(90,232,370,20);
		
		
		lblpdetails = new JLabel("<html><b>Product Details:</i></b></html>");
		lblpdetails.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblpdetails.setForeground(Color.white);
		pAdmin.add(lblpdetails).setBounds(10, 260, 120, 25);


	
		txtrAddress=new JTextArea();
		
		txtrAddress.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				
				if (! ((Character.isAlphabetic (c)) || (c == KeyEvent.VK_BACK_SPACE)||(c == KeyEvent.VK_SPACE))) {

					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' ||
				            c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c=='.'||c==',')) {
					
					 	getToolkit().beep ();
					ke.consume ();
				}
				}
		}}
		);
		txtrAddress.setToolTipText("Enter contributor residential  Address");
		txtrAddress.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		txtrAddress.setWrapStyleWord(true);
		txtrAddress.setLineWrap(true);
		txtrAddress.setFont(new Font("Times New Roman", Font.ITALIC, 14));
	
	
	 p=new JScrollPane(txtrAddress);
	
	 pAdmin.add(p).setBounds(90, 264, 370, 100);
	 
	 
	 
	 
	 btnref= new JButton("Refresh");
	 
	 
	 btnckproduct = new JButton("Check Pdt.");
	 
		btnSave = new JButton("Update Product");
		//pAdmin.add(btnSave).setBounds(0, 366, 125, 25);
		btnClear = new JButton("Sale Management");
		//pAdmin.add(btnClear).setBounds(150, 366, 155, 25);
		btnRefresh = new JButton("Save");
		btnsave2 = new JButton("Save");
		
		//pAdmin.add(btnRefresh).setBounds(318, 366, 75, 25);
		btnExit = new JButton("Exit");
		//pAdmin.add(btnExit).setBounds(399, 366, 75, 25);
		//cont=getContentPane();
	    
		//cont.add( new textstaffreg(),BorderLayout.NORTH);
		getContentPane().add(pAdmin, BorderLayout.CENTER);

		btnClear.addActionListener(this);
		btnSave.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnExit.addActionListener(this);
		btnOk.addActionListener(this);
		btnsave2.addActionListener(this);

		String url = "jdbc:mysql://localhost:3306/setnumdstock";
		try {
			
			
		conn = DriverManager.getConnection(url,"root","setonji04");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);


	}
		
		}
	

void productdetails(){
	
	try{
	String s = JOptionPane.showInputDialog(null,"Enter the Product code");
	//String s="Set0003";
	
	String urlimage="C:/Users/DELL/workspace/FirstApp/html files/"+s+".html";

	
	//htmlfile s = new htmlfile("More Info About the Product","C:/Users/DELL/workspace/FirstApp/html files/Set0003.html");
	htmlfile sam = new htmlfile("More Info About the Product",urlimage);
	
	
	pane.add(sam);
	show();
	}
	
	catch (Exception e) {
		// TODO: handle exception
	
	
	System.out.println("Error");
	}


}


	
	void chkid(){
		String s=txtstaffID.getText();
		String urlimage="C:/Users/DELL/workspace/FirstApp/text files/"+s+".txt";

		
		
		String url1="images/"+s+".jpg";
		
		lbl1= new JLabel(new ImageIcon(url1));
		
		
		
		
		pAdmin.add(lbl1).setBounds(220,0,259,200);
BufferedReader in = null;
try {
    in = new BufferedReader(new FileReader(urlimage));
    String str;
    while ((str = in.readLine()) != null) {
        txtrAddress.append(str);
    }
} catch (IOException e) {
} finally {
    try { in.close(); } catch (Exception ex) { }
}


		/*String urlimage="C:/Users/DELL/workspace/FirstApp/html files/"+s+".html";

		
		//htmlfile s = new htmlfile("More Info About the Product","C:/Users/DELL/workspace/FirstApp/html files/Set0003.html");
		htmlfile sam = new htmlfile("More Info About the Product",urlimage);
		
		*/
		try

			{
				
			stmt=conn.createStatement();
			
			 String query = "select * from productnamecat where pcode like '"+txtstaffID.getText()+"'";
	         
		
			rs = stmt.executeQuery(query);
				
			while (rs.next()) {
			txtpname.setText(rs.getString("productname"));
				txtcat.setText(rs.getString("productcat"));
				txtprice.setText(rs.getString("price"));
				//txtrAddress.setText(sam);
				
			}}
			catch (Exception ez) {
				// TODO: handle exception
			}
		
		

	pAdmin.add(btnSave).setBounds(0, 366, 125, 25);
		
	pAdmin.add(btnref).setBounds(0, 336, 80, 25);
	btnref.setFont(new Font("Times New Roman", Font.ITALIC, 14));
	pAdmin.add(btnckproduct).setBounds(0, 306, 90, 25);
	btnckproduct.setFont(new Font("Times New Roman", Font.ITALIC, 12));
	pAdmin.add(btnClear).setBounds(150, 366, 155, 25);
		pAdmin.add(btnRefresh).setBounds(318, 366, 75, 25);
		pAdmin.add(btnExit).setBounds(399, 366, 75, 25);
		
		
	}
	
	void manageproduct(){
		

		
		
		
		 if(txtstaffID.getText().equals("Set")){
		//	System.out.println("fill all empty field");
			JOptionPane.showMessageDialog(null, "Input valid product Code");	
		
		 }
		 else{
			 
		
		String sql="INSERT INTO salemanagent(date,time,pcode,soldout,price)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtstaffID.getText()+"','"+txtsoldout.getText()+"','"+txtprice.getText()+"')";
		
		try{
			ps=conn.prepareStatement(sql);
			//System.out.println("sas");
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Saved into Database");
		txtstaffID.setText("Set");

			ps.close();
		}catch (SQLException e1) {
			System.out.println("uuuuuuuuuuuuuuuu");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}}
				
	void Updateproduct(){
		
		
		
	
		
		 if(txtstaffID.getText().equals("")){
		//	System.out.println("fill all empty field");
			JOptionPane.showMessageDialog(null, "Input valid product Code");	
		
		 }
		 else{
			 
		
		String sql="INSERT INTO productupdate(date,time,pcode,qty)values('"+txtDate.getText()+"','"+txtTime.getText()+"','"+txtstaffID.getText()+"','"+txtqty.getText()+"')";
		
		try{
			ps=conn.prepareStatement(sql);
			//System.out.println("sas");
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Saved into Database");
		

			ps.close();
		}catch (SQLException e1) {
			System.out.println("uuuuuuuuuuuuuuuu");
			// TODO Auto-generated catch block
			e1.printStackTrace();
}}}
		
	
	public static void main(String[] args) {
		stockmanagement2 sam = new stockmanagement2();
		sam.setSize(480, 420);
		sam.setVisible(true);
		sam.setResizable(false);
		sam.setLocationRelativeTo(null);

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
if(obj==btnSave){
txtqty.setEnabled(true);
lblqty.setEnabled(true);

	
}else if(obj==btnOk){
	chkid();
	/*if(obj==btnSave){
		
		
		txtqty.setEnabled(true);
		lblqty.setEnabled(true);}
		else{
		txtsoldout.setEnabled(true);
		lblsoldout.setEnabled(true);
	}
	*/
	
	
	
}
else if(obj==btnRefresh){
	Updateproduct();
	
	
}

else if(obj==btnsave2){
	manageproduct();
	
}
else if(obj==btnClear){
txtsoldout.setEnabled(true);
lblsoldout.setEnabled(true);
txtsoldout.setEditable(true);
txtqty.setEnabled(false);
lblqty.setEnabled(false);
pAdmin.add(btnRefresh).setBounds(0, 0, 0, 0);
pAdmin.add(btnsave2).setBounds(318, 366, 75, 25);
	
}
else if(obj==btnExit){
	
	
}
	
	
	}
	
	}