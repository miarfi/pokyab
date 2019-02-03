
package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "CONTACT_POINTS")
public class ContactPoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTACT_POINT_ID")
    private int contactPointId;
    @Basic(optional = false)
    @Column(name = "OWNER_TABLE_NAME")
    private String ownerTableName;
    @Basic(optional = false)
    @Column(name = "OWNER_TABLE_ID")
    private int ownerTableId;
    @Basic(optional = false)
    @Column(name = "CONTACT_TYPE")
    private String contactType;
    @Basic(optional = false)
    @Column(name = "USE_TYPE")
    private String useType;
    @Basic(optional = false)
    @Column(name = "CONTACT_VALUE")
    private String contactValue;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "PRIMARY_BY_TYPE")
    private Character primaryByType;

    public ContactPoint() {
        this.active = 'Y';
    }

    public int getContactPointId() {
        return contactPointId;
    }

    public void setContactPointId(int contactPointId) {
        this.contactPointId = contactPointId;
    }

    public String getOwnerTableName() {
        return ownerTableName;
    }

    public void setOwnerTableName(String ownerTableName) {
        this.ownerTableName = ownerTableName;
    }

    public long getOwnerTableId() {
        return ownerTableId;
    }

    public void setOwnerTableId(int ownerTableId) {
        this.ownerTableId = ownerTableId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getPrimaryByType() {
        return primaryByType;
    }

    public void setPrimaryByType(Character primaryByType) {
        this.primaryByType = primaryByType;
    }  
}
