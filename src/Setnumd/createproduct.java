package Setnumd;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class createproduct extends JFrame implements ActionListener {
private JLabel lblsNumber,lblDate,lblTime,lblpName,lblpCategory,lblnoProduct,lblaoProduct,lbltpAmount;
private JTextField txtsNumber,txtDate,txtTime,txtnoProduct,txtaoProduct,txttpAmount;
private JComboBox<String > cmbpName,cmbpCategory;
String[] pcat={"Select","SECURITY & SURVELLANCE","AUTOMOBILE TOOLS & ACCESSORIES","OFFICE TOOLS","HOME & HEALTH","","","","","","","","","","","","","","","","","","","","","","",""};
String[] pname={"Select","8GB WATERPROOF","8GB SC","SMART WATCH 8GB","CAR KEYHOLDER","DIGITAL TABLE CLOCK","ANALOG TABLE CLOCK","TERMINATOR STUN GUN","SPY WALL CLOCK","CCTV KIT","WALL CLOCK+WIFI MONITOR",""
		+"","","","","","","","","","","","","","","","","","","","",""};




String[] name= {"","Admin","MD"};
private Connection con= null;
private Statement st = null;
private ResultSet rs = null;
private JButton btnSave,btnModify,btnCancel,btnClear,btnpAdd;
private JPanel pane;
	public createproduct() {
		// TODO Auto-generated constructor stub
	//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setResizable(false);
	//setLocationRelativeTo(null);
	pane= new JPanel();
	pane.setLayout(null);
	lblsNumber = new JLabel("<html><i>Ser. Number: ");
	pane.add(lblsNumber).setBounds(40,180,100,25);
	txtsNumber = new JTextField();
	pane.add(txtsNumber).setBounds(120,182,100,20);
	
	lblDate = new JLabel("<html><i>Date: ");
	pane.add(lblDate).setBounds(40,220,100,25);
	txtDate = new JPasswordField();
	pane.add(txtDate).setBounds(120,222,100,20);
	
	
	lblTime = new JLabel("<html><i>Time: ");
	pane.add(lblTime).setBounds(40,260,100,25);
	txtTime = new JTextField();
	pane.add(txtTime).setBounds(120,262,100,20);
	
	
	lblpName = new JLabel("<html><i>Prod. Name: ");
	pane.add(lblpName).setBounds(40,300,100,25);
	cmbpName = new JComboBox<String>(pname);
	pane.add(cmbpName).setBounds(120,302,240,20);
	
	
	
	
	lblpCategory = new JLabel("<html><i>Prod. Cat.: ");
	pane.add(lblpCategory).setBounds(40,340,100,25);
	cmbpCategory = new JComboBox<String>(pcat);
	pane.add(cmbpCategory).setBounds(120,342,240,20);
	
	
	

	lblnoProduct = new JLabel("<html><i>Num. of Prod.: ");
	pane.add(lblnoProduct).setBounds(40,380,100,25);
	txtnoProduct = new JTextField();
	pane.add(txtnoProduct).setBounds(123,382,70,20);
	
	
	btnpAdd = new JButton();
	btnpAdd.setText("<html><i>click to add product number");
	pane.add(btnpAdd).setBounds(230,380,200,20);
	btnpAdd.addActionListener(this);
	
	
	

	lblnoProduct = new JLabel("<html><i>New Num. of Prod.: ");
	pane.add(lblnoProduct).setBounds(40,420,100,25);
	txtnoProduct = new JTextField();
	pane.add(txtnoProduct).setBounds(123,422,70,20);
	

	lblnoProduct = new JLabel("<html><i>Total Num. of Prod.: ");
	pane.add(lblnoProduct).setBounds(40,460,100,25);
	txtnoProduct = new JTextField();
	pane.add(txtnoProduct).setBounds(123,462,70,20);
	

	lblaoProduct = new JLabel("<html><i>Prod. Amount.: ");
	pane.add(lblaoProduct).setBounds(230,420,100,25);
	txtaoProduct = new JTextField();
	pane.add(txtaoProduct).setBounds(350,422,80,20);
	

	lbltpAmount = new JLabel("<html><i>Prod.total Amount.: ");
	pane.add(lbltpAmount).setBounds(230,460,200,25);
	txttpAmount = new JTextField();
	pane.add(txttpAmount).setBounds(350,462,80,20);
	
	
	
	
	
	
	
	
	
	
	
	
	
	btnSave = new JButton();
	btnSave.setText("<html><i>Save");
	pane.add(btnSave).setBounds(50,500,80,20);
	btnSave.addActionListener(this);
	
	
	btnModify = new JButton();
	btnModify.setText("<html><i>Modify");
	pane.add(btnModify).setBounds(150,500,80,20);
	btnModify.addActionListener(this);
	
	btnClear = new JButton();
	btnClear.setText("<html><i>Clear");
	pane.add(btnClear).setBounds(250,500,80,20);
	btnClear.addActionListener(this);
	
	
	btnCancel = new JButton();
	btnCancel.setText("<html><i>Cancel");
	pane.add(btnCancel).setBounds(350,500,80,20);
	btnCancel.addActionListener(this);
	
	JLabel lbl1= new JLabel(new ImageIcon("images/advert.jpg"));
	pane.add(lbl1).setBounds(-70,-30,600,700);
	
	
	getContentPane().add(pane,BorderLayout.CENTER);
	
	}
	public static void main(String[] args) {
		createproduct sam = new createproduct();
		sam.setSize(469,600);
		sam.setVisible(true);
		sam.setLocationRelativeTo(null);
		
	}
	void insertUpdate(){
		
		String sql="INSERT INTO `login` (`username`, `password`) VALUES ('"+txtsNumber.getText()+"', '"+txtDate.getText()+"')";
		
		
		
	}
	
	void txtclear(){
		txtsNumber.setText("");
		txtDate.setText("");
		cmbpName.setSelectedItem("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj= e.getSource();
		if(obj==btnSave){
			System.out.println("EEEEEEEEEEE");
		}
		else if(obj==btnCancel){
			dispose();
		}
		else if(obj==btnClear){
			txtclear();
			
		}
		
		
	}
	
	
}
