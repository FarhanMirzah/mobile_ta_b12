package com.example.mobile_ta_b12.models;

public class Mahasiswa {
    String nama_Mahasiswa;
    String nim_Mahasiswa;

    public Mahasiswa(String nama_Mahasiswa, String nim_Mahasiswa){
        this.nama_Mahasiswa = nama_Mahasiswa;
        this.nim_Mahasiswa = nim_Mahasiswa;
    }
    public  String getNama_Mahasiswa(){return nama_Mahasiswa;}
    public  void setNama_Mahasiswa(String namaMhsP){this.nama_Mahasiswa = namaMhsP;}

    public  String getNim_Mahasiswa(){return nim_Mahasiswa;}
    public  void setNim_Mahasiswa(String nim_mahasiswa){this.nim_Mahasiswa = nim_Mahasiswa;}


}
