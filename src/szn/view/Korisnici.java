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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import szn.model.KonekcijskaKlasa;
import szn.model.Korisnik;

public class Korisnici extends JFrame {
	Korisnik k;
	private JTextField txtKorisnicko;
	private JTextField txtSifra;
	private JComboBox<String> cbTip;
	
	private JComboBox<String> cbKorisnicko;
	private JTextField txtKorisnickoIzmena;
	private JTextField txtSifraIzmena;
	private JComboBox<String> cbTipIzmena;
	private JTextField txtNazivIzmena;

	private JComboBox<String> cbKorisnickoBrisanje;
	
	private JButton btnPotvrdiBrisanje;
	private JButton btnPotvrdiIzmenu;
	private JButton btnPotvrdi;
	
	private JPanel panel;
	
	public Korisnici(Korisnik kor){
		try {
			this.k = kor;
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void jbInit(){
		setTitle("Korisnici");
		
		//DODAVANJE
		JTabbedPane tabbedPane = new JTabbedPane();
		txtKorisnicko = new JTextField();
		txtSifra =  new JTextField();
		
		String[] tipovi = {"Administrator", "Sef stanice", "Kontrolor", "Radnik u centrali"};
		cbTip = new JComboBox<String>(tipovi);
	
		btnPotvrdi = new JButton("Dodaj korisnika");
		panel = new JPanel(new GridLayout(10,2,10,10));
		
		panel.add(new JLabel("Korisnicko ime: "));
		panel.add(txtKorisnicko);
		
		panel.add(new JLabel("Lozinka: "));
		panel.add(txtSifra);
		
		panel.add(new JLabel("Tip korisnika: "));
		panel.add(cbTip);
		
		panel.add(btnPotvrdi);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		tabbedPane.addTab("Dodavanje korisnika", panel);
		
		//IZMENA
		
		JPanel panel1 = new JPanel(new GridLayout(10,2,10,10));
		cbKorisnicko = new JComboBox<String>();
		
		try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();
			
			ArrayList<String> korisnici = kk.vratiSveKorisnike();
			for(String m : korisnici){
				cbKorisnicko.addItem(m);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		txtKorisnickoIzmena = new JTextField();
		txtSifraIzmena =  new JTextField();
		
		String[] tipoviIzmena = {"Administrator", "Sef stanice", "Kontrolor", "Radnik u centrali"};
		cbTipIzmena = new JComboBox<String>(tipovi);
	
		btnPotvrdiIzmenu = new JButton("Izmeni korisnika");
		panel1 = new JPanel(new GridLayout(10,2,10,10));
		
		panel1.add(new JLabel("Korisnicko ime: "));
		panel1.add(cbKorisnicko);
		
		panel1.add(new JLabel("Novo korisnicko ime: "));
		panel1.add(txtKorisnickoIzmena);
		
		panel1.add(new JLabel("Lozinka: "));
		panel1.add(txtSifraIzmena);
		
		panel1.add(new JLabel("Tip korisnika: "));
		panel1.add(cbTipIzmena);
		
		panel1.add(btnPotvrdiIzmenu);
		panel1.setBorder(new EmptyBorder(20, 20, 20, 20));
		tabbedPane.addTab("Izmena", panel1);
		
		//BRISANJE
		
		JPanel panel2 = new JPanel(new GridLayout(10,2,10,10));
		
		cbKorisnickoBrisanje = new JComboBox<String>();
		
		try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();
			
			ArrayList<String> korisnici = kk.vratiSveKorisnike();
			for(String m : korisnici){
				cbKorisnickoBrisanje.addItem(m);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		btnPotvrdiBrisanje = new JButton("Izbrisi");
		
		panel2.add(new JLabel("Korisnicko ime: "));
		panel2.add(cbKorisnickoBrisanje);
		
		panel2.add(btnPotvrdiBrisanje);
		panel2.setBorder(new EmptyBorder(20, 20, 20, 20));
		tabbedPane.addTab("Brisanje", panel2);
		this.add(tabbedPane, BorderLayout.CENTER);
		
		this.setSize(450, 400);
		
	}

}
