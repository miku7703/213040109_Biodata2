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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class BiodataButtonSimpanActionListener implements ActionListener {
    private BiodataFrame biodataFrame;
    private BiodataDao biodataDao;

    public BiodataButtonSimpanActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.biodataFrame.getNama();
        String nomorhp = this.biodataFrame.getNomor_Hp();
        String jeniskelamin = this.biodataFrame.getJenisKelamin();
        String alamat = this.biodataFrame.getAlamat();
        if (nama.isEmpty()) {
            this.biodataFrame.showAlert("Text field tidak boleh Kosong");
        } else {
            Biodata biodata = new Biodata();
            biodata.setId(UUID.randomUUID().toString().substring(0, 8));
            biodata.setNama(nama);
            biodata.setNomor_hp(nomorhp);
            biodata.setJenis_Kelamin(jeniskelamin);
            biodata.setAlamat(alamat);

            this.biodataFrame.addBiodata(biodata);
            this.biodataDao.insert(biodata);
        }
    }
}
