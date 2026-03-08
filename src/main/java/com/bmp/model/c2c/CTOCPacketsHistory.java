package com.bmp.model.c2c;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CTOCPacketsHistory {
    private String statusId;
    private String name;
    private String location;
    private String activity;
    private String date;
    private String dateValue;
    private String clubMemberUserId;
    private String deliveryBoyMobileNo;
    public String getDeliveryBoyMobileNo() {
        return deliveryBoyMobileNo;
    }
    public void setDeliveryBoyMobileNo(final String deliveryBoyMobileNo) {
        this.deliveryBoyMobileNo = deliveryBoyMobileNo;
    }
    public String getName() {
        return name;
    }
    public String getClubMemberUserId() {
        return clubMemberUserId;
    }

    public void setClubMemberUserId(final String clubMemberUserId) {
        this.clubMemberUserId = clubMemberUserId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(final String activity) {
        this.activity = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @return the statusId
     */
    public String getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(final String statusId) {
        this.statusId = statusId;
    }

    /**
     * @return the dateValue_i
     */
    public String getDateValue_i() {
        return dateValue;
    }

    /**
     * @param dateValue_i the dateValue_i to set
     */
    public void setDateValue_i(final String dateValue) {
        this.dateValue = dateValue;
    }

}
