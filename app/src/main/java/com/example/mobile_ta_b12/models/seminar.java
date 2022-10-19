package com.example.mobile_ta_b12.models;

public class seminar {
    String tipe;
    String tanggal;
    String waktu;
    String tempat;

    public seminar(){}

    public seminar(String tipe, String tanggal, String waktu, String tempat) {
        this.tipe = tipe;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tempat = tempat;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
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

