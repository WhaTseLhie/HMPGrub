package com.example.jayvee.hmpgrub;

public class Customer {

    String customer_id, customer_fname, customer_lname, customer_gender, customer_bday, customer_email, customer_contact, customer_username, customer_password, cust_state;

    public Customer(String customer_id, String customer_fname, String customer_lname, String customer_gender, String customer_bday, String customer_email, String customer_contact, String customer_username, String customer_password, String cust_state) {
        this.customer_id = customer_id;
        this.customer_fname = customer_fname;
        this.customer_lname = customer_lname;
        this.customer_gender = customer_gender;
        this.customer_bday = customer_bday;
        this.customer_email = customer_email;
        this.customer_contact = customer_contact;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
        this.cust_state = cust_state;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_fname() {
        return customer_fname;
    }

    public void setCustomer_fname(String customer_fname) {
        this.customer_fname = customer_fname;
    }

    public String getCustomer_lname() {
        return customer_lname;
    }

    public void setCustomer_lname(String customer_lname) {
        this.customer_lname = customer_lname;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_bday() {
        return customer_bday;
    }

    public void setCustomer_bday(String customer_bday) {
        this.customer_bday = customer_bday;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCust_state() {
        return cust_state;
    }

    public void setCust_state(String cust_state) {
        this.cust_state = cust_state;
    }
}
