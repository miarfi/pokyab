package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.view.PersonV;
import java.util.List;

/**
 *
 * @author arria
 */
public interface PersonDAO {
    boolean add(Person person);
    boolean update(Person person);
    boolean delete(Person person);
    List<Person> getActivePersons();
    List<Person> getAvailablePersons();   
    List<PersonV> getAllPersonsV();   
    Person getPersonById(int id);
    
}
