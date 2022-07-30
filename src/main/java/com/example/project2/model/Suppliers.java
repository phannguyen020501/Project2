package com.example.project2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Suppliers {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String description;
    private Integer createdBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;

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
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "created_by", nullable = true)
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
        Suppliers suppliers = (Suppliers) o;
        return id == suppliers.id && Objects.equals(name, suppliers.name) && Objects.equals(address, suppliers.address) && Objects.equals(phone, suppliers.phone) && Objects.equals(email, suppliers.email) && Objects.equals(description, suppliers.description) && Objects.equals(createdBy, suppliers.createdBy) && Objects.equals(createdAt, suppliers.createdAt) && Objects.equals(updatedAt, suppliers.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, email, description, createdBy, createdAt, updatedAt);
    }

//    @OneToMany(mappedBy = "suppliersBySupplierId")
//    public Collection<ImportExports> getImportExportsById() {
//        return importExportsById;
//    }
//
//    public void setImportExportsById(Collection<ImportExports> importExportsById) {
//        this.importExportsById = importExportsById;
//    }
}
