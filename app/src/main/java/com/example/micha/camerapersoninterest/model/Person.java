package com.example.micha.camerapersoninterest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by micha on 1/11/2018.
 */

public class Person implements Parcelable {
    private String name;
    private String age;
    private String gender;
    private String hobby;
    private String job;

    public Person(String name, String age, String gender, String hobby, String job) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
        this.job = job;
    }

    protected Person(Parcel in) {
        name = in.readString();
        age = in.readString();
        gender = in.readString();
        hobby = in.readString();
        job = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby='" + hobby + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(age);
        parcel.writeString(gender);
        parcel.writeString(hobby);
        parcel.writeString(job);
    }
}
