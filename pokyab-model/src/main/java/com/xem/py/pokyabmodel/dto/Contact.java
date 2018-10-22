
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
@Table(name = "CONTACTS")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTACT_ID")
    private Long contactId;
    @Basic(optional = false)
    @Column(name = "OWNER_TABLE_NAME")
    private String ownerTableName;
    @Basic(optional = false)
    @Column(name = "OWNER_TABLE_ID")
    private long ownerTableId;
    @Basic(optional = false)
    @Column(name = "CONTACT_TYPE")
    private String contactType;
    @Basic(optional = false)
    @Column(name = "USE_TYPE")
    private String useType;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private Character active;
    @Basic(optional = false)
    @Column(name = "PRIMARY_BY_TYPE")
    private Character primaryByType;

    public Contact() {
    }

//    public Contact(Long contactId) {
//        this.contactId = contactId;
//    }
//
//    public Contact(Long contactId, String ownerTableName, long ownerTableId, String contactType, String useType, Character active, Character primaryByType) {
//        this.contactId = contactId;
//        this.ownerTableName = ownerTableName;
//        this.ownerTableId = ownerTableId;
//        this.contactType = contactType;
//        this.useType = useType;
//        this.active = active;
//        this.primaryByType = primaryByType;
//    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
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

    public void setOwnerTableId(long ownerTableId) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.Contact[ contactId=" + contactId + " ]";
//    }
    
}
