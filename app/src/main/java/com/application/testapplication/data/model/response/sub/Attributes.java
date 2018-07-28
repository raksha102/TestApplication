package com.application.testapplication.data.model.response.sub;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("payment-type")
    @Expose
    private String paymentType;
    @SerializedName("unbilled-charges")
    @Expose
    private Object unbilledCharges;
    @SerializedName("next-billing-date")
    @Expose
    private Object nextBillingDate;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("first-name")
    @Expose
    private String firstName;
    @SerializedName("last-name")
    @Expose
    private String lastName;
    @SerializedName("date-of-birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("contact-number")
    @Expose
    private String contactNumber;
    @SerializedName("email-address")
    @Expose
    private String emailAddress;
    @SerializedName("email-address-verified")
    @Expose
    private Boolean emailAddressVerified;
    @SerializedName("email-subscription-status")
    @Expose
    private Boolean emailSubscriptionStatus;
    @SerializedName("msn")
    @Expose
    private String msn;
    @SerializedName("credit")
    @Expose
    private Integer credit;
    @SerializedName("credit-expiry")
    @Expose
    private String creditExpiry;
    @SerializedName("data-usage-threshold")
    @Expose
    private Boolean dataUsageThreshold;
    @SerializedName("included-data-balance")
    @Expose
    private Integer includedDataBalance;
    @SerializedName("included-credit-balance")
    @Expose
    private Object includedCreditBalance;
    @SerializedName("included-rollover-credit-balance")
    @Expose
    private Object includedRolloverCreditBalance;
    @SerializedName("included-rollover-data-balance")
    @Expose
    private Object includedRolloverDataBalance;
    @SerializedName("included-international-talk-balance")
    @Expose
    private Object includedInternationalTalkBalance;
    @SerializedName("expiry-date")
    @Expose
    private String expiryDate;
    @SerializedName("auto-renewal")
    @Expose
    private boolean autoRenewal;
    @SerializedName("primary-subscription")
    @Expose
    private boolean primarySubscription;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("included-data")
    @Expose
    private Object includedData;
    @SerializedName("included-credit")
    @Expose
    private Object includedCredit;
    @SerializedName("included-international-talk")
    @Expose
    private Object includedInternationalTalk;
    @SerializedName("unlimited-text")
    @Expose
    private boolean unlimitedText;
    @SerializedName("unlimited-talk")
    @Expose
    private boolean unlimitedTalk;
    @SerializedName("unlimited-international-text")
    @Expose
    private boolean unlimitedInternationalText;
    @SerializedName("unlimited-international-talk")
    @Expose
    private boolean unlimitedInternationalTalk;
    @SerializedName("price")
    @Expose
    private Integer price;

    public String getPaymentType() {
        return paymentType;
    }

    public Object getUnbilledCharges() {
        return unbilledCharges;
    }

    public Object getNextBillingDate() {
        return nextBillingDate;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Boolean getEmailAddressVerified() {
        return emailAddressVerified;
    }

    public Boolean getEmailSubscriptionStatus() {
        return emailSubscriptionStatus;
    }

    public String getMsn() {
        return msn;
    }

    public Integer getCredit() {
        return credit;
    }

    public String getCreditExpiry() {
        return creditExpiry;
    }

    public Boolean getDataUsageThreshold() {
        return dataUsageThreshold;
    }

    public Integer getIncludedDataBalance() {
        return includedDataBalance;
    }

    public Object getIncludedCreditBalance() {
        return includedCreditBalance;
    }

    public Object getIncludedRolloverCreditBalance() {
        return includedRolloverCreditBalance;
    }

    public Object getIncludedRolloverDataBalance() {
        return includedRolloverDataBalance;
    }

    public Object getIncludedInternationalTalkBalance() {
        return includedInternationalTalkBalance;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public boolean getAutoRenewal() {
        return autoRenewal;
    }

    public boolean getPrimarySubscription() {
        return primarySubscription;
    }

    public String getName() {
        return name;
    }

    public Object getIncludedData() {
        return includedData;
    }

    public Object getIncludedCredit() {
        return includedCredit;
    }

    public Object getIncludedInternationalTalk() {
        return includedInternationalTalk;
    }

    public boolean getUnlimitedText() {
        return unlimitedText;
    }

    public boolean getUnlimitedTalk() {
        return unlimitedTalk;
    }

    public boolean getUnlimitedInternationalText() {
        return unlimitedInternationalText;
    }

    public boolean getUnlimitedInternationalTalk() {
        return unlimitedInternationalTalk;
    }

    public Integer getPrice() {
        return price;
    }
}
