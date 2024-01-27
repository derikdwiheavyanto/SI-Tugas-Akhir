package lib.model;

public class Mahasiswa extends Person {

    private String nim;
    private TopikTA topikTA;
    private DosenPembibing dosenPembibing;
    private String prodi;

    /**
     * @param nim
     * @param nama
     * @param alamat
     * @param prodi
     */
    public Mahasiswa(String nim, String nama, String alamat, String prodi) {
        super(nama, alamat);
        this.nim = nim;
        this.prodi = prodi;
        this.topikTA = new TopikTA(null);

    }

    /**
     *
     * @return
     */
    public String getNim() {
        return nim;
    }

    /**
     * 
     * @param newNim
     */
    public void setNim(String newNim) {
        nim = newNim;
    }

    /**
     * 
     * @param newTopik
     */
    public void setTopikTA(String newTopik) {
        topikTA.topik = newTopik;
    }

    /**
     *
     * @return
     */
    public TopikTA getTopikTA() {
        return topikTA;
    }

    /**
     * @param dosenPembibing
     */
    public void setDosenPembibing(DosenPembibing dosenPembibing) {
        this.dosenPembibing = dosenPembibing;
    }

    /**
     *
     * @return
     */
    public DosenPembibing getDosenPembibing() {
        return dosenPembibing;
    }

    /**
     *
     * @return
     */
    public String getProdi() {
        return prodi;
    }

    /**
     *
     * @param prodi
     */
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
}
