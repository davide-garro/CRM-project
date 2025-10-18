package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "address", schema = "dbo")
@Access(AccessType.FIELD)
public class Address {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_type_id", nullable = false)
    private AddressType addressType;

    @Column(length = 100)
    private String attention;

    @Column(length = 200, nullable = false)
    private String street;

    @Column(length = 100, nullable = false)
    private String city;

    @Column(name = "state_region", length = 100, nullable = false)
    private String stateRegion;

    @Column(length = 20, nullable = false)
    private String zipcode;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Address() {
    }

    public Address(AddressType addressType, String attention, String street, String city, String stateRegion, String zipcode, Country country) {
        this.addressType = addressType;
        this.attention = attention;
        this.street = street;
        this.city = city;
        this.stateRegion = stateRegion;
        this.zipcode = zipcode;
        this.country = country;
    }

    public Address(UUID id, AddressType addressType, String attention, String street, String city, String stateRegion, String zipcode, Country country) {
        this.id = id;
        this.addressType = addressType;
        this.attention = attention;
        this.street = street;
        this.city = city;
        this.stateRegion = stateRegion;
        this.zipcode = zipcode;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateRegion() {
        return stateRegion;
    }

    public void setStateRegion(String stateRegion) {
        this.stateRegion = stateRegion;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Address address)) return false;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressType=" + addressType +
                ", attention='" + attention + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", stateRegion='" + stateRegion + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", country=" + country +
                '}';
    }
}
