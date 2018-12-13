package com.reynaldiwijaya.belajarintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    //TODO membuat variable untuk menampung data yang kita inginkan
    String nama,asal,alamat,pekerjaan;
    int age;

    //TODO Membuat Getter Setter

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //TODO mengimplementasi parcarable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.asal);
        dest.writeString(this.alamat);
        dest.writeString(this.pekerjaan);
        dest.writeInt(this.age);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.nama = in.readString();
        this.asal = in.readString();
        this.alamat = in.readString();
        this.pekerjaan = in.readString();
        this.age = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
