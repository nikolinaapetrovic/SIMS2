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

public class NaplatneStaniceView extends JFrame{
	Korisnik k;
	private JTextField txtId;
	private JTextField txtNaziv;
	
	private JComboBox<String> cbIdIzmena;
	private JTextField txtNazivIzmena;

	private JComboBox<String> cbIdBrisanje;
	
	private JButton btnPotvrdiBrisanje;
	private JButton btnPotvrdiIzmenu;
	private JButton btnPotvrdi;
	
	private JPanel panel;
	
	public NaplatneStaniceView(Korisnik kor){
		try {
			this.k = kor;
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void jbInit(){
		setTitle("Naplatne stanice");
		
		//DODAVANJE
		JTabbedPane tabbedPane = new JTabbedPane();
		txtId = new JTextField();
		txtNaziv =  new JTextField();
		btnPotvrdi = new JButton("Dodaj naplatnu stanicu");
		panel = new JPanel(new GridLayout(10,2,10,10));
		
		panel.add(new JLabel("Id naplatne stanice: "));
		panel.add(txtId);
		
		panel.add(new JLabel("Naziv: "));
		panel.add(txtNaziv);
		
		
		panel.add(btnPotvrdi);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		tabbedPane.addTab("Dodavanje naplatne stanice", panel);
		
		//IZMENA
		JPanel panel1 = new JPanel(new GridLayout(10,2,10,10));
		
		cbIdIzmena = new JComboBox<String>();
		txtNazivIzmena = new JTextField();
		btnPotvrdiIzmenu = new JButton("Izmeni");
		
		try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();

			ArrayList<String> stanice =  kk.vratiSveNaplatneStanice();
			for(String m : stanice){
				cbIdIzmena.addItem(m);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		panel1.add(new JLabel("ID Naplatne stanice: "));
		panel1.add(cbIdIzmena);
		
		panel1.add(new JLabel("Naziv: "));
		panel1.add(txtNazivIzmena);
		
		panel1.add(btnPotvrdiIzmenu);
		
		panel1.setBorder(new EmptyBorder(20, 20, 20, 20));
		tabbedPane.addTab("Izmena", panel1);
		
		//BRISANJE
		
		JPanel panel2 = new JPanel(new GridLayout(10,2,10,10));
		
		cbIdBrisanje = new JComboBox<String>();
		btnPotvrdiBrisanje = new JButton("Izbrisi");
		
		try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();

			ArrayList<String> stanice =  kk.vratiSveNaplatneStanice();
			for(String m : stanice){
				cbIdBrisanje.addItem(m);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		panel2.add(new JLabel("ID Naplatne stanice: "));
		panel2.add(cbIdBrisanje);
		
		panel2.add(btnPotvrdiBrisanje);
		panel2.setBorder(new EmptyBorder(20, 20, 20, 20));
		tabbedPane.addTab("Brisanje", panel2);
		this.add(tabbedPane, BorderLayout.CENTER);
		
		this.setSize(450, 400);
		
	}		
}
