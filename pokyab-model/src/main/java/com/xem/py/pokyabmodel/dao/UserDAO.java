
package com.xem.py.pokyabmodel.dao;

//import com.xem.py.pokyabmodel.dto.Address;
//import com.xem.py.pokyabmodel.dto.Cart;
import com.xem.py.pokyabmodel.dto.User;
import java.util.List;

public interface UserDAO {       
	boolean add(User user);	
        boolean update(User user);	
        boolean delete(User user);	        
        public List<User> getAllUsers();
        
	User getByEmail(String email);
	User getUserById(int id);        
	// adding and updating a new address
	//Address getAddress(int addressId);
	//boolean addAddress(Address address);
	//boolean updateAddress(Address address);
	//Address getBillingAddress(int userId);
	//pingAddresses(int userId);		
}
