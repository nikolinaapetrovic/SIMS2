package szn.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import szn.model.IzvestajModel;
import szn.model.IzvestajTableModel;
import szn.model.KonekcijskaKlasa;
import szn.model.Korisnik;

public class CentralaView  extends JFrame{

	private JMenu menu;
	private JMenuBar menuBar;
	private Korisnik k;
	
	private JComboBox<String> cbNaplatneStanice;
	private JComboBox<String> cbTipIzvesttaja;
	private JPanel panel;
	private JButton btnPrikazi;
	private JScrollPane jScrollPane1 = new JScrollPane();

	private JTable tableIzvestaj;
	private IzvestajTableModel izvestajModel;
	
	public CentralaView(Korisnik kor){
		try {
			this.k = kor;
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jbInit(){
		setTitle("Centrala");
		
		kreirajMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 String[] tipovi = {"Izvestaj o zaradi", "Izvestaj o prolaznosti", "Detaljan izvestaj"};
		 cbTipIzvesttaja = new JComboBox<String>(tipovi);
		 cbNaplatneStanice = new JComboBox<String>();
		 
		 try {
			KonekcijskaKlasa kk = new KonekcijskaKlasa();

			ArrayList<String> stanice =  kk.vratiSveNaplatneStaniceIme();
			for(String m : stanice){
				cbNaplatneStanice.addItem(m);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		panel = new JPanel(new GridLayout(10, 1));
		
		JPanel pnlMesto = new JPanel(new GridLayout(2, 1));
		pnlMesto.add(new JLabel("Naplatna stanica: "));
		pnlMesto.add(cbNaplatneStanice);
		
		panel.add(pnlMesto);
		
		JPanel pnlTip = new JPanel(new GridLayout(2, 1));
		pnlTip.add(new JLabel("Tip izvestaja: "));
		pnlTip.add(cbTipIzvesttaja);
		
		panel.add(pnlTip);
		
		btnPrikazi =  new JButton("Prikazi");
		btnPrikazi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				KonekcijskaKlasa kk;
				try {
					kk = new KonekcijskaKlasa();
					System.out.println((String)cbNaplatneStanice.getSelectedItem());
					String id = kk.vratiIdNaplatneStanice((String)cbNaplatneStanice.getSelectedItem());
					izvestajModel = new IzvestajTableModel(kk.vratiIzvestajCena(k, id));				
					tableIzvestaj.setModel(izvestajModel);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		panel.add(btnPrikazi);
		JPanel pnn = new JPanel(new GridLayout(1, 1));
		
		izvestajModel = new IzvestajTableModel(new ArrayList<IzvestajModel>());
		tableIzvestaj = new JTable(izvestajModel);
		tableIzvestaj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableIzvestaj.setBorder(new EmptyBorder(8,8,20,8));
		
		jScrollPane1.getViewport().add(tableIzvestaj, null);
		pnn.add(jScrollPane1);
		
		setSize(700, 500);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		this.add(pnn,BorderLayout.EAST);
		this.add(panel,BorderLayout.WEST);
	}
	
	private void kreirajMenu(){
		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("Meni");
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
