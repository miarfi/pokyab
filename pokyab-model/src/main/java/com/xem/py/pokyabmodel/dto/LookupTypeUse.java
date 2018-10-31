
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
public class LookupTypeUse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOOKUP_TYPE_USE_ID")
    private int lookupTypeUseId;
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

    public int getLookupTypeUseId() {
        return lookupTypeUseId;
    }

    public void setLookupTypeUseId(int lookupTypeUseId) {
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

}
