package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Table(name = "users")
    public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name_name")
    String name;
    @Column(name = "email_email")
    String email;
    @Column(name = "password_password")
    String password;
    @Column(name = "phone_number")
    long PhoneNumber;
    @Column(name = "dob")
    LocalDate DOB;
    @Column(name = "gender")
    char Gender;
    @Column(name = "account_status")
    String AccountStatus;
    @Column(name = "last_login")
    Date LastLogin;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "Address" ,referencedColumnName = "addressId")
    Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = LocalDate.parse(DOB);
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char gender) {
        Gender = gender;
    }

    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        AccountStatus = accountStatus;
    }

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        LastLogin = lastLogin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}







