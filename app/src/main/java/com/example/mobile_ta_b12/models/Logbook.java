package com.example.mobile_ta_b12.models;

public class  Logbook {
    String hariTanggal;
    String kegiatan;
    int status;

    public Logbook(String hariTanggal, String kegiatan, int status) {
        this.hariTanggal = hariTanggal;
        this.kegiatan = kegiatan;
        this.status = status;
    }

    public String getHariTanggal() {
        return hariTanggal;
    }

    public void setHariTanggal(String hariTanggal) {
        this.hariTanggal = hariTanggal;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
