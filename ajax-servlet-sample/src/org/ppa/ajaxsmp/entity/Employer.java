package org.ppa.ajaxsmp.entity;

import java.io.Serializable;

/**
 * 従業員エンティティ
 */
public class Employer implements Serializable {
    private String id;
    private String firstName;
    private String familyName;
    private java.util.Date since;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFamilyName() {
        return familyName;
    }
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public java.util.Date getSince() {
        return since;
    }
    public void setSince(java.util.Date since) {
        this.since = since;
    }
}
