
package com.xem.py.pokyabmodel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "LOOKUP_TYPES"
        ,uniqueConstraints={@UniqueConstraint(columnNames={"LOOKUP_TYPE"})}
        )
public class LookupType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOOKUP_TYPE_ID")
    private int lookupTypeId;
    @Basic(optional = false)
    @Column(name = "LOOKUP_TYPE")
    private String lookupType;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "VALUE_TYPE")
    private Character valueType;
    @Column(name = "PARENT_LOOKUP_TYPE_ID")
    private int parentLookupTypeId;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private Character active;
    @Basic(optional = false)
    @Column(name = "SYSTEM_FLAG")
    private Character systemFlag;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;
    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "lookupTypeId")//cascade = CascadeType.ALL,
    @JsonIgnore
    private Collection<LookupValue> lookupValueCollection;
    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "lookupTypeId")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Collection<LookupUse> lookupUseCollection;
    
    
    public LookupType() {
        this.active = 'Y';
        this.startDate = new java.sql.Date(System.currentTimeMillis());
    }

    public int getLookupTypeId() {
        return lookupTypeId;
    }

    public void setLookupTypeId(int lookupTypeId) {
        this.lookupTypeId = lookupTypeId;
    }

    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType.toUpperCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getValueType() {
        return valueType;
    }

    public void setValueType(Character valueType) {
        this.valueType = valueType;
    }

    public int getParentLookupTypeId() {
        return parentLookupTypeId;
    }

    public void setParentLookupTypeId(int parentLookupTypeId) {
        this.parentLookupTypeId = parentLookupTypeId;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(Character systemFlag) {
        this.systemFlag = systemFlag;
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

    @Override
    public String toString() {
        return "LookupType{" + "lookupTypeId=" + lookupTypeId + ", lookupType=" + lookupType + ", description=" + description + ", valueType=" + valueType + ", parentLookupTypeId=" + parentLookupTypeId + ", active=" + active + ", systemFlag=" + systemFlag + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
    @XmlTransient
    public Collection<LookupValue> getLookupValueCollection() {
        return lookupValueCollection;
    }

    public void setLookupValueCollection(Collection<LookupValue> lookupValueCollection) {
        this.lookupValueCollection = lookupValueCollection;
    }

    @XmlTransient
    public Collection<LookupUse> getLookupUseCollection() {
        return lookupUseCollection;
    }

    public void setLookupUseCollection(Collection<LookupUse> lookupUseCollection) {
        this.lookupUseCollection = lookupUseCollection;
    }

}
