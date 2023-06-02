package com.udeshika.models;

import java.util.List;

public class Person {
    private String socialSecurityNumber;
    private String name;
    private String spouse;
    private List<Child> children;

    public Person(String socialSecurityNumber, String name, String spouse, List<Child> children) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.name = name;
        this.spouse = spouse;
        this.children = children;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

    public String getSpouse() {
        return spouse;
    }

    public List<Child> getChildren() {
        return children;
    }
}
