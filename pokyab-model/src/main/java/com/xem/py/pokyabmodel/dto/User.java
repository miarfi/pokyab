package com.xem.py.pokyabmodel.dto;

/**
 *
 * @author arria
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "USERS",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"EMAIL"})}
)
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
//	@NotBlank(message = "Please enter first name!")
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
//	@NotBlank(message = "Please enter last name!")
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
//	@NotBlank(message = "Please enter email address!")}
    @Column(name = "EMAIL")
    private String email;
//	@NotBlank(message = "Please enter contact number!")
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    @Column(name = "ROLE_")
    private String role;
    @Column(name = "PASSWORD")
    @Basic(optional = false)
//	@NotBlank(message = "Please enter password!")
    @JsonIgnore
    private String password;
    @Transient
    @JsonIgnore
    private String confirmPassword;
    @Basic(optional = false)
    @Column(name = "ENABLED")    
    private boolean enabled;
//    @Column(name = "STATUS")
//    private Character status;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;

//    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID")    
//    @OneToOne
    @Column(name = "PERSON_ID")
    private int personId;

    public User() {
//        this.status = 'Y';
        this.startDate = new java.sql.Date(System.currentTimeMillis());
        this.enabled = true;
        this.role = "NO_ROLE";
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

//    public Character getStatus() {
//        return status;
//    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }    
    
//    public void setStatus(Character status) {
//        this.status = status;
//    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", confirmPassword=" + confirmPassword + ", enabled=" + enabled + ", startDate=" + startDate + ", endDate=" + endDate + ", personId=" + personId + '}';
    }
}
