package com.example.project2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Warehouses {
    private int id;
    private String name;
    private String code;
    private String description;
    private String positionName;
    private Integer palletRankingNumber;
    private Integer rowsNumber;
    private Integer columnsNumber;
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
    @Column(name = "code", nullable = false, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "position_name", nullable = true, length = 255)
    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Basic
    @Column(name = "pallet_ranking_number", nullable = true)
    public Integer getPalletRankingNumber() {
        return palletRankingNumber;
    }

    public void setPalletRankingNumber(Integer palletRankingNumber) {
        this.palletRankingNumber = palletRankingNumber;
    }

    @Basic
    @Column(name = "rows_number", nullable = true)
    public Integer getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(Integer rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    @Basic
    @Column(name = "columns_number", nullable = true)
    public Integer getColumnsNumber() {
        return columnsNumber;
    }

    public void setColumnsNumber(Integer columnsNumber) {
        this.columnsNumber = columnsNumber;
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
        Warehouses that = (Warehouses) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(description, that.description) && Objects.equals(positionName, that.positionName) && Objects.equals(palletRankingNumber, that.palletRankingNumber) && Objects.equals(rowsNumber, that.rowsNumber) && Objects.equals(columnsNumber, that.columnsNumber) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, description, positionName, palletRankingNumber, rowsNumber, columnsNumber, createdAt, updatedAt);
    }


}
