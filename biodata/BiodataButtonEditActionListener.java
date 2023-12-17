/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author Kaho
 */
import dao.BiodataDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BiodataButtonEditActionListener implements ActionListener  {
    private final List<Biodata> biodataList;
    private BiodataFrame biodataFrame;
    private BiodataDao biodataDao;
    public BiodataButtonEditActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao, List<Biodata> biodataList) {
        this.biodataDao = biodataDao;
        this.biodataFrame = biodataFrame;
        this.biodataList = biodataList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = this.biodataFrame.getTable();
        int selected = table.getSelectedRow();
        String nama = (String) table.getValueAt(selected,0);
        String nomor = (String) table.getValueAt(selected, 1);
        String alamat = (String) table.getValueAt(selected, 2);
        if (this.biodataFrame.isEmptyField()) {
            this.biodataFrame.setTextnama(nama);
            this.biodataFrame.setTextalamat(alamat);
            this.biodataFrame.setTextnomor(nomor);
        } else {
            Biodata updateBiodata = new Biodata();
            Biodata biodata = biodataList.get(selected);
            updateBiodata.setId(biodata.getId());
            updateBiodata.setNama(this.biodataFrame.getName());
            updateBiodata.setAlamat(this.biodataFrame.getAlamat());
            updateBiodata.setNomor_hp(this.biodataFrame.getNomor_Hp());
            updateBiodata.setJenis_Kelamin(this.biodataFrame.getJenisKelamin());
            this.biodataDao.update(updateBiodata);
            this.biodataFrame.updateBiodata(updateBiodata, selected);
            this.biodataFrame.setTextalamat("");
            this.biodataFrame.setTextnama("");
            this.biodataFrame.setTextnomor("");
        }
    }
}