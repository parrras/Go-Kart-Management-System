
package com.GoKart.model;

/**
 *
 * @author DELL
 */
public class model1 {
    private String FullName;
    private short age;
    private String gender;
    private String contact;
    private int kartNo;
    

    public model1() {
    }

    public model1(String FullName, short age, String gender, String contact, int kartNo) {
        this.FullName = FullName;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.kartNo = kartNo;
    }
    
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public short getage() {
        return age;
    }

    public void setage(short age) {
        this.age = age;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getkartNo() {
        return kartNo;
    }

    public void setkartNo(int kartNo) {
        this.kartNo = kartNo;
    }    
}
