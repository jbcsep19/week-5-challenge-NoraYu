package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String posteddate;
    private String author;
    private String phone;
    private String pic;


    public Job(){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.posteddate = dateFormat.format(date);

    }
    public Job(String title, String content,String author,String phone){
        this();
        this.title=title;
        this.content=content;
        this.id=getId();
        this.author=author;
        this.phone=phone;
        this.setDefaultPic();

    }
    public Job(String title, String content,String author,String phone,boolean check){
        this();
        this.title=title;
        this.content=content;
        this.id=getId();
        this.author=author;
        this.phone=phone;
        this.setDefaultPic();

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosteddate() {

        return posteddate;
    }


    public void setPosteddate() {
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        this.posteddate = dateFormat.format(date);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setPosteddate(String posteddate) {
        this.posteddate = posteddate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setDefaultPic() {
        String url="https://i.ytimg.com/vi/Fv5MZFWn7lE/maxresdefault.jpg";
        this.pic = url.toString();
    }
}
