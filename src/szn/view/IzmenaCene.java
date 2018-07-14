package szn.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import szn.model.KonekcijskaKlasa;
import szn.model.Korisnik;

public class IzmenaCene  extends JFrame{
	Korisnik k;
	private JComboBox<String> cbDeonica;
	private JComboBox<String> cbKategorija;

	private JComboBox<String> cbValuta;
	private JTextField txtCena;
	private JButton btnPotvrdi;
	private JPanel panel;
	
	public IzmenaCene(Korisnik kor){
		try {
			this.k = kor;
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jbInit(){
		String[] kategorije = {"I KATEGORIJA", "I-A KATEGORIJA", "II KATEGORIJA", "III KATEGORIJA", "IV KATEGORIJA"};
		cbKategorija = new JComboBox<String>(kategorije);
		cbDeonica = new JComboBox<String>();
		try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();
			ArrayList<String> mesta = kk.vratiMestaDolaska(k);
			
			for(String m : mesta){
				cbDeonica.addItem(m);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		txtCena = new JTextField();
		btnPotvrdi = new JButton("Potvrdi");
		
		String[] valuta = {"Evro", "Dinar"};
		cbValuta = new JComboBox<String>(valuta);
		
		
		panel = new JPanel(new GridLayout(10,2,10,10));
		
		panel.add(new JLabel("Mesto dolaska: "));
		panel.add(cbDeonica);
		
		panel.add(new JLabel("Kategorija vozila: "));
		panel.add(cbKategorija);
		
		panel.add(new JLabel("Nova cena: "));
		panel.add(txtCena);
		
		panel.add(new JLabel("Valuta:"));
		panel.add(cbValuta);
		
		panel.add(btnPotvrdi);
		
		this.setSize(450, 400);

		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(panel,BorderLayout.CENTER);
	}

}
