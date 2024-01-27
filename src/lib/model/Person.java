package lib.model;

/**
 * *********************************************************************
 * Module: Person.java Author: ASUS Purpose: Defines the Class Person
 * *********************************************************************
 */
public class Person {

    private String nama;
    private String alamat;
    private String noTelepon;

    /**
     *
     * @param nama
     * @param alamat
     */
    public Person(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    /**
     * get alamat
     *
     * @return
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     *
     * @param newAlamat
     */
    public void setAlamat(String newAlamat) {
        alamat = newAlamat;
    }

    /**
     *
     * get nama
     *
     * @return
     */
    public String getNama() {
        return nama;
    }

    /**
     *
     * @param newNama
     */
    public void setNama(String newNama) {
        nama = newNama;
    }

    /**
     *
     * @return
     */
    public String getNoTelepon() {
        return noTelepon;
    }

    /**
     *
     * @param noTelepon
     */
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

}
