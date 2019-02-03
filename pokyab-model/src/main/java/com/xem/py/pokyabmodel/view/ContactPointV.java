package com.xem.py.pokyabmodel.view;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Immutable
@Table(name = "CONTACT_POINTS_V")
public class ContactPointV implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_POINT_ID")
    private int contactPointId;
    @Column(name = "OWNER_TABLE_NAME")
    private String ownerTableName;
    @Column(name = "OWNER_TABLE_ID")
    private int ownerTableId;
    @Column(name = "CONTACT_TYPE")
    private String contactType;
    @Column(name = "USE_TYPE")
    private String useType;
    @Column(name = "CONTACT_VALUE")
    private String contactValue;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "PRIMARY_BY_TYPE")
    private Character primaryByType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public int getContactPointId() {
        return contactPointId;
    }

    public String getOwnerTableName() {
        return ownerTableName;
    }

    public int getOwnerTableId() {
        return ownerTableId;
    }

    public String getContactType() {
        return contactType;
    }

    public String getUseType() {
        return useType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public Character getActive() {
        return active;
    }

    public Character getPrimaryByType() {
        return primaryByType;
    }
        
}