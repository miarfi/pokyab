
package com.xem.py.pokyabmodel.view;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "TABLE_COLUMN_V")
public class TableColumnV implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Id
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Column(name = "TABLE_SCHEMA")
    private String tableSchema;

    public String getTableName() {
        return tableName;
    }
    
    public String getColumnName() {
        return columnName;
    }

    public String getTableSchema() {
        return tableSchema;
    }
}