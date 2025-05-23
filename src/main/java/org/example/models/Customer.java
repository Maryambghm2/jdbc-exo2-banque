package org.example.models;

public class Customer {
    private int id;
    private String lastname;
    private String firstname;
    private String phone;

    public Customer() {

    }

    public Customer(int id, String lastname, String firstname, String phone) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
