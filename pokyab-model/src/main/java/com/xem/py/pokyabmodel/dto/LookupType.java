
package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "LOOKUP_TYPES")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "LookupType.findAll", query = "SELECT l FROM LookupType l")})
public class LookupType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOOKUP_TYPE_ID")
    private Long lookupTypeId;
    @Basic(optional = false)
    @Column(name = "LOOKUP_TYPE")
    private String lookupType;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "VALUE_TYPE")
    private Character valueType;
    @Column(name = "PARENT_LOOKUP_TYPE_ID")
    private Long parentLookupTypeId;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private Character active;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lookupType")
//    private Collection<LookupValue> lookupValueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lookupTypeId")
    private Collection<LookupTypeUse> lookupTypeUseCollection;

    public LookupType() {
        this.active = 'Y';
    }

//    public LookupType(Long lookupTypeId) {
//        this.lookupTypeId = lookupTypeId;
//    }
//
//    public LookupType(Long lookupTypeId, String lookupType, Character active, Date startDate) {
//        this.lookupTypeId = lookupTypeId;
//        this.lookupType = lookupType;
//        this.active = active;
//        this.startDate = startDate;
//    }

    public Long getLookupTypeId() {
        return lookupTypeId;
    }

    public void setLookupTypeId(Long lookupTypeId) {
        this.lookupTypeId = lookupTypeId;
    }

    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
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

    public Long getParentLookupTypeId() {
        return parentLookupTypeId;
    }

    public void setParentLookupTypeId(Long parentLookupTypeId) {
        this.parentLookupTypeId = parentLookupTypeId;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
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

//    @XmlTransient
//    public Collection<LookupValue> getLookupValueCollection() {
//        return lookupValueCollection;
//    }
//
//    public void setLookupValueCollection(Collection<LookupValue> lookupValueCollection) {
//        this.lookupValueCollection = lookupValueCollection;
//    }

    @XmlTransient
    public Collection<LookupTypeUse> getLookupTypeUseCollection() {
        return lookupTypeUseCollection;
    }

    public void setLookupTypeUseCollection(Collection<LookupTypeUse> lookupTypeUseCollection) {
        this.lookupTypeUseCollection = lookupTypeUseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lookupTypeId != null ? lookupTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LookupType)) {
            return false;
        }
        LookupType other = (LookupType) object;
        if ((this.lookupTypeId == null && other.lookupTypeId != null) || (this.lookupTypeId != null && !this.lookupTypeId.equals(other.lookupTypeId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.LookupType[ lookupTypeId=" + lookupTypeId + " ]";
//    }
    
}
