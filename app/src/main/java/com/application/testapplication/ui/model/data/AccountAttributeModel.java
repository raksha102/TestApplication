package com.application.testapplication.ui.model.data;

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
    private boolean unlimitedText;
    private boolean unlimitedTalk;
    private boolean unlimitedIntText;
    private boolean unlimitedIntTalk;
    private boolean autoRenewal;
    private boolean primarySubscription;
    private String paymentType;
    private String type;

    public AccountAttributeModel() {
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

    public boolean isUnlimitedText() {
        return unlimitedText;
    }

    public boolean isUnlimitedTalk() {
        return unlimitedTalk;
    }

    public boolean isUnlimitedIntText() {
        return unlimitedIntText;
    }

    public boolean isUnlimitedIntTalk() {
        return unlimitedIntTalk;
    }

    public boolean isAutoRenewal() {
        return autoRenewal;
    }

    public boolean isPrimarySubscription() {
        return primarySubscription;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public void setCreditExpiry(String creditExpiry) {
        this.creditExpiry = creditExpiry;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUnlimitedText(boolean unlimitedText) {
        this.unlimitedText = unlimitedText;
    }

    public void setUnlimitedTalk(boolean unlimitedTalk) {
        this.unlimitedTalk = unlimitedTalk;
    }

    public void setUnlimitedIntText(boolean unlimitedIntText) {
        this.unlimitedIntText = unlimitedIntText;
    }

    public void setUnlimitedIntTalk(boolean unlimitedIntTalk) {
        this.unlimitedIntTalk = unlimitedIntTalk;
    }

    public void setAutoRenewal(boolean autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    public void setPrimarySubscription(boolean primarySubscription) {
        this.primarySubscription = primarySubscription;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
