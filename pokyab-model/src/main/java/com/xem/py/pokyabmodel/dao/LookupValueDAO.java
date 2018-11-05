package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.LookupValue;
import java.util.List;

/**
 *
 * @author arria
 */
public interface LookupValueDAO {
    boolean Add(LookupValue lookupValue);
//    boolean update(LookupValue lookupValue);
//    boolean delete(LookupValue lookupValue);
    List<LookupValue> getLkpValuesByTypeId(int lookupTypeId);
}
