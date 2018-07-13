package szn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import szn.model.IzvestajTableModel;
import szn.model.KonekcijskaKlasa;
import szn.model.Korisnik;
import szn.view.Login;

@SuppressWarnings("serial")
public class SefStanice extends JFrame{

	private JMenu menu;
	private JMenuBar menuBar;
	private JTextField txtPocetni;
	private JTextField txtKrajnji;
	private JComboBox<String> cbTipIzvesttaja;
	private JPanel panel;
	private JButton btnPrikazi;
	private JPanel pnlPrikaz;
	private JPanel contentPane;
	private BorderLayout borderLayout1 = new BorderLayout();
	private JScrollPane jScrollPane1 = new JScrollPane();

	private JTable tableIzvestaj;
	private IzvestajTableModel izvestajModel;
	Korisnik k;
	public SefStanice(Korisnik kor){
		try {
			this.k = kor;
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jbInit(){
		
		setTitle("Pregled izvestaja");
		
		kreirajMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        txtPocetni = new JTextField();
        txtKrajnji = new JTextField();
        
        String[] tipovi = {"Izvestaj o zaradi", "Izvestaj o prolaznosti", "Detaljan izvestaj"};
        cbTipIzvesttaja = new JComboBox<String>(tipovi);
        
        panel = new JPanel(new GridLayout(10, 1));
		
        JPanel pnlDatum = new JPanel(new GridLayout(2, 1));
        pnlDatum.add(new JLabel("Pocetni datum: "));
        pnlDatum.add(txtPocetni);
        
        panel.add(pnlDatum);
		
        JPanel pnlDatum2 = new JPanel(new GridLayout(2, 1));
        pnlDatum2.add(new JLabel("Krajnji datum: "));
        pnlDatum2.add(txtKrajnji);
        panel.add(pnlDatum2);
		
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
					izvestajModel = new IzvestajTableModel(kk.vratiIzvestajCena(k, txtPocetni.getText(), txtKrajnji.getText()));				
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
		KonekcijskaKlasa kk;
		try {
			kk = new KonekcijskaKlasa();
			izvestajModel = new IzvestajTableModel(kk.vratiIzvestajCena(k));
			tableIzvestaj = new JTable(izvestajModel);
			tableIzvestaj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableIzvestaj.setBorder(new EmptyBorder(8,8,20,8));
			
			jScrollPane1.getViewport().add(tableIzvestaj, null);
			pnn.add(jScrollPane1);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		setSize(700, 500);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		this.add(pnn,BorderLayout.EAST);
		this.add(panel,BorderLayout.WEST);
	}
	
	private void kreirajMenu(){
		menuBar = new JMenuBar();

        menu = new JMenu("Meni");

        JMenuItem miIzvodjenja = new JMenuItem("Izmena cene naplate");
        miIzvodjenja.setMnemonic(KeyEvent.VK_N);
        miIzvodjenja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IzmenaCene ic = new IzmenaCene(k);
				ic.setVisible(true);
			}
		});
		
        menu.add(miIzvodjenja);
        JMenuItem miKvarovi = new JMenuItem("Pregled kvarova");
        miKvarovi.setMnemonic(KeyEvent.VK_K);
        
        miKvarovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KvarView kv = new KvarView(k);
				kv.setVisible(true);
				
			}
		});
        
        JMenuItem miOdjava = new JMenuItem("Odjavi se");
        miOdjava.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
			}
		});
        menu.add(miKvarovi);
        menu.add(miOdjava);
        menuBar.add(menu);
        setJMenuBar(menuBar);
	}
}
