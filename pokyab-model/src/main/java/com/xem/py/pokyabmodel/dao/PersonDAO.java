package com.xem.py.pokyabmodel.dao;

import com.xem.py.pokyabmodel.dto.Person;
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
    List<Person> getAllPersons();   
    Person getPersonById(int id);
}
