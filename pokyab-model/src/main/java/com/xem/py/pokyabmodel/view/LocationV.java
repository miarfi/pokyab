
package com.xem.py.pokyabmodel.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Immutable
@Table(name = "LOCATION_V")
public class LocationV implements Serializable{
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "LOCATION_ID")
    private int locationId;       
    @Column(name = "OWNER_TABLE_NAME")
    private String ownerTableName;    
    @Column(name = "OWNER_TABLE_ID")
    private int ownerTableId;    
    @Column(name = "LOCATION_TYPE")
    private String locationType;    
    @Column(name = "NAME")
    private String name;    
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
    @Column(name = "VALIDATE_SEPOMEX")
    private Character validateSepomex;    
    @Column(name = "PRIMARY_BY_TYPE")
    private Character primaryByType;    
    @Column(name = "ACTIVE")
    private Character active;    
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate; 

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getOwnerTableName() {
        return ownerTableName;
    }

    public int getOwnerTableId() {
        return ownerTableId;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getName() {
        return name;
    }

    public String getAddress1() {
        return address1;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public String getExternalNumber() {
        return externalNumber;
    }

    public short getFloor() {
        return floor;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public String getBetweenStreet1() {
        return betweenStreet1;
    }

    public String getBetweenStreet2() {
        return betweenStreet2;
    }

    public String getReference() {
        return reference;
    }

    public Character getValidateSepomex() {
        return validateSepomex;
    }

    public Character getPrimaryByType() {
        return primaryByType;
    }

    public Character getActive() {
        return active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
    
}
