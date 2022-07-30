package com.example.project2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Approvals {
    private int id;
    private int acceptedBy;
    private String type;
    private Integer content;
    private Integer status;
    private String data;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Users usersByAcceptedBy;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "accepted_by", nullable = false)
    public int getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(int acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "content", nullable = true)
    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "data", nullable = true, length = 255)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        Approvals approvals = (Approvals) o;
        return id == approvals.id && acceptedBy == approvals.acceptedBy && Objects.equals(type, approvals.type) && Objects.equals(content, approvals.content) && Objects.equals(status, approvals.status) && Objects.equals(data, approvals.data) && Objects.equals(createdAt, approvals.createdAt) && Objects.equals(updatedAt, approvals.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acceptedBy, type, content, status, data, createdAt, updatedAt);
    }

    @ManyToOne
    @JoinColumn(name = "accepted_by", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Users getUsersByAcceptedBy() {
        return usersByAcceptedBy;
    }

    public void setUsersByAcceptedBy(Users usersByAcceptedBy) {
        this.usersByAcceptedBy = usersByAcceptedBy;
    }
}
