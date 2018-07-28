package com.application.testapplication.ui.model.data;

import com.application.testapplication.data.model.response.sub.Attributes;

public class AccountAttributeModel {
    private String firstName;
    private String lastName;
    private String title;
    private String dob;
    private String contactNumber;
    private String email;
    private String expiryDate;
    private int credit;
    private String msn;
    private String creditExpiry;
    private String productName;
    private int productPrice;
    private int balance;

    public AccountAttributeModel(Attributes data) {
        firstName = data.getFirstName();
        lastName = data.getLastName();
        title = data.getTitle();
        dob = data.getDateOfBirth();
        contactNumber = data.getContactNumber();
        email = data.getEmailAddress();
        expiryDate = data.getExpiryDate();
        credit = data.getCredit() != null ? data.getCredit() : 0;
        msn = data.getMsn();
        creditExpiry = data.getCreditExpiry();
        productName = data.getName();
        productPrice = data.getPrice() != null ? data.getPrice() : 0;
        balance = data.getIncludedDataBalance() != null ? data.getIncludedDataBalance() : 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getDob() {
        return dob;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public long getCredit() {
        return credit;
    }

    public String getMsn() {
        return msn;
    }

    public String getCreditExpiry() {
        return creditExpiry;
    }

    public String getProductName() {
        return productName;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public long getBalance() {
        return balance;
    }
}
