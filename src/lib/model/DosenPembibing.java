package lib.model;

import java.util.ArrayList;
import java.util.List;

/**
 * *********************************************************************
 * Module: DosenPembibing.java Author: ASUS Purpose: Defines the Class
 * DosenPembibing
 **********************************************************************
 */
public class DosenPembibing extends Person {

    private String nidn;

    public List<Mahasiswa> listMahasiswaBimbingan;

    public DosenPembibing(String nidn, String nama, String alamat) {
        super(nama, alamat);
        this.nidn = nidn;
        listMahasiswaBimbingan = new ArrayList<>();
    }

    /**
     * @param mahasiswa
     */
    public void tambahMahasiswaBimbingan(Mahasiswa mahasiswa) {
        if (listMahasiswaBimbingan.size() <= 10) {
            listMahasiswaBimbingan.add(mahasiswa);
        } else {
            System.out.println("List Bimbingan Dosen " + this.getNama() + " penuh");
        }
    }

    /**
     * get nidn
     *
     * @return
     */
    public String getNidn() {
        return nidn;
    }

    /**
     * @param newNidn
     */
    public void setNidn(String newNidn) {
        nidn = newNidn;
    }

}
