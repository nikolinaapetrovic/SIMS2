package szn.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import szn.model.Korisnik;
import szn.model.TipKorisnika;

import java.sql.*; 


public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4039420305559425537L;
	JButton PRIJAVA;
	JPanel panel;
	JTextField txtUsername, txtPassword;
	
	public Login(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jbInit(){
		JLabel lblUsername = new JLabel();
		lblUsername.setText("Username:");
		txtUsername = new JTextField(30);
		
		JLabel lblPassword = new JLabel();
		lblPassword.setText("Password:");
		txtPassword = new JPasswordField(30);
		
		JButton login = new JButton("Log in");
		
		panel=new JPanel(new GridLayout(3,1));
		panel.add(lblUsername);
		panel.add(txtUsername);
		panel.add(lblPassword);
		panel.add(txtPassword);
		panel.add(login);

		this.setSize(350,150);

		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(panel,BorderLayout.CENTER);
		login.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) { 
		 String user = txtUsername.getText();
		 String pass = txtPassword.getText();
		 
		  String connectionUrl = "jdbc:sqlserver://NIKOLINAP;databaseName=SIMS;integratedSecurity=true;";
	 
	      Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  

	      try {  
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	         con = DriverManager.getConnection(connectionUrl);  
 
	         String SQL = "SELECT * FROM tblKorisnici";  
	         stmt = con.createStatement();  
	         rs = stmt.executeQuery(SQL);  
	         
	         boolean nadjen = false;
	         while (rs.next()) { 
	            if(user.equals(rs.getString(1)) && pass.equals(rs.getString(2))){
	            	Korisnik k = new Korisnik(rs.getString(1), rs.getString(2), TipKorisnika.SEF);
       
	            	if(rs.getString(3).equals("1")){ //admin
	            		AdminView av = new AdminView(k);
	            		av.setVisible(true);
	            	}else if(rs.getString(3).equals("2"))//sef stanice
	            	{
	    
	            		SefStanice sef = new SefStanice(k);
	            		sef.setVisible(true);
	            	}else if(rs.getString(3).equals("3")){ //kontrolor
	            		DodavanjeNaplate dn = new DodavanjeNaplate(k);
	            		dn.setVisible(true);
	            	}else if(rs.getString(3).equals("4")){ //radnik u centrali
	            		CentralaView dn = new CentralaView(k);
	            		dn.setVisible(true);
	            	}
	            	
	            	this.setVisible(false);
					nadjen = true;
					break;
	            }
	         }
	         
	         if(!nadjen){
	        	 JOptionPane.showMessageDialog(this,"Nevalidno korisnicko ime ili lozinka", "Error",JOptionPane.ERROR_MESSAGE);
					
	         }
	      }  

	      // Handle any errors that may have occurred.  
	      catch (Exception e1) {  
	         e1.printStackTrace();  
	      }  
	      finally {  
	         if (rs != null) try { rs.close(); } catch(Exception e1) {}  
	         if (stmt != null) try { stmt.close(); } catch(Exception e1) {}  
	         if (con != null) try { con.close(); } catch(Exception e1) {}  
	      }  
		 
	}
}
