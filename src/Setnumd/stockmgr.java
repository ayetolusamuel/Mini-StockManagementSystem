package Setnumd;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class stockmgr extends JFrame implements ActionListener{
private JLabel lblName,lblPassword,lblPosition,lblPCode,lblProductPrice,lblProductName,lbl1,lblProductCat;
private JTextField txtName,txtPosition,txtPCode,txtProductPrice,txtProductName,txtProductCat;
JButton btnOk;
private JComboBox<String > cmbProductCat,cmbPCode;

String[] name= {"","Admin","MD"};
private Connection con= null;
private Statement st = null;
private ResultSet rs = null;
private JButton btnUpdate,btnProductInfo,btnProductdetails,btnClear,btnSearchProduct,btnProductNameCat,btnSave,btnExit,btnUpdateFinish;
private JPanel pane,pane1;
private PreparedStatement ps;
private Connection conn;

	public stockmgr() {
		// TODO Auto-generated constructor stub
	//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setResizable(false);
	//setLocationRelativeTo(null);
	pane=new JPanel()
	{
		public void paintComponent(Graphics g)
		{
			Toolkit kit=Toolkit.getDefaultToolkit();
			//Image img=kit.getImage("images//index.jpg");
			Image img=kit.getImage("images//badagry2.jpg");
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
			g.drawImage(img,0,0,500,350,null);
		}
	};
	
	
	
	
	pane.setLayout(null);
	lblPCode = new JLabel("<html><i>Product Code: ");
	pane.add(lblPCode).setBounds(10,180,100,25);
	txtPCode = new JTextField();
	txtPCode.setEditable(false);
	txtPCode.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	pane.add(txtPCode).setBounds(120,182,100,20);
	
	
	
	lblProductPrice = new JLabel("<html><i>Product Price{₦}");
	pane.add(lblProductPrice).setBounds(10,210,100,25);
	txtProductPrice = new JTextField();
	txtProductPrice.setEditable(false);
	txtProductPrice.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	pane.add(txtProductPrice).setBounds(120,212,100,20);
	
	
	lblProductName = new JLabel("<html><i>Product Name ");
	pane.add(lblProductName).setBounds(10,240,100,25);
	txtProductName = new JTextField();
	txtProductName.setEditable(false);
	txtProductPrice.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	pane.add(txtProductName ).setBounds(130,242,300,20);
	
	lblProductCat= new JLabel("<html><i>Product Cat.: ");
	pane.add(lblProductCat).setBounds(10,270,200,25);
	txtProductCat = new JTextField();
	txtProductCat.setEnabled(true);
	txtProductPrice.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	txtProductCat.setEditable(false);
	pane.add(txtProductCat).setBounds(130,272,300,20);
	
	cmbProductCat = new JComboBox<String>(name);
	cmbProductCat.setEnabled(false);
	pane.add(cmbProductCat).setBounds(130,272,300,20);
	/*
	JLabel lblpi =new JLabel(new ImageIcon("images//profilepic"));
	pane.add(lblpi).setBounds(30,40,200,200);;
	HDMI-To-VGA-Converter-White
	*/
//String s="images.png";
//String s=txtPCode.getText();
//System.out.println(s);


	//String urlimage="images/"+s;
	
	//JLabel lbl4= new JLabel(new ImageIcon("images/images.png"));
	//JLabel lbl1= new JLabel(new ImageIcon(urlimage));
	
	//System.out.println(urlimage);
	//pane.add(lbl4).setBounds(250,0,250,230);
	
	
	
	
	
	btnProductNameCat = new JButton();
	btnProductNameCat.setText("<html><i>click here to add new product name and category");
	btnProductNameCat.setFont(new Font("Times New Roman",Font.BOLD,12));
pane.add(btnProductNameCat).setBounds(0,10,250,20);

btnProductNameCat.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
btnProductNameCat.addActionListener(this);
	
	btnProductdetails = new JButton();
	btnProductdetails.setText("<html><i>click here for more information about Product");
	pane.add(btnProductdetails).setBounds(0,40,250,20);
	btnProductdetails.setFont(new Font("Times New Roman",Font.BOLD,12));
	btnProductdetails.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
	btnProductdetails.addActionListener(this);
	

btnSearchProduct = new JButton();
btnSearchProduct.setText("<html><i>Search for the product using product code");
btnSearchProduct.setFont(new Font("Times New Roman",Font.BOLD,13));
	
pane.add(btnSearchProduct).setBounds(0,70,250,20);
btnSearchProduct.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
btnSearchProduct.addActionListener(this);
btnUpdate = new JButton();
btnUpdate.setText("<html><i> update product name and category");
pane.add(btnUpdate).setBounds(0,100,250,20);
btnUpdate.setFont(new Font("Times New Roman",Font.BOLD,13));
btnUpdate.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
btnUpdate.addActionListener(this);




btnOk = new JButton(new ImageIcon("images//sam.gif"));
//pane.add(btnOk).setBounds(220,180,30,25);
btnOk.addActionListener(this);


btnProductInfo = new JButton();
btnProductInfo.setText("<html><i>More info about the product");

btnProductInfo.addActionListener(this);
	


		btnSave = new JButton();
		btnSave.setText("<html><i>Saved");
	//pane.add(btnSave).setBounds(10,300,70,20);
	btnSave.addActionListener(this);
	
	btnUpdateFinish = new JButton();
	btnUpdateFinish.setText("<html><i>Update");
	//pane.add(btnUpdateFinish).setBounds(70,300,80,20);
	btnUpdateFinish.addActionListener(this);
	
	
	btnClear = new JButton();
	btnClear.setText("<html><i>Refresh");
	//pane.add(btnCancel).setBounds(170,300,80,20);
	btnClear.addActionListener(this);
	
	
	btnExit = new JButton();
	btnExit.setText("<html><i>Exit");
	//pane.add(btnExit).setBounds(260,300,80,20);
	btnExit.addActionListener(this);
	

	
	getContentPane().add(pane,BorderLayout.CENTER);
	
	

	String url = "jdbc:mysql://localhost:3306/setnumdstock";
	try {
		
		
	conn = DriverManager.getConnection(url,"root","");
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	 JOptionPane.showMessageDialog(null, "Failed Connection,ON your Local Server","Error",JOptionPane.ERROR_MESSAGE);

//	e1.printStackTrace();
}
	fill_fields();
	}
	
	
	public void fill_fields(){
		try

		{
			
		st=conn.createStatement();
		rs = st.executeQuery("select * from productnamecat ");
			
		while (rs.next()) {
			
			//txtPCode.setText(rs.getString("pcode"));
			//txtifName.setText(rs.getString(txtifName.getText().equalsIgnoreCase(cmbtiID.setSelectedItem(getName()))));
			//cmbsID.setFont(new Font("Times New Roman",Font.ITALIC,13));
			
		}}
		catch (Exception e) {
			// TODO: handle exception
		}

		}
	public static void main(String[] args) {
		stockmgr sam = new stockmgr();
		sam.setSize(500,350);
		sam.setVisible(true);
		sam.setLocationRelativeTo(null);
		
	}
	/*void insertUpdate(){
		
		String sql="INSERT INTO `login` (`username`, `password`) VALUES ('"+txtName.getText()+"', '"+txtPassword.getText()+"')";
		
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}*/
@SuppressWarnings("deprecation")
/*	void urlimage(){
		String s=txtPCode.getText();
		System.out.println(s+".jpg");
		
		String urlimage="images/"+s;
		
		//JLabel lbl1= new JLabel(new ImageIcon("images/images.png"));
		JLabel lbl1= new JLabel(new ImageIcon(urlimage));
		System.out.println(urlimage);
		pane.add(lbl1).setBounds(250,90,250,150);
		
		
	}*/


void update(){
	 String update1 = "Update productnamecat set price = '" + txtProductPrice.getText() +"' where pcode = '" + txtPCode.getText() + "'" ;
     String update2 = "Update productnamecat set productname = '" + txtProductName.getText() +"' where time = '" + txtPCode.getText() + "'" ;
     String update3 = "Update productnamecat set productcat = '" + txtProductCat.getText() +"' where time = '" + txtPCode.getText() + "'" ;
   
     
     try{
         st = con.createStatement();
         st.executeUpdate(update1);
         st.executeUpdate(update2);
         st.executeUpdate(update3);
      
         JOptionPane.showMessageDialog(null,"Update Finished!");
 	    
       st.close();
         con.close();
     }
     catch(SQLException ex){
         System.err.println(ex.getMessage());
     }
	
}
	void insertUpdate() throws SQLException{
		
		
			rs = st.executeQuery("select * from productnamecat ");
			try {
		 
			while(rs.next()){
			      String userID=rs.getString("pcode");
			     
			      if(userID.equals(txtPCode.getText())){
			      // ***HERE IS MY PROBLEM I WANT TO CHECK IF WHATS IN THE 
			      // TEXT FIELD OR PASSWORD FIELD IS THE SAME FROM MySQL***
			          JOptionPane.showMessageDialog(null,"Product Code Already taken");
			          //new MainForm().setVisible(true);


			      }
			}}
			      catch (Exception e) {
					// TODO: handle exception
				}}

			/*try {
	
		if(txtPCode.getText().equals("Set")){
			JOptionPane.showMessageDialog(null, "Invalid Product Code Add \"number\" to \"Set\"");
		}
		
		else if(txtPCode.getText().equals("")||txtProductName.getText().equals("")||txtProductCat.getText().equals("")){
			JOptionPane.showMessageDialog(null, "fill editable fields");
			
		}
		
		else{
		
			String sql="INSERT INTO `productnamecat` (`pcode`,`price`,`productname`, `productcat`) VALUES ('"+txtPCode.getText()+"','"+txtProductPrice.getText()+"','"+txtProductName.getText()+"', '"+txtProductCat.getText()+"')";

			
				ps=conn.prepareStatement(sql);
				ps.executeUpdate();
		}} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			 JOptionPane.showMessageDialog(null, "Saved into Database");
			 txtclear();
			
		}*/
		
		
	
	
	void txtclear(){
		txtProductCat.setText("");
		txtProductName.setText("");
		lbl1.setEnabled(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	/*	
		String s=txtPCode.getText();
		//System.out.println(s+".jpg");
		
		String urlimage="images/"+s+".jpg";
		
		//JLabel lbl1= new JLabel(new ImageIcon("images/images.png"));
		lbl1= new JLabel(new ImageIcon(urlimage));
		//System.out.println(urlimage);
		
		*/

		//String val = "SELECT * FROM productnamecat WHERE pcode = '"+txtPCode.getText()+"'";

		/*try {
			rs = st.executeQuery("SELECT * FROM productnamecat WHERE pcode = '"+txtPCode.getText()+"'");
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}*/
		//System.out.println(val);
		
		
		/*try {
			ps=conn.prepareStatement(val);
			System.out.println(val);
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
		Set0001
HDMI to VGA Converter -White
Office Tools
Set0002
Hand-Held 4 Digit Tally Counter
Office Tools
		*/
		Object obj= e.getSource();
		/*if(obj==btnSave){
		
		
		
			
		*/
		 if(obj==btnExit){
			dispose();
		}
		 else if(obj==btnSave){
			 try {
				insertUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }
		 
		 else if(obj==btnOk){
				String s=txtPCode.getText();
				
				String urlimage="images/"+s+".jpg";
				
				lbl1= new JLabel(new ImageIcon(urlimage));
				
				
				
				
				pane.add(lbl1).setBounds(250,0,250,240);
				
				try

				{
					
				st=conn.createStatement();
				
				 String query = "select * from productnamecat where pcode like '"+txtPCode.getText()+"'";
		         
				//String query= "Select * from productnamecat where pcode is ="+txtPCode.getText();
			
				rs = st.executeQuery(query);
				//System.out.println(query);
				
				//rs = st.executeQuery("select * from productnamecat where pcode= "txtPCode.getText()+" );
					
				while (rs.next()) {
				//	System.out.println(query);
					txtProductName.setText(rs.getString("productname"));
					txtProductCat.setText(rs.getString("productcat"));
					txtProductPrice.setText(rs.getString("price"));
					
					
				}}
				catch (Exception ez) {
					// TODO: handle exception
				}

				}

		else if(obj==btnClear){
			dispose();
			stockmgr sam = new stockmgr();
			sam.setSize(500,350);
			sam.setVisible(true);
			sam.setLocationRelativeTo(null);
			
		}
	else if(obj==btnProductNameCat){
			txtProductPrice.setEnabled(true);
			btnSearchProduct.setEnabled(false);
			btnProductdetails.setEnabled(false);
			txtPCode.setText("Set");
			txtProductPrice.setEditable(true);
			txtPCode.setEditable(true);
			txtProductName.setEditable(true);
			txtProductCat.setEditable(true);
			pane.add(btnSave).setBounds(10,300,130,20);
			pane.add(btnExit).setBounds(330,300,130,20);
			pane.add(btnClear).setBounds(170,300,130,20);
			
		}
		
		else if(obj==btnSearchProduct){
			
			txtProductPrice.setEditable(false);
			btnProductdetails.setEnabled(true);
			btnProductNameCat.setEnabled(false);
			pane.add(btnOk).setBounds(220,180,30,25);
			txtPCode.setText("Set");
			btnProductdetails.setEnabled(false);
			
			txtProductName.setEditable(false);
			txtProductCat.setEditable(false);
			btnProductInfo.setEnabled(true);
			pane.add(btnProductInfo).setBounds(20,300,200,20);
			pane.add(btnExit).setBounds(370,300,120,20);
			pane.add(btnClear).setBounds(230,300,130,20);
			txtPCode.setEditable(true);
			
			
		}
	}
	/*@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		String s=txtPCode.getText();
		System.out.println(s+".jpg");
		
		String urlimage="images/"+s;
		
		//JLabel lbl1= new JLabel(new ImageIcon("images/images.png"));
		JLabel lbl1= new JLabel(new ImageIcon(urlimage));
		System.out.println(urlimage);
		
		
		//pane.add(lbl1).setBounds(250,90,250,150);
		
		
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	*/
}



/*
try{
    Class.forName("java.sql.Driver");
    con=DriverManager.getConnection   ("jdbc:mysql://localhost/database","root","password");
    st=con.createStatement();
    rs=st.executeQuery("select * from users;");
    while(rs.next()){
              String userID=rs.getString("userID");
              String password=rs.getString("password");

              if(userID.equals(txtuserID.getText())
                  && (password.equals(txtpassword.getPassword())) {
              // ***HERE IS MY PROBLEM I WANT TO CHECK IF WHATS IN THE 
              // TEXT FIELD OR PASSWORD FIELD IS THE SAME FROM MySQL***
                  JOptionPane.showMessageDialog(null,"you have logged in");
                  new MainForm().setVisible(true);
              } else {
                  JOptionPane.showMessageDialog(null,"Incorrect username and password");
              }
   }
   
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   */
