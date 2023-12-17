/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author Kaho
 */
public class Biodata {
    
    private String Id;
    private String nama;
    private String nomorhp;
    private String jeniskelamin;
    private String alamat;
   
    public void setId( String id ) {
        this.Id = id;
    }
    public String getId() {
       return Id;
    }
    
    public void setNama(String nama) {
        this.nama = nama ;   
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNomor_hp(String nomorhp) {
        this.nomorhp = nomorhp;   
    }
    
    public String getNomor_hp() {
        return nomorhp;
    }
    public void setJenis_Kelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin ;   
    }
    
    public String getJenis_Kelamin() {
        return jeniskelamin;
    }
 
    public void setAlamat(String Alamat) {
        this.alamat = alamat ;   
    }
    
    public String getAlamat() {
        return alamat;
    }
  
    

}
