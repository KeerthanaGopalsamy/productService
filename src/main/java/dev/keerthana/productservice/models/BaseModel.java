package dev.keerthana.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;
    private String testColumn;

//    public BaseModel(int id, Date createdAt, Date updatedAt, boolean isDeleted) {
//        this.id = id;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.isDeleted = isDeleted;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
