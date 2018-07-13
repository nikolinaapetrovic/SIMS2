package szn.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class IzvestajTableModel extends AbstractTableModel {
	
	private String[] columnNames = {"Naziv stanice", "Id naplatnog mesta", "Ukupno"};
	private ArrayList<IzvestajModel> izvestaji;
	
	public IzvestajTableModel(ArrayList<IzvestajModel> i){
		this.izvestaji = i;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.izvestaji.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	@Override
	public Object getValueAt(int arg0, int arg1) {
		IzvestajModel k = izvestaji.get(arg0);
		
		switch(arg1){
		case 0: return k.getNaziv();
		case 1: return k.getId();
		case 2: return k.getCena();
		}
		
		return null;
	}
}
