package com.example.project2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Generics {
    private int id;
    private String name;
    private Integer parentId;
    private String description;
    private int categoryId;
    private Integer height;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Categories categoriesByCategoryId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parent_id", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "category_id", nullable = false, insertable = false, updatable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "height", nullable = true)
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "created_at", nullable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = true)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Generics generics = (Generics) o;
        return id == generics.id && categoryId == generics.categoryId && Objects.equals(name, generics.name) && Objects.equals(parentId, generics.parentId) && Objects.equals(description, generics.description) && Objects.equals(height, generics.height) && Objects.equals(createdAt, generics.createdAt) && Objects.equals(updatedAt, generics.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parentId, description, categoryId, height, createdAt, updatedAt);
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    public Categories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Categories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

//    @OneToMany(mappedBy = "genericsByGenericId")
//    public Collection<Products> getProductsById() {
//        return productsById;
//    }
//
//    public void setProductsById(Collection<Products> productsById) {
//        this.productsById = productsById;
//    }


    @Override
    public String toString() {
        return "Generics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", height=" + height +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
