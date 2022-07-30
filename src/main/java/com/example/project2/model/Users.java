package com.example.project2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Users {
    private int id;
    private String fullname;
    private String categoryIds;
    private int warehouseId;
    private int unitId;
    private String cmnd;
    private String phone;
    private String email;
    private String username;
    private String code;
    private String password;
    private Timestamp createdAt;
    private Warehouses warehousesByWarehouseId;
    private Militaryunits militaryunitsByUnitId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fullname", nullable = true, length = 255)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "category_ids", nullable = true, length = 255)
    public String getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }

    @Basic
    @Column(name = "warehouse_id", nullable = false, insertable = false, updatable = false)
    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "unit_id", nullable = false, insertable = false, updatable = false)
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "cmnd", nullable = true, length = 255)
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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
    @Column(name = "username", nullable = true, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "created_at", nullable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && warehouseId == users.warehouseId && unitId == users.unitId && Objects.equals(fullname, users.fullname) && Objects.equals(categoryIds, users.categoryIds) && Objects.equals(cmnd, users.cmnd) && Objects.equals(phone, users.phone) && Objects.equals(email, users.email) && Objects.equals(username, users.username) && Objects.equals(code, users.code) && Objects.equals(password, users.password) && Objects.equals(createdAt, users.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, categoryIds, warehouseId, unitId, cmnd, phone, email, username, code, password, createdAt);
    }

//    @OneToMany(mappedBy = "usersByAcceptedBy")
//    public Collection<Approvals> getApprovalsById() {
//        return approvalsById;
//    }
//
//    public void setApprovalsById(Collection<Approvals> approvalsById) {
//        this.approvalsById = approvalsById;
//    }
//
//    @OneToMany(mappedBy = "usersByCreatedBy")
//    public Collection<ImportExports> getImportExportsById() {
//        return importExportsById;
//    }
//
//    public void setImportExportsById(Collection<ImportExports> importExportsById) {
//        this.importExportsById = importExportsById;
//    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", nullable = false)
    public Warehouses getWarehousesByWarehouseId() {
        return warehousesByWarehouseId;
    }

    public void setWarehousesByWarehouseId(Warehouses warehousesByWarehouseId) {
        this.warehousesByWarehouseId = warehousesByWarehouseId;
    }

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    public Militaryunits getMilitaryunitsByUnitId() {
        return militaryunitsByUnitId;
    }

    public void setMilitaryunitsByUnitId(Militaryunits militaryunitsByUnitId) {
        this.militaryunitsByUnitId = militaryunitsByUnitId;
    }
}
