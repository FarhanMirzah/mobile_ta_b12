package com.example.mobile_ta_b12.models;

public class Persetujuan {
    String namaMhsP;
    String nimMhsP;

    public Persetujuan(String namaMhsP, String nimMhsP){
        this.namaMhsP = namaMhsP;
        this.nimMhsP = nimMhsP;
    }
    public  String getNamaMhsP(){return namaMhsP;}
    public  void setNamaMhsP(String namaMhsP){this.namaMhsP = namaMhsP;}

    public  String getNimMhsP(){return nimMhsP;}
    public  void setNimMhsP(String nimMhsP){this.nimMhsP = nimMhsP;}


}
