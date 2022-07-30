package com.example.project2.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user_receivers", schema = "project2", catalog = "")
public class UserReceivers {
    private int id;
    private String name;
    private String cmnd;

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
    @Column(name = "cmnd", nullable = false, length = 255)
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReceivers that = (UserReceivers) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(cmnd, that.cmnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cmnd);
    }

//    @OneToMany(mappedBy = "userReceiversByUserReceiverId")
//    public Collection<ImportExports> getImportExportsById() {
//        return importExportsById;
//    }
//
//    public void setImportExportsById(Collection<ImportExports> importExportsById) {
//        this.importExportsById = importExportsById;
//    }
}
