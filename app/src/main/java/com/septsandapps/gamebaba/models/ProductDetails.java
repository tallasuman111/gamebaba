package com.septsandapps.gamebaba.models;

/**
 * Created by talla on 30-10-2016.
 */

public class ProductDetails {
    String id,gameConsole,imageUrl,gameTitle, price;

    /*public ProductDetails(String id, String gameConsole, String imageUrl, String gameTitle, String price){
        this.id = id;
        this.gameConsole = gameConsole;
        this.imageUrl = imageUrl;
        this.gameTitle = gameTitle;
        this.price = price;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameConsole() {
        return gameConsole;
    }

    public void setGameConsole(String gameConsole) {
        this.gameConsole = gameConsole;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
