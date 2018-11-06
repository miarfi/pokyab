package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.LookupType;
import java.util.List;

/**
 *
 * @author arria
 */
public interface LookupTypeDAO {
    boolean Add(LookupType lookupType);
//    boolean update(LookupType lookupType);
//    boolean delete(LookupType lookupType);
    List<LookupType> getAllLkpTypes();

    public LookupType getLookupTypeById(int id);
}
