package szn.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import szn.model.IzvestajTableModel;
import szn.model.KonekcijskaKlasa;
import szn.model.Korisnik;
import szn.model.KvarModel;
import szn.model.KvarTableModel;

public class KvarView  extends JFrame{
	Korisnik k;

	private JTextField txtPocetni;
	private JTextField txtKrajnji;
	private JButton btnPrikazi;
	private JPanel panel;
	
	private KvarTableModel kvarModel;
	private JTable tableKvarovi;
	private JScrollPane jScrollPane1 = new JScrollPane();
	
	public KvarView(Korisnik kor){
		try {
			this.k = kor;
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void jbInit(){
		setTitle("Pregled kvarova");
	       
        txtPocetni = new JTextField();
        txtKrajnji = new JTextField();
        panel = new JPanel(new GridLayout(10, 1));
		
        JPanel pnlDatum = new JPanel(new GridLayout(1, 2));
        pnlDatum.add(new JLabel("Pocetni datum: "));
        pnlDatum.add(txtPocetni);
        
        panel.add(pnlDatum);
		
        JPanel pnlDatum2 = new JPanel(new GridLayout(1, 2));
        pnlDatum2.add(new JLabel("Krajnji datum: "));
        pnlDatum2.add(txtKrajnji);
        panel.add(pnlDatum2);
        
        btnPrikazi =  new JButton("Prikazi");
        btnPrikazi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KonekcijskaKlasa kk;
				try {
					kk = new KonekcijskaKlasa();
					kvarModel = new KvarTableModel(kk.vratiKvarove(k, txtPocetni.getText(), txtKrajnji.getText()));
					tableKvarovi.setModel(kvarModel);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btnPrikazi);
		
		JPanel pnn = new JPanel(new GridLayout(1, 1));
		KonekcijskaKlasa kk;
		try {
			kk = new KonekcijskaKlasa();
			kvarModel = new KvarTableModel(kk.vratiKvarove(k));
			tableKvarovi = new JTable(kvarModel);
			tableKvarovi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableKvarovi.setBorder(new EmptyBorder(8,8,20,8));
			
			jScrollPane1.getViewport().add(tableKvarovi, null);
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
}
