package com.example.vectorov.eduproject_22092016;

import android.location.Location;

/**
 * Created by vectorov on 24.09.2016.
 */
import com.google.gson.annotations.SerializedName;

public class StoreTest {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("address")
    private String address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("location")
    private Location location;

    public StoreTest(){};

    public StoreTest(int id, String name, String address, String phone, Location location) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.location = location;
    }

    public StoreTest(String name, String address, String phone, Location location) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public StoreTest setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StoreTest setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public StoreTest setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public StoreTest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public StoreTest setLocation(Location location) {
        this.location = location;
        return this;
    }
}
