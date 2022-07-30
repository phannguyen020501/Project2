package com.example.project2.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "import_exports_details")
public class ImportExportsDetails {
    private int id;
    private Integer productId;
    private Integer scheduleQuantity;
    private Integer realQuantity;
    private Timestamp warantyDate;
    private Double price;
    private String note;
    private int importExportId;
    private int productsId;
    private ImportExports importExportsByImportExportId;
    private Products productsByProductsId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id", nullable = true)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "schedule_quantity", nullable = true)
    public Integer getScheduleQuantity() {
        return scheduleQuantity;
    }

    public void setScheduleQuantity(Integer scheduleQuantity) {
        this.scheduleQuantity = scheduleQuantity;
    }

    @Basic
    @Column(name = "real_quantity", nullable = true)
    public Integer getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(Integer realQuantity) {
        this.realQuantity = realQuantity;
    }

    @Basic
    @Column(name = "waranty_date", nullable = true)
    public Timestamp getWarantyDate() {
        return warantyDate;
    }

    public void setWarantyDate(Timestamp warantyDate) {
        this.warantyDate = warantyDate;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "note", nullable = true, length = 255)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "import_export_id", nullable = false, insertable = false, updatable = false)
    public int getImportExportId() {
        return importExportId;
    }

    public void setImportExportId(int importExportId) {
        this.importExportId = importExportId;
    }

    @Basic
    @Column(name = "products_id", nullable = false, insertable = false, updatable = false)
    public int getProductsId() {
        return productsId;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportExportsDetails that = (ImportExportsDetails) o;
        return id == that.id && importExportId == that.importExportId && productsId == that.productsId && Objects.equals(productId, that.productId) && Objects.equals(scheduleQuantity, that.scheduleQuantity) && Objects.equals(realQuantity, that.realQuantity) && Objects.equals(warantyDate, that.warantyDate) && Objects.equals(price, that.price) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, scheduleQuantity, realQuantity, warantyDate, price, note, importExportId, productsId);
    }

    @ManyToOne
    @JoinColumn(name = "import_export_id", referencedColumnName = "id", nullable = false)
    public ImportExports getImportExportsByImportExportId() {
        return importExportsByImportExportId;
    }

    public void setImportExportsByImportExportId(ImportExports importExportsByImportExportId) {
        this.importExportsByImportExportId = importExportsByImportExportId;
    }

    @ManyToOne
    @JoinColumn(name = "products_id", referencedColumnName = "id", nullable = false)
    public Products getProductsByProductsId() {
        return productsByProductsId;
    }

    public void setProductsByProductsId(Products productsByProductsId) {
        this.productsByProductsId = productsByProductsId;
    }
}
