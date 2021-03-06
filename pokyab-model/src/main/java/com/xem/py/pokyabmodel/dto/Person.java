package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "PERSONS")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "PERSON_ID")
    private int personId;
    @Column(name = "ORG_ID")
    private int orgId;    
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    @Column(name = "EMPLOYEE_NUMBER")
    private String employeeNumber;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "PRE_NAME")
    private String preName;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @Column(name = "DATE_OF_DEATH")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfDeath;
    @Basic(optional = false)
    @Column(name = "GENDER_CODE")
    private String genderCode;
    @Basic(optional = false)
    @Column(name = "PERSON_TYPE")
    private String personType;
    @Column(name = "MARITAL_STATUS_CODE")
    private String maritalStatusCode;
    //@Basic(optional = false) Modificar modelo
    @Column(name = "NATIONALITY_CODE")
    private String nationalityCode;
    @Column(name = "NATIONAL_IDENTIFIER")
    private String nationalIdentifier;
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private Character active;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;    
    transient int currentAge;

    @Transient
    private MultipartFile file;

    public Person() {
        this.active = 'Y';
        this.startDate = new java.sql.Date(System.currentTimeMillis());
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setFullName() {
        this.fullName = this.firstName +" "+ this.lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getNationalIdentifier() {
        return nationalIdentifier;
    }

    public void setNationalIdentifier(String nationalIdentifier) {
        this.nationalIdentifier = nationalIdentifier;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

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
    
    public int getCurrentAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;                
        return Period.between(birthDate, currentDate).getYears();
    }  
    
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    @Override
    public String toString() {
        return "Person{" + "personId=" + personId + ", orgId=" + orgId + ", hireDate=" + hireDate + ", employeeNumber=" + employeeNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", preName=" + preName + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", dateOfDeath=" + dateOfDeath + ", genderCode=" + genderCode + ", personType=" + personType + ", maritalStatusCode=" + maritalStatusCode + ", nationalityCode=" + nationalityCode + ", nationalIdentifier=" + nationalIdentifier + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", active=" + active + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
}
