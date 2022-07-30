package com.example.project2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "receiver_units", schema = "project2")
public class ReceiverUnits {
    private int id;
    private String name;
    private String phone;
    private String description;
    private Integer createdBy;
    private Timestamp createAt;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "create_at", nullable = true)
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiverUnits that = (ReceiverUnits) o;
        return id == that.id && createdBy == that.createdBy && Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(description, that.description) && Objects.equals(createAt, that.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, description, createdBy, createAt);
    }

//    @OneToMany(mappedBy = "receiverUnitsByReceiverUnitId")
//    public Collection<ImportExports> getImportExportsById() {
//        return importExportsById;
//    }
//
//    public void setImportExportsById(Collection<ImportExports> importExportsById) {
//        this.importExportsById = importExportsById;
//    }
}
