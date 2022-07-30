package com.example.project2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Products {
    private int id;
    private String code;
    private String name;
    private String prices;
    private String unit;
    private Double maintenanceCycle;
    private Integer genericId;
    private String description;
    private Integer createdBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Generics genericsByGenericId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "prices", nullable = false, length = 255)
    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    @Basic
    @Column(name = "unit", nullable = true, length = 255)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "maintenance_cycle", nullable = true, precision = 0)
    public Double getMaintenanceCycle() {
        return maintenanceCycle;
    }

    public void setMaintenanceCycle(Double maintenanceCycle) {
        this.maintenanceCycle = maintenanceCycle;
    }

    @Basic
    @Column(name = "generic_id", nullable = false, insertable = false, updatable = false)
    public Integer getGenericId() {
        return genericId;
    }

    public void setGenericId(Integer genericId) {
        this.genericId = genericId;
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
        Products products = (Products) o;
        return id == products.id && Objects.equals(code, products.code) && Objects.equals(name, products.name) && Objects.equals(prices, products.prices) && Objects.equals(unit, products.unit) && Objects.equals(maintenanceCycle, products.maintenanceCycle) && Objects.equals(genericId, products.genericId) && Objects.equals(description, products.description) && Objects.equals(createdBy, products.createdBy) && Objects.equals(createdAt, products.createdAt) && Objects.equals(updatedAt, products.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, prices, unit, maintenanceCycle, genericId, description, createdBy, createdAt, updatedAt);
    }

//    @OneToMany(mappedBy = "productsByProductsId")
//    public Collection<ImportExportsDetails> getImportExportsDetailsById() {
//        return importExportsDetailsById;
//    }
//
//    public void setImportExportsDetailsById(Collection<ImportExportsDetails> importExportsDetailsById) {
//        this.importExportsDetailsById = importExportsDetailsById;
//    }

    @ManyToOne
    @JoinColumn(name = "generic_id", referencedColumnName = "id")
    public Generics getGenericsByGenericId() {
        return genericsByGenericId;
    }

    public void setGenericsByGenericId(Generics genericsByGenericId) {
        this.genericsByGenericId = genericsByGenericId;
    }
}
