/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volunteers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrei
 */
@XmlRootElement
public class Volunteer {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String zip;
    private String city;
    private String phone;
    private String email;
    private String birthday;
    private String about;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public static final String ID = "id",
            FNAME = "FirstName",
            LNAME = "LastName",
            ADDRESS = "Address",
            ZIP = "Zip",
            CITY = "City",
            PHONE = "Phone",
            EMAIL = "Email",
            BIRTHDAY = "Birthday",
            ABOUT = "About";

    public Volunteer(int id, String firstName, String lastName, String address, 
            String zip, String city, String phone, String email, 
            String birthday, String about) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.about = about;
    }

    public Volunteer() {
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }
    
    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }
    
    @XmlElement
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }
    
    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }
    
    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }
    
    @XmlElement
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public String toString() {
        return "Vontuneer ID: =" + this.id
                + "\t\t\tFirst Name: = " + this.firstName
                + "\t\t\tLast Name: = " + this.lastName
                + "\t\t\tAddress: = " + this.address
                + "\t\t\tZIP: = " + this.zip
                + "\t\t\tCity: = " + this.city
                + "\t\t\tPhone Number: = " + this.phone
                + "\t\t\tEmail: = " + this.email
                + "\t\t\tBirthday: = " + this.birthday
                + "\t\t\tAbout: = " + this.about;
    }
}
