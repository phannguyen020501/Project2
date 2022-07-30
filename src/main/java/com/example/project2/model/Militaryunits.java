package com.example.project2.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Militaryunits {
    private int id;
    private String code;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Militaryunits that = (Militaryunits) o;
        return id == that.id && Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }

//    @OneToMany(mappedBy = "militaryunitsByUnitId")
//    public Collection<Users> getUsersById() {
//        return usersById;
//    }
//
//    public void setUsersById(Collection<Users> usersById) {
//        this.usersById = usersById;
//    }
}
