package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.ContactPoint;
import com.xem.py.pokyabmodel.view.ContactPointV;
import java.util.List;

/**
 *
 * @author arria
 */
public interface ContactPointDAO {
    boolean add(ContactPoint contactPoint);
    boolean update(ContactPoint contactPoint);
    boolean delete(ContactPoint contactPoint);
    List<ContactPoint> getActiveContactPoints();     
    List<ContactPointV> getAllContactPointsV();   
    ContactPoint getContactPointById(int id);  
}
