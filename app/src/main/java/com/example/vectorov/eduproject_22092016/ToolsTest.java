package com.example.vectorov.eduproject_22092016;

/**
 * Created by vectorov on 24.09.2016.
 */

import com.google.gson.annotations.SerializedName;

public class ToolsTest {
    public ToolsTest() {}

    @SerializedName("id")
    private int id;
    @SerializedName("storeId")
    private int storeId;
    @SerializedName("brand")
    private String brand;
    @SerializedName("model")
    private String model;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("type")
    private String type;
    @SerializedName("price")
    private double price;
    @SerializedName("quantity")
    private int quantity;

    public ToolsTest(int id,int storeId, String brand, String model, String imageUrl, String type, double price, int quantity) {
        this.id = id;
        this.storeId = storeId;
        this.brand = brand;
        this.model = model;
        this.imageUrl = imageUrl;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public ToolsTest setId(int id) {
        this.id = id;
        return this;
    }

    public int getStoreId() { return storeId; }

    public ToolsTest setStoreId(int storeId) {
        this.storeId = storeId;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ToolsTest setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public ToolsTest setModel(String model) {
        this.model = model;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ToolsTest setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getType() {
        return type;
    }

    public ToolsTest setType(String type) {
        this.type = type;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ToolsTest setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ToolsTest setQuantity(int quantity) {
        this.quantity = quantity;

        return this;
    }
}
