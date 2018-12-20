package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.LookupUse;
import com.xem.py.pokyabmodel.view.TableColumnV;
import com.xem.py.pokyabmodel.view.TableV;
import java.util.List;

/**
 *
 * @author miguel
 */
public interface LookupUseDAO {
    boolean add(LookupUse lookupUse);
    boolean update(LookupUse lookupUse);
    boolean delete(LookupUse lookupUse);
    LookupUse getLookupUseById(int id);
    List<LookupUse> getLkpUsesByTypeId(int lookupTypeId);    
    List<LookupUse> getLkpUsesByType(String lookupType);
    List<TableColumnV> getTableColumnList();  
    List<TableV> getTableList(); 
    List<TableColumnV> getTableColumnList(String tableName);
}