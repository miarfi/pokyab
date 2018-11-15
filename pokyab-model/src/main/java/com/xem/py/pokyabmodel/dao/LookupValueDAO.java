package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.LookupValue;
import java.util.List;

/**
 *
 * @author arria
 */
public interface LookupValueDAO {
    boolean add(LookupValue lookupValue);
    boolean update(LookupValue lookupValue);
    boolean delete(LookupValue lookupValue);
    public LookupValue getLookupValueById(int id);
    List<LookupValue> getLkpValuesByTypeId(int lookupTypeId);    
    List<LookupValue> getLkpValuesByType(String lookupType);
    

}
