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
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "LOOKUP_VALUES")
public class LookupValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOOKUP_VALUE_ID", nullable = false)        
    private int lookupValueId;   
//    @JoinColumn(name = "LOOKUP_TYPE_ID", referencedColumnName = "LOOKUP_TYPE_ID")
//    @ManyToOne(optional = false)
//    private LookupType lookupTypeId;
//    private int lookupTypeId;
    @Basic(optional = false)
    @Column(name = "LOOKUP_CODE", nullable = false, length = 30)
    private String lookupCode;
    @Column(name = "MEANING", length = 150)
    private String meaning;
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    @Basic(optional = false)    
    @Column(name = "ACTIVE", nullable = false)
    private Character active;
    @Basic(optional = false)
    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;    

    public LookupValue() {
        this.active = 'Y';
    }

    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getLookupValueId() {
        return lookupValueId;
    }

    public void setLookupValueId(int lookupValueId) {
        this.lookupValueId = lookupValueId;
    }

//    public LookupType getLookupTypeId() {
//        return lookupTypeId;
//    }
//
//    public void setLookupTypeId(LookupType lookupTypeId) {
//        this.lookupTypeId = lookupTypeId;
//    }
    
}
