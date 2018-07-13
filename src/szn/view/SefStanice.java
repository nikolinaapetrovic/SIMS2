package szn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
	public SefStanice(){
		try {
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
		panel.add(btnPrikazi);
		
		
	
		
		setSize(700, 500);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(panel,BorderLayout.CENTER);
	}
	
	private void kreirajMenu(){
		menuBar = new JMenuBar();

        menu = new JMenu("Meni");

        JMenuItem miIzvodjenja = new JMenuItem("Izmena cene naplate");
        miIzvodjenja.setMnemonic(KeyEvent.VK_N);
        miIzvodjenja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
        menu.add(miIzvodjenja);
        JMenuItem miKvarovi = new JMenuItem("Pregled kvarova");
        miKvarovi.setMnemonic(KeyEvent.VK_K);
        
        miKvarovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
        menu.add(miOdjava);
        menu.add(miKvarovi);
        menuBar.add(menu);
        setJMenuBar(menuBar);
	}
}
