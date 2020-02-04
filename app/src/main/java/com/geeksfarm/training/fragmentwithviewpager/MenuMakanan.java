package com.geeksfarm.training.fragmentwithviewpager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class MenuMakanan {
    private String namaMenu;
    private ArrayList<Makanan> data;

    public static class Makanan implements Parcelable {

        private String nama;
        private String harga;

        public String getNama() {
            return nama;
        }

        public String getHarga() {
            return harga;
        }

        public Makanan(String nm, String price){
            this.nama = nm;
            this.harga = price;


        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.nama);
            dest.writeString(this.harga);
        }

        protected Makanan(Parcel in) {
            this.nama = in.readString();
            this.harga = in.readString();
        }

        public static final Parcelable.Creator<Makanan> CREATOR = new Parcelable.Creator<Makanan>() {
            @Override
            public Makanan createFromParcel(Parcel source) {
                return new Makanan(source);
            }

            @Override
            public Makanan[] newArray(int size) {
                return new Makanan[size];
            }
        };
    }

    public MenuMakanan(String namaMenu, ArrayList<Makanan> data) {
        this.namaMenu = namaMenu;
        this.data = data;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public ArrayList<Makanan> getData() {
        return data;
    }
}

