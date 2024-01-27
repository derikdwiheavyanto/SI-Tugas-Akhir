/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lib;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lib.model.DosenPembibing;
import lib.model.Kaprodi;
import lib.model.Mahasiswa;

/**
 *
 * @author ASUS
 */
public class Main {
    
    static List<Mahasiswa> listMahasiswa = new ArrayList<>();
    static List<DosenPembibing> listDosenPembibing = new ArrayList<>();
    
    static void adminController() {
        
        String pilihMenuAdmin;
        
        do {
            pilihMenuAdmin = JOptionPane.showInputDialog("""
                           Pilih menu:
                           1. tambah mahasiswa
                           2. tambah dosen pembibing
                           3. exit """);
            
            switch (pilihMenuAdmin) {
                case "1" -> {
                    String nim, nama, prodi, alamat;
                    nim = JOptionPane.showInputDialog("Masukan nim mahasiswa");
                    nama = JOptionPane.showInputDialog("Masukan nama mahasiswa");
                    prodi = JOptionPane.showInputDialog("Masukan prodi mahasiswa");
                    alamat = JOptionPane.showInputDialog("Masukan alamat mahasiswa");
                    
                    listMahasiswa.add(new Mahasiswa(nim, nama, alamat, prodi));
                    
                }
                case "2" -> {
                    
                    String nidn, nama, alamat;
                    nidn = JOptionPane.showInputDialog("Masukan nidn dosen");
                    nama = JOptionPane.showInputDialog("Masukan nama dosen");
                    alamat = JOptionPane.showInputDialog("Masukan alamat dosen");
                    
                    listDosenPembibing.add(new DosenPembibing(nidn, nama, alamat));
                    
                }
                case "3" -> {
                }
//                case "4" -> {
//                    String daftarMahasiswa = "";
//                    int nomor = 1;
//                    for (Mahasiswa mhs : listMahasiswa) {
//                        daftarMahasiswa += nomor + ". " + mhs.getNama() + "\n";
////                        (" + mhs.getTopikTA().status + ")"
//                        nomor++;
//                    }
//                    JOptionPane.showMessageDialog(null, daftarMahasiswa);
//                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Pilihan Tidak tersedia, Silahkan pilih kembali!!");
                }
            }
        } while (!pilihMenuAdmin.equals("3"));
    }
    
    static void kaprodiController() {
        String daftarMahasiswa, pilihMahasiswa;
        Kaprodi kaprodi = new Kaprodi();
        
        try {
            do {
                int nomor = 1;
                daftarMahasiswa = "";
                
                for (Mahasiswa mhs : listMahasiswa) {
                    daftarMahasiswa += nomor + ". " + mhs.getNama() + " (" + mhs.getTopikTA().status + ")" + "\n";
                    nomor++;
                }
                
                pilihMahasiswa = JOptionPane.showInputDialog(daftarMahasiswa + "0.Exit\nPilih Mahasiswa");
                if (Integer.parseInt(pilihMahasiswa) != 0) {
                    Mahasiswa selectedMahasiswa = listMahasiswa.get(Integer.parseInt(pilihMahasiswa) - 1);
                    
                    switch (selectedMahasiswa.getTopikTA().status) {
                        case BelumMengajukan -> {
                            String topik = JOptionPane.showInputDialog("Masukan topik mahasiswa");
                            
                            int nomorDospem = 1;
                            String daftarDospem = "";
                            for (DosenPembibing dospem : listDosenPembibing) {
                                daftarDospem += nomorDospem + ". " + dospem.getNama() + "\n";
                                nomorDospem++;
                            }
                            
                            String dospem = JOptionPane.showInputDialog("Pilih Dosen Untuk Mahasiswa " + selectedMahasiswa.getNama() + "\n" + daftarDospem);
                            DosenPembibing selectedDospem = listDosenPembibing.get(Integer.parseInt(dospem) - 1);
                            
                            kaprodi.pengajuanTopikMahasiswa(selectedMahasiswa, topik, selectedDospem);
                        }
                        
                        case MenungguDiriview -> {
                            String detailMahasiswa = "Nim\t\t: " + selectedMahasiswa.getNim();
                            detailMahasiswa += "\nNama\t\t: " + selectedMahasiswa.getNama();
                            detailMahasiswa += "\nAlamat\t\t: " + selectedMahasiswa.getAlamat();
                            detailMahasiswa += "\nProdi\t\t: " + selectedMahasiswa.getProdi();
                            detailMahasiswa += "\nTopikTA\t\t: " + selectedMahasiswa.getTopikTA().topik;
                            detailMahasiswa += "\nDosen Pembibing\t: " + selectedMahasiswa.getDosenPembibing().getNama();
                            detailMahasiswa += "\nStatus\t: " + selectedMahasiswa.getTopikTA().status;
                            
                            JOptionPane.showMessageDialog(null, detailMahasiswa, "Detail Mahasiswa " + selectedMahasiswa.getNama(), JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        
                        case Ditolak -> {
                            String topik = JOptionPane.showInputDialog(null, "Masukan topik mahasiswa: ", "Revisi topik mahasiswa", JOptionPane.QUESTION_MESSAGE);
                            selectedMahasiswa.setTopikTA(topik);
                            selectedMahasiswa.getTopikTA().status = Status.MenungguDiriview;
                            
                        }
                        
                        case Diterima -> {
                            String jadwal;
                            
                            if (selectedMahasiswa.getTopikTA().jadwalSidang != null) {
                                String detailMahasiswa = "Nim\t\t: " + selectedMahasiswa.getNim();
                                detailMahasiswa += "\nNama\t\t: " + selectedMahasiswa.getNama();
                                detailMahasiswa += "\nAlamat\t\t: " + selectedMahasiswa.getAlamat();
                                detailMahasiswa += "\nProdi\t\t: " + selectedMahasiswa.getProdi();
                                detailMahasiswa += "\nTopikTA\t\t: " + selectedMahasiswa.getTopikTA().topik;
                                detailMahasiswa += "\nDosen Pembibing\t: " + selectedMahasiswa.getDosenPembibing().getNama();
                                detailMahasiswa += "\nJadwal Sidang\t: " + selectedMahasiswa.getTopikTA().jadwalSidang;
                                jadwal = JOptionPane.showInputDialog(null, detailMahasiswa + "\nUbah jadwal seminar mahasiswa: ", "Penjadwalan seminar", JOptionPane.QUESTION_MESSAGE);
                                kaprodi.aturJadwal(selectedMahasiswa, jadwal);
                                
                            } else {
                                jadwal = JOptionPane.showInputDialog(null, "Atur jadwal seminar mahasiswa: ", "Penjadwalan seminar", JOptionPane.QUESTION_MESSAGE);
                                kaprodi.aturJadwal(selectedMahasiswa, jadwal);
                                
                            }
                        }
                        
                        default ->
                            throw new AssertionError();
                    }
                }
                
            } while (!pilihMahasiswa.equals("0"));
        } catch (Exception e) {
            System.out.println("Erorr: " + e.toString());
        }
    }
    
    static void dospemController() {
        int nomorDospem = 1;
        String daftarDospem = "", pilihMahasiswa, daftarMahasiswa;
        
        for (DosenPembibing dospem : listDosenPembibing) {
            daftarDospem += nomorDospem + ". " + dospem.getNama() + "\n";
            nomorDospem++;
        }
        
        String pilihDospem = JOptionPane.showInputDialog("Pilih masuk sebagai dosen \n" + daftarDospem);
        do {
            int nomor = 1;
            daftarMahasiswa = "";
            DosenPembibing selectedDospem = listDosenPembibing.get(Integer.parseInt(pilihDospem) - 1);
            for (Mahasiswa mhsBimbingan : selectedDospem.listMahasiswaBimbingan) {
                daftarMahasiswa += nomor + ". " + mhsBimbingan.getNama() + " (" + mhsBimbingan.getTopikTA().status + ")" + "\n";
                nomor++;
            }
            
            pilihMahasiswa = JOptionPane.showInputDialog(null, "Pilih mahasiswa yang ingin diriview\n" + daftarMahasiswa + "0.Exit\nPilih Mahasiswa", "Masuk Sebagai dospem " + selectedDospem.getNama(), JOptionPane.QUESTION_MESSAGE);
            
            if (!pilihMahasiswa.equals("0") && !(Integer.parseInt(pilihMahasiswa) > selectedDospem.listMahasiswaBimbingan.size())) {
                Mahasiswa selectedMahasiswa = selectedDospem.listMahasiswaBimbingan.get(Integer.parseInt(pilihMahasiswa) - 1);
                String detailMahasiswa = "Nim: " + selectedMahasiswa.getNim();
                detailMahasiswa += "\nNama: " + selectedMahasiswa.getNama();
                detailMahasiswa += "\nAlamat: " + selectedMahasiswa.getAlamat();
                detailMahasiswa += "\nProdi: " + selectedMahasiswa.getProdi();
                detailMahasiswa += "\nTopikTA: " + selectedMahasiswa.getTopikTA().topik;
                
                if (selectedMahasiswa.getTopikTA().status != Status.Diterima) {
                    String pilihStatus = JOptionPane.showInputDialog(null, detailMahasiswa + "\n pilih status 1. Setujui 2.Tolak", "Riview topik mahasiswa", JOptionPane.QUESTION_MESSAGE);
                    switch (pilihStatus) {
                        case "1" -> {
                            selectedMahasiswa.getTopikTA().status = Status.Diterima;
                        }
                        case "2" -> {
                            selectedMahasiswa.getTopikTA().status = Status.Ditolak;
                        }
                        default ->
                            throw new AssertionError();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, detailMahasiswa, "Detail topik mahasiswa", JOptionPane.QUESTION_MESSAGE);
                    
                }
            }
            
        } while (!pilihMahasiswa.equals("0"));
    }
    
    public static void main(String[] args) {
        String pilihMasukSebagai;
        
        do {
            pilihMasukSebagai = JOptionPane.showInputDialog("""
                                Sistem Informasi Tugas Akhir
                                Masuk Sebagai:
                                1. Admin
                                2. Kaprodi
                                3. Dosen Pembibing
                                4. exit """);
            
            switch (pilihMasukSebagai) {
                case "1" -> {
                    adminController();
                }
                case "2" -> {
                    kaprodiController();
                }
                case "3" -> {
                    dospemController();
                }
                case "4" -> {
                    System.out.println("Program Exit");
                }
                default -> {
                    System.out.println("Pilihan Tidak tersedia, Silahkan pilih kembali!!");
                }
            }
            
        } while (!pilihMasukSebagai.equals("4"));
        
    }
    
}
