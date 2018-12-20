package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "LOOKUP_USES")
public class LookupUse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOOKUP_USE_ID")
    private int lookupUseId;
    @Basic(optional = false)
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Column(name = "REQUIRED")
    private String required;
    @Column(name = "ACTIVE", nullable = false)
    private boolean active;
    @Basic(optional = false)
    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    //FKs
//    @JoinColumn(name = "LOOKUP_TYPE_ID", referencedColumnName = "LOOKUP_TYPE_ID")
//    @ManyToOne(optional = false)
    @Column(name = "LOOKUP_TYPE_ID")
    private int lookupTypeId;

    public LookupUse() {
        this.active = true;
        this.startDate = new java.sql.Date(System.currentTimeMillis());
    }

    public int getLookupUseId() {
        return lookupUseId;
    }

    public void setLookupUseId(int lookupUseId) {
        this.lookupUseId = lookupUseId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }    
    
    public int getLookupTypeId() {
        return lookupTypeId;
    }

    public void setLookupTypeId(int lookupTypeId) {
        this.lookupTypeId = lookupTypeId;
    }

    @Override
    public String toString() {
        return "LookupUse{" + "lookupUseId=" + lookupUseId + ", tableName=" + tableName + ", columnName=" + columnName + ", active=" + active + ", startDate=" + startDate + ", endDate=" + endDate + ", lookupTypeId=" + lookupTypeId + '}';
    }        
}
