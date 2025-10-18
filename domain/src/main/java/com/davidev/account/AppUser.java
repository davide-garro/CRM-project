package com.davidev.account;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "app_user", schema = "dbo")
@Access(AccessType.FIELD)
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(name = "[subject]", nullable = false, unique = true)
    private String subject;

    @Column(length = 254, nullable = false, unique = true)
    private String email;

    @Column(length = 64, nullable = false, unique = true)
    private String username;

    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "[group]", length = 64)
    private String group;

    public AppUser() {
    }

    public AppUser(String subject, String email, String username, String fullName, String firstName, String lastName, String group) {
        this.subject = subject;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public AppUser(UUID id, String subject, String email, String username, String fullName, String firstName, String lastName, String group) {
        this.id = id;
        this.subject = subject;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AppUser appUser)) return false;
        return Objects.equals(id, appUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
