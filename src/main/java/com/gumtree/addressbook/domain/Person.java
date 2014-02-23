package com.gumtree.addressbook.domain;

import java.util.Date;

/**
 * Person domain.
 *
 * @author Krzysztof Kachel
 */
public class Person {

    private String name;

    private Gender gender;

    private Date birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}