
package com.xem.py.pokyabmodel.dao;

//import com.xem.py.pokyabmodel.dto.Address;
//import com.xem.py.pokyabmodel.dto.Cart;
import com.xem.py.pokyabmodel.dto.User;

public interface UserDAO {

	// user related operation
	User getByEmail(String email);
	User get(int id);

	boolean add(User user);
	
	// adding and updating a new address
	//Address getAddress(int addressId);
	//boolean addAddress(Address address);
	//boolean updateAddress(Address address);
	//Address getBillingAddress(int userId);
	//pingAddresses(int userId);		
}
