
package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "LOOKUP_TYPE_USES")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "LookupTypeUse.findAll", query = "SELECT l FROM LookupTypeUse l")})
public class LookupTypeUse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOOKUP_TYPE_USE_ID")
    private Long lookupTypeUseId;
    @Basic(optional = false)
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @JoinColumn(name = "LOOKUP_TYPE_ID", referencedColumnName = "LOOKUP_TYPE_ID")
    @ManyToOne(optional = false)
    private LookupType lookupTypeId;

    public LookupTypeUse() {
    }

//    public LookupTypeUse(Long lookupTypeUseId) {
//        this.lookupTypeUseId = lookupTypeUseId;
//    }
//
//    public LookupTypeUse(Long lookupTypeUseId, String tableName, String columnName) {
//        this.lookupTypeUseId = lookupTypeUseId;
//        this.tableName = tableName;
//        this.columnName = columnName;
//    }

    public Long getLookupTypeUseId() {
        return lookupTypeUseId;
    }

    public void setLookupTypeUseId(Long lookupTypeUseId) {
        this.lookupTypeUseId = lookupTypeUseId;
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

    public LookupType getLookupTypeId() {
        return lookupTypeId;
    }

    public void setLookupTypeId(LookupType lookupTypeId) {
        this.lookupTypeId = lookupTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lookupTypeUseId != null ? lookupTypeUseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LookupTypeUse)) {
            return false;
        }
        LookupTypeUse other = (LookupTypeUse) object;
        if ((this.lookupTypeUseId == null && other.lookupTypeUseId != null) || (this.lookupTypeUseId != null && !this.lookupTypeUseId.equals(other.lookupTypeUseId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.LookupTypeUse[ lookupTypeUseId=" + lookupTypeUseId + " ]";
//    }
    
}
