/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author Kaho
 */
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class BiodataTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Nomor HP", "Alamat","Jenis Kelamin"};
    private List<Biodata> data;

    public BiodataTableModel(List<Biodata> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return data.size();
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Object getValueAt(int row, int col) {
        Biodata rowItem = data.get(row);
        String value = "";

        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getNomor_hp();
                break;
            case 2:
                value = rowItem.getAlamat();
                break;
            case 3:
                value = rowItem.getJenis_Kelamin();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Biodata value) {
        data.add(value);
        System.out.println(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void update(Biodata update, int selected) {
        data.set(selected, update);
        fireTableCellUpdated(selected, 0);
        fireTableCellUpdated(selected, 1);
    }

    public void remove(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < data.size()) {
            data.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex); // Memberi tahu JTable bahwa baris telah dihapus
        } else {
            throw new IndexOutOfBoundsException("Index tidak valid");
        }
    }
}

