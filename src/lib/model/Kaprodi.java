/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib.model;

import lib.Status;

/**
 *
 * @author ASUS
 */
public class Kaprodi {
    
    /**
     * 
     * @param mahasiswa
     * @param jadwal 
     */
    public void aturJadwal(Mahasiswa mahasiswa,String jadwal){
        TopikTA topikTA = mahasiswa.getTopikTA();
        topikTA.jadwalSidang = jadwal;
    }
    
    /**
     * 
     * @param mahasiswa
     * @param topik
     * @param dosenPembibing 
     */
    public void pengajuanTopikMahasiswa(Mahasiswa mahasiswa, String topik,DosenPembibing dosenPembibing){
        mahasiswa.setTopikTA(topik);
        mahasiswa.setDosenPembibing(dosenPembibing);
        dosenPembibing.tambahMahasiswaBimbingan(mahasiswa);
        mahasiswa.getTopikTA().status = Status.MenungguDiriview;
    }
}
