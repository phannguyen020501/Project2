package com.example.project2.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "import_exports", schema = "project2")
public class ImportExports {
    private int id;
    private String code;
    private Integer type;
    private int warehouseId;
    private int supplierId;
    private int transportId;
    private String transportNote;
    private int receiverUnitId;
    private int userReceiverId;
    private String followBy;
    private String inspectionReport;
    private int categoryId;
    private Date deliveryDate;
    private Date commandDate;
    private int createdBy;
    private Integer parentId;
    private Warehouses warehousesByWarehouseId;
    private Suppliers suppliersBySupplierId;
    private Transports transportsByTransportId;
    private ReceiverUnits receiverUnitsByReceiverUnitId;
    private UserReceivers userReceiversByUserReceiverId;
    private Users usersByCreatedBy;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

//    @Basic
//    @Column(name = "timeExpire", nullable = true)
//    public Date getTimeExpire() {
//        return timeExpire;
//    }
//
//    public void setTimeExpire(Date timeExpire) {
//        this.timeExpire = timeExpire;
//    }

    @Basic
    @Column(name = "warehouse_id", nullable = false, insertable = false, updatable = false)
    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "supplier_id", nullable = false, insertable = false, updatable = false)
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "transport_id", nullable = false, insertable = false, updatable = false)
    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    @Basic
    @Column(name = "transport_note", nullable = true, length = 255)
    public String getTransportNote() {
        return transportNote;
    }

    public void setTransportNote(String transportNote) {
        this.transportNote = transportNote;
    }

    @Basic
    @Column(name = "receiver_unit_id", nullable = false,insertable = false, updatable = false)
    public int getReceiverUnitId() {
        return receiverUnitId;
    }

    public void setReceiverUnitId(int receiverUnitId) {
        this.receiverUnitId = receiverUnitId;
    }

    @Basic
    @Column(name = "user_receiver_id", nullable = false, insertable = false, updatable = false)
    public int getUserReceiverId() {
        return userReceiverId;
    }

    public void setUserReceiverId(int userReceiverId) {
        this.userReceiverId = userReceiverId;
    }

    @Basic
    @Column(name = "follow_by", nullable = true, length = 255)
    public String getFollowBy() {
        return followBy;
    }

    public void setFollowBy(String followBy) {
        this.followBy = followBy;
    }

    @Basic
    @Column(name = "inspection_report", nullable = true, length = 255)
    public String getInspectionReport() {
        return inspectionReport;
    }

    public void setInspectionReport(String inspectionReport) {
        this.inspectionReport = inspectionReport;
    }

    @Basic
    @Column(name = "category_id", nullable = true)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "delivery_date", nullable = true)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Basic
    @Column(name = "command_date", nullable = true)
    public Date getCommandDate() {
        return commandDate;
    }

    public void setCommandDate(Date commandDate) {
        this.commandDate = commandDate;
    }

    @Basic
    @Column(name = "created_by", nullable = false, insertable = false, updatable = false)
    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "parent_id", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportExports that = (ImportExports) o;
        return id == that.id && warehouseId == that.warehouseId && supplierId == that.supplierId && transportId == that.transportId && receiverUnitId == that.receiverUnitId && userReceiverId == that.userReceiverId && categoryId == that.categoryId && createdBy == that.createdBy && Objects.equals(code, that.code) && Objects.equals(type, that.type)  && Objects.equals(transportNote, that.transportNote) && Objects.equals(followBy, that.followBy) && Objects.equals(inspectionReport, that.inspectionReport) && Objects.equals(deliveryDate, that.deliveryDate) && Objects.equals(commandDate, that.commandDate) && Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, type, warehouseId, supplierId, transportId, transportNote, receiverUnitId, userReceiverId, followBy, inspectionReport, categoryId, deliveryDate, commandDate, createdBy, parentId);
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", nullable = false)
    public Warehouses getWarehousesByWarehouseId() {
        return warehousesByWarehouseId;
    }

    public void setWarehousesByWarehouseId(Warehouses warehousesByWarehouseId) {
        this.warehousesByWarehouseId = warehousesByWarehouseId;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id", nullable = false)
    public Suppliers getSuppliersBySupplierId() {
        return suppliersBySupplierId;
    }

    public void setSuppliersBySupplierId(Suppliers suppliersBySupplierId) {
        this.suppliersBySupplierId = suppliersBySupplierId;
    }

    @ManyToOne
    @JoinColumn(name = "transport_id", referencedColumnName = "id", nullable = false)
    public Transports getTransportsByTransportId() {
        return transportsByTransportId;
    }

    public void setTransportsByTransportId(Transports transportsByTransportId) {
        this.transportsByTransportId = transportsByTransportId;
    }

    @ManyToOne
    @JoinColumn(name = "receiver_unit_id", referencedColumnName = "id", nullable = false)
    public ReceiverUnits getReceiverUnitsByReceiverUnitId() {
        return receiverUnitsByReceiverUnitId;
    }

    public void setReceiverUnitsByReceiverUnitId(ReceiverUnits receiverUnitsByReceiverUnitId) {
        this.receiverUnitsByReceiverUnitId = receiverUnitsByReceiverUnitId;
    }

    @ManyToOne
    @JoinColumn(name = "user_receiver_id", referencedColumnName = "id", nullable = false)
    public UserReceivers getUserReceiversByUserReceiverId() {
        return userReceiversByUserReceiverId;
    }

    public void setUserReceiversByUserReceiverId(UserReceivers userReceiversByUserReceiverId) {
        this.userReceiversByUserReceiverId = userReceiversByUserReceiverId;
    }

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    public Users getUsersByCreatedBy() {
        return usersByCreatedBy;
    }

    public void setUsersByCreatedBy(Users usersByCreatedBy) {
        this.usersByCreatedBy = usersByCreatedBy;
    }

//    @OneToMany(mappedBy = "importExportsByImportExportId")
//    public Collection<ImportExportsDetails> getImportExportsDetailsById() {
//        return importExportsDetailsById;
//    }

//    public void setImportExportsDetailsById(Collection<ImportExportsDetails> importExportsDetailsById) {
//        this.importExportsDetailsById = importExportsDetailsById;
//    }
}
