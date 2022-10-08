package com.example.mobile_ta_b12.models;

public class ListJadwal {

    String gambar;
    int tipeJadwal;
    String tanggal;
    String waktu;
    String tempat;

    public ListJadwal(){ }

    public ListJadwal(String gambar, int tipeJadwal, String tanggal, String waktu, String tempat) {
        this.gambar = gambar;
        this.tipeJadwal = tipeJadwal;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tempat = tempat;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getTipeJadwal() {
        return tipeJadwal;
    }

    public void setTipeJadwal(int tipeJadwal) {
        this.tipeJadwal = tipeJadwal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
}
