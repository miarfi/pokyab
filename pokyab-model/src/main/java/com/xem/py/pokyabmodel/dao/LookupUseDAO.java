
package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.LookupUse;
import java.util.List;

/**
 *
 * @author miguel
 */
public interface LookupUseDAO {
    boolean add(LookupUse lookupUse);
    boolean update(LookupUse lookupUse);
    boolean delete(LookupUse lookupUse);
    public LookupUse getLookupUseById(int id);
    List<LookupUse> getLkpUsesByTypeId(int lookupTypeId);    
    List<LookupUse> getLkpUsesByType(String lookupType);
}
