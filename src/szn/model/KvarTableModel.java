package szn.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class KvarTableModel extends AbstractTableModel{

	private String[] columnNames = {"ID kvara", "Vreme", "Opis kvara", "ID uredjaja"};
	private ArrayList<KvarModel> kvarovi;
	
	public KvarTableModel(ArrayList<KvarModel> i){
		this.kvarovi = i;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.kvarovi.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	@Override
	public Object getValueAt(int arg0, int arg1) {
		KvarModel k = kvarovi.get(arg0);
		
		switch(arg1){
		case 0: return k.getIdKvara();
		case 1: return k.getVreme();
		case 2: return k.getVrsta();
		case 3: return k.getIdUredjaja();
		}
		
		return null;
	}
}
