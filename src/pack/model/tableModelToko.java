/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yobelchris
 */
public class tableModelToko extends AbstractTableModel{
    
    List<m_toko>lt;
    public tableModelToko(List<m_toko> lt){
        this.lt = lt;
    }

    @Override
    public int getRowCount() {
        return lt.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    public String getColumnNama(int column){
        switch(column){
            case 0:
                return "Kode_Barang";
            case 1:
                return "Nama_Barang";
            case 2:
                return "Kategori";
            case 3:
                return "Jenis";
            case 4:
                return "Harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lt.get(rowIndex).getkode();
            case 1:
                return lt.get(rowIndex).getnama();
            case 2:
                return lt.get(rowIndex).getkategori();
            case 3:
                return lt.get(rowIndex).getjenis();
            case 4:
                return lt.get(rowIndex).getharga();
            default:
                return null;
        }
    }
    
}
