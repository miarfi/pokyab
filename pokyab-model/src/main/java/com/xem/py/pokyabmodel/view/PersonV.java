package com.xem.py.pokyabmodel.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Immutable
@Table(name = "PERSONS_V")
public class PersonV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id   
    @Column(name = "PERSON_ID")
    private int personId;
    @Column(name = "ORG_ID")    
    private int orgId;    
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date hireDate;
    @Column(name = "EMPLOYEE_NUMBER")
    private String employeeNumber;   
    @Column(name = "FIRST_NAME")
    private String firstName;    
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "PRE_NAME")
    private String preName;
    @Column(name = "FULL_NAME")
    private String fullName;    
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    @Column(name = "DATE_OF_DEATH")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfDeath;    
    @Column(name = "GENDER_CODE")
    private String genderCode;
    @Column(name = "PERSON_TYPE")
    private String personType;
    @Column(name = "MARITAL_STATUS_CODE")
    private String maritalStatusCode;    
    @Column(name = "NATIONALITY_CODE")
    private String nationalityCode;
    @Column(name = "NATIONAL_IDENTIFIER")
    private String nationalIdentifier;
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;    
    @Column(name = "ACTIVE")
    private Character active;    
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;    
    transient int currentAge;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPersonId() {
        return personId;
    }

    public int getOrgId() {
        return orgId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPreName() {
        return preName;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public String getPersonType() {
        return personType;
    }

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public String getNationalIdentifier() {
        return nationalIdentifier;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Character getActive() {
        return active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getCurrentAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;                
        return Period.between(birthDate, currentDate).getYears();
    }
    
}
