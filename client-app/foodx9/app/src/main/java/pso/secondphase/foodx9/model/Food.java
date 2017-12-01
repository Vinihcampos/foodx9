package pso.secondphase.foodx9.model;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by vinihcampos on 30/11/17.
 */

public class Food {
    private String title;
    private String description;
    private Double price;
    private Integer image;

    public Food(){
        this.title = "";
        this.description = "";
        this.price = 0.0;
        this.image = null;
    }

    public Food(String title, String description, Double price, Integer image){
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
