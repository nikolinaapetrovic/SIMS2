package szn.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import szn.model.IzvestajTableModel;
import szn.model.Korisnik;

public class DodavanjeNaplate extends JFrame {
	
	Korisnik k;
	private JComboBox<String> cbKategorija;
	private JComboBox<String> cbMesto;
	private JComboBox<String> cbValuta;
	private JPanel panel;
	
	
	private JLabel lblIspis;
	
	public DodavanjeNaplate(Korisnik kor){
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
		
		String[] mesto = {"Indjija", "Novi Sad", "Beograd"};
		cbMesto = new JComboBox<String>(mesto);
		
		String[] valuta = {"Evro", "Dinar"};
		cbValuta = new JComboBox<String>(valuta);
		
		panel = new JPanel(new GridLayout(10,2,10,10));
		
		panel.add(new JLabel("Kategorija vozila: "));
		panel.add(cbKategorija);
		
		panel.add(new JLabel("Mesto polaska: "));
		panel.add(cbMesto);
		
		panel.add(new JLabel("Valuta:"));
		panel.add(cbValuta);
		
		panel.add(new JLabel("Ukupna cena za datu deonicu je: "));
		
		JButton btnDodaj = new JButton("Izvrsi naplatu");
		panel.add(btnDodaj);
		
		JButton btnPodigniRampu = new JButton("Podigni rampu");
		JButton btnSpustiRampu = new JButton("Spusti rampu");
		
		panel.add(btnPodigniRampu);
		panel.add(btnSpustiRampu);
		
		this.setSize(450, 400);

		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(panel,BorderLayout.CENTER);
	}

}
