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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Objects;

public class BiodataFrame extends JFrame {
    private BiodataDao biodataDao;
    private JComboBox comboJenis;

    private BiodataTableModel tableModel;
    private JTable table;
    private List<Biodata> biodataList;
    private JLabel labelnama, labelnomor, labeljeniskelamin, labelalamat;
    private JTextField textnama, textnomor;
    private JTextArea textalamat;
    private JButton buttonsimpan,  buttonhapus, buttonedit;

    public BiodataFrame() {
        JFrame jframe = this;
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(jframe, "Do you want to Exit ?", "Exit Confirmation : ", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if (result == JOptionPane.NO_OPTION) jframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        this.biodataList = BiodataDao.findAll();
        for (Biodata kaho: this.biodataList) {
            System.out.println(kaho.getNama() +" "+kaho.getAlamat()+" "+kaho.getNomor_hp()+" "+kaho.getJenis_Kelamin());
        }
        this.biodataDao = new BiodataDao();

        comboJenis = new JComboBox();
        comboJenis.setBounds(15, 180,300, 30);
        comboJenis.addItem("Laki-laki");
        comboJenis.addItem("Perempuan");

        labelnama = new JLabel("Nama :");labelnama.setBounds(15,40,350,15);
        labelnomor = new JLabel("Nomor :");labelnomor.setBounds(15,100,350,15);
        labeljeniskelamin = new JLabel("Jenis Kelamin :");labeljeniskelamin.setBounds(15,160,350,15);
        labelalamat = new JLabel("Alamat :");labelalamat.setBounds(15,230,350,15);

        textnama = new JTextField();textnama.setBounds(15,60,300,30);
        textnomor = new JTextField();textnomor.setBounds(15,120,300,30);
        textalamat = new JTextArea();textalamat.setBounds(15,250,300,50);

        buttonsimpan = new JButton("Simpan");buttonsimpan.setBounds(15,310,100,40);
        buttonedit = new JButton("Edit");buttonedit.setBounds(115,310,80,40);
        buttonhapus = new JButton("Hapus");buttonhapus.setBounds(195,310,80,40);


        this.table = new JTable();
        JScrollPane scrollableTale = new JScrollPane(table);
        scrollableTale.setBounds(15,360,300,200);
        tableModel = new BiodataTableModel(biodataList);
        table.setModel(tableModel);

        BiodataButtonSimpanActionListener actionListenerSimpan = new BiodataButtonSimpanActionListener(this, biodataDao);
        BiodataButtonHapusActionListener actionListenerHapus = new BiodataButtonHapusActionListener(this, biodataDao);
        BiodataButtonEditActionListener actionListenerEdit = new BiodataButtonEditActionListener(this, biodataDao,  this.biodataList);

        buttonsimpan.addActionListener(actionListenerSimpan);
        buttonhapus.addActionListener(actionListenerHapus);
        buttonedit.addActionListener(actionListenerEdit);

        this.add(labelnama);
        this.add(labelnomor);
        this.add(labeljeniskelamin);
        this.add(labelalamat);
        this.add(textnama);
        this.add(comboJenis);
        this.add(textnomor);
        this.add(textalamat);
        this.add(buttonsimpan);
        this.add(buttonedit);
        this.add(buttonhapus);
        this.add(scrollableTale);

        this.setSize(330,650);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { new BiodataFrame().setVisible(true); }
        });
    }

    public JTable getTable() {
        return table;
    }

    public String getNama() { return textnama.getText(); }
    public String getNomor_Hp() { return textnomor.getText(); }
    public String getJenisKelamin() { return comboJenis.getSelectedItem().toString(); }
    public String getAlamat() { return textalamat.getText(); }

    public void setTextalamat(String textalamat) { this.textalamat.setText(textalamat); }
    public void setTextnama(String textnama) { this.textnama.setText(textnama); }
    public void setTextnomor(String textnomor) { this.textnomor.setText(textnomor); }

    public void removeData(int selected) {
        this.tableModel.remove(selected);
    }

    public void addBiodata(Biodata biodata) {
        tableModel.add(biodata);
        textnama.setText("");
        textalamat.setText("");
        textnomor.setText("");
    }

    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public boolean isEmptyField() {
        return (Objects.equals(this.textalamat.getText(), "")) && (Objects.equals(this.textnama.getText(), "")) && Objects.equals(this.textnomor.getText(), "");
    }

    public void updateBiodata(Biodata update, int selected) {
        this.tableModel.update(update, selected);
    }


}