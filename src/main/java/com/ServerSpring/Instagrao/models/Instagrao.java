package com.ServerSpring.Instagrao.models;



import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Instagrao {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @CreatedDate
    private long id;
    private String author;
    private String description;
    private String local;
    private Integer likes = 0;
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void newLike(){
        this.likes++;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
