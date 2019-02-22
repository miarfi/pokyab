
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
@Table(name = "LOCATIONS")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOCATION_ID")
    private int locationId;
//    @Column(name = "ORG_ID")
//    private int orgId;
    @Basic(optional = false)
    @Column(name = "OWNER_TABLE_NAME")
    private String ownerTableName;
    @Basic(optional = false)
    @Column(name = "OWNER_TABLE_ID")
    private int ownerTableId;
//    @Basic(optional = false)
    @Column(name = "LOCATION_TYPE")
    private String locationType;    
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "INTERNAL_NUMBER")
    private String internalNumber;
    @Column(name = "EXTERNAL_NUMBER")
    private String externalNumber;
    @Column(name = "FLOOR")
    private short floor;
    @Column(name = "STREET")
    private String street;
    @Column(name = "STATE")
    private String state;
    @Column(name = "CITY")
    private String city;
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PROVINCE_ID")
    private int provinceId;
    @Column(name = "BETWEEN_STREET1")
    private String betweenStreet1;
    @Column(name = "BETWEEN_STREET2")
    private String betweenStreet2;
    @Column(name = "REFERENCE")
    private String reference;
//    @Basic(optional = false)
    @Column(name = "VALIDATE_SEPOMEX")
    private Character validateSepomex;    
    @Column(name = "PRIMARY_BY_TYPE")
    private Character primaryByType;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private Character active;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public Location() {
        this.active = 'Y';
        this.startDate = new java.sql.Date(System.currentTimeMillis());
//        this.locationType = "SHIP_TO";
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

//    public int getOrgId() {
//        return orgId;
//    }
//
//    public void setOrgId(int orgId) {
//        this.orgId = orgId;
//    }

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

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(String internalNumber) {
        this.internalNumber = internalNumber;
    }

    public String getExternalNumber() {
        return externalNumber;
    }

    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber;
    }

    public short getFloor() {
        return floor;
    }

    public void setFloor(short floor) {
        this.floor = floor;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getBetweenStreet1() {
        return betweenStreet1;
    }

    public void setBetweenStreet1(String betweenStreet1) {
        this.betweenStreet1 = betweenStreet1;
    }

    public String getBetweenStreet2() {
        return betweenStreet2;
    }

    public void setBetweenStreet2(String betweenStreet2) {
        this.betweenStreet2 = betweenStreet2;
    }

    public String getReferences() {
        return reference;
    }

    public void setReferences(String references) {
        this.reference = references;
    }

    public Character getValidateSepomex() {
        return validateSepomex;
    }

    public void setValidateSepomex(Character validateSepomex) {
        this.validateSepomex = validateSepomex;
    }

    public Character getPrimaryByType() {
        return primaryByType;
    }

    public void setPrimaryByType(Character primaryByType) {
        this.primaryByType = primaryByType;
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
    
}
