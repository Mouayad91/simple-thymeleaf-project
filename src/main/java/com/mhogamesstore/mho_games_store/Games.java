package com.mhogamesstore.mho_games_store;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class Games {
    private String category;
    private String title;
    private Double price;
    private Double discount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String id;

public Games(){

    this.id=UUID.randomUUID().toString();
}


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
}
