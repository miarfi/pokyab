package com.xem.py.pokyabmodel.dto;

/**
 *
 * @author arria
 */

import java.io.Serializable;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

//import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_detail"
        ,uniqueConstraints={@UniqueConstraint(columnNames={"EMAIL"})}
)
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@NotBlank(message = "Please enter first name!")
	@Column(name = "FIRST_NAME")
	private String firstName;
//	@NotBlank(message = "Please enter last name!")
	@Column(name = "LAST_NAME")
	private String lastName;
//	@NotBlank(message = "Please enter email address!")
        @Column(name = "EMAIL")
	private String email;
//	@NotBlank(message = "Please enter contact number!")
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
        @Column(name = "ROLE_")
	private String role;
//	@NotBlank(message = "Please enter password!")
	private String password;
	private boolean enabled = true;
	@Transient
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}
	
	

	
}