package com.example.sabaq_recycler;

public class Student {

    private String name;
    private String sabaq;
    private String sabqi;
    private String manzil;

    public Student(String name, String sabaq, String sabqi, String manzil) {
        this.name = name;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
    }

    public String getName() {
        return name;
    }

    public String getSabaq() {
        return sabaq;
    }

    public String getSabqi() {
        return sabqi;
    }

    public String getManzil() {
        return manzil;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSabaq(String sabaq) {
        this.sabaq = sabaq;
    }

    public void setSabqi(String sabqi) {
        this.sabqi = sabqi;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }
}
