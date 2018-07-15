package szn.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import szn.model.KonekcijskaKlasa;
import szn.model.Korisnik;

public class AdminView extends JFrame {
	
	Korisnik k;
	private JMenu menu;
	private JMenuBar menuBar;
	private JTextField txtId;
	private JComboBox<String> cbDeonice;
	private JComboBox<String> cbDolazak;
	private JComboBox<String> cbPolazak;
	private JComboBox<String> cbMesto;
	
	private JComboBox<String> cbDolazakIzmena;
	private JComboBox<String> cbPolazakIzmena;
	private JComboBox<String> cbMestoIzmena;
	private JButton btnPotvrdiIzmena;
	
	private JComboBox<String> cbDeoniceBrisanje;
	private JButton btnPotvrdiBrisanje;
	
	private JButton btnPotvrdi;
	private JPanel panel;
	
	public AdminView(Korisnik kor){
		try {
			this.k = kor;
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jbInit(){
		setTitle("Admin panel");
		
		kreirajMenu();
		
		//DODAVANJE DEONICE
		JTabbedPane tabbedPane = new JTabbedPane();
		txtId = new JTextField();
		
		cbPolazak = new JComboBox<String>();
		cbDolazak = new JComboBox<String>();
		cbMesto = new JComboBox<String>();
		btnPotvrdi = new JButton("Potvrdi");
		
		try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();
			
			ArrayList<String> mesta = kk.vratiSvaMesta();
			for(String m : mesta){
				cbPolazak.addItem(m);
				cbDolazak.addItem(m);
			}
			
			ArrayList<String> stanice =  kk.vratiSveNaplatneStanice();
			for(String m : stanice){
				cbMesto.addItem(m);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		panel = new JPanel(new GridLayout(10,2,10,10));
		
		panel.add(new JLabel("Id deonice: "));
		panel.add(txtId);
		
		panel.add(new JLabel("Mesto polaska: "));
		panel.add(cbPolazak);
		
		panel.add(new JLabel("Mesto dolaska: "));
		panel.add(cbDolazak);
		
		panel.add(new JLabel("Naplatno mesto: "));
		panel.add(cbMesto);
		
		panel.add(btnPotvrdi);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		tabbedPane.addTab("Dodavanje deonice", panel);
		
		JPanel panel1 = new JPanel(new GridLayout(10,2,10,10));
		
		//IZMENA DEONICE
		cbDeonice = new JComboBox<String>();
		cbPolazakIzmena = new JComboBox<String>();
		cbDolazakIzmena = new JComboBox<String>();
		cbMestoIzmena = new JComboBox<String>();
		btnPotvrdiIzmena = new JButton("Izmeni");
		
		try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();
			
			ArrayList<String> deonice = kk.vratiSveDeonice();
			for(String m : deonice){
				cbDeonice.addItem(m);
			}
			
			ArrayList<String> mesta = kk.vratiSvaMesta();
			for(String m : mesta){
				cbPolazakIzmena.addItem(m);
				cbDolazakIzmena.addItem(m);
			}
			
			ArrayList<String> stanice =  kk.vratiSveNaplatneStanice();
			for(String m : stanice){
				cbMestoIzmena.addItem(m);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		panel1.add(new JLabel("ID Deonice"));
		panel1.add(cbDeonice);
		
		panel1.add(new JLabel("Mesto polaska: "));
		panel1.add(cbPolazakIzmena);
		
		panel1.add(new JLabel("Mesto dolaska: "));
		panel1.add(cbDolazakIzmena);
		
		panel1.add(new JLabel("Naplatno mesto: "));
		panel1.add(cbMestoIzmena);
		
		panel1.add(btnPotvrdiIzmena);
		panel1.setBorder(new EmptyBorder(20, 20, 20, 20));
		tabbedPane.addTab("Izmena deonice", panel1);

		//BRISANJE DEONICE
		JPanel panel2 = new JPanel();
		cbDeoniceBrisanje = new JComboBox<String>();
		btnPotvrdiBrisanje = new JButton("Izbrisi deonicu");
		
		try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();
			
			ArrayList<String> deonice = kk.vratiSveDeonice();
			for(String m : deonice){
				cbDeoniceBrisanje.addItem(m);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		panel2.add(new JLabel("ID Deonice"));
		panel2.add(cbDeoniceBrisanje);
		
		panel2.add(btnPotvrdiBrisanje);
		tabbedPane.addTab("Brisanje deonice", panel2);
		this.add(tabbedPane, BorderLayout.CENTER);
		
		this.setSize(450, 400);
	}
	
	private void kreirajMenu(){
		menuBar = new JMenuBar();

        menu = new JMenu("Meni");
        
        JMenuItem miNaplatne = new JMenuItem("NaplatneStanice");
        miNaplatne.setMnemonic(KeyEvent.VK_N);
        
        miNaplatne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NaplatneStaniceView nsv = new NaplatneStaniceView(k);
				nsv.setVisible(true);
				
			}
		});
        
        menu.add(miNaplatne);

        JMenuItem miKorisnici = new JMenuItem("Korisnici");
        miKorisnici.setMnemonic(KeyEvent.VK_K);
        
        miKorisnici.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Korisnici ko = new Korisnici(k);
				ko.setVisible(true);
			}
		});

        menu.add(miKorisnici);
        
        JMenuItem miOdjava = new JMenuItem("Odjavi se");
        miOdjava.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
			}
		});
        menu.add(miOdjava);
        
        menuBar.add(menu);
        setJMenuBar(menuBar);
	}
}
