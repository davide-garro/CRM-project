package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

import static com.davidev.util.Util.n;

@Entity
@Table(name = "address", schema = "dbo")
@Access(AccessType.FIELD)
public class Address {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false)
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

    /*The address fields are all required and cannot be null, but validation is performed on payload reception, no null shall reach the persistence*/
    /*The equals allows to safely compare object coming from the hibernate proxy, without fetching the whole referenced entity*/
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Address that)) return false;
        if(this.id != null && that.id != null){
            return Objects.equals(id, that.id);
        }
        return proxySafeAddressEquals(this.addressType,that.addressType) && Objects.equals(n(this.attention),n(that.attention)) && Objects.equals(n(this.street), n(that.street)) && Objects.equals(n(this.city), n(that.city)) && proxySafeCountryEquals(this.country, that.country) && Objects.equals(n(this.stateRegion),n(that.stateRegion)) && Objects.equals(n(this.zipcode), n(that.zipcode));
    }

    @Override
    public int hashCode() {
        if(this.id != null){
            return Objects.hash(id);
        }
        return Objects.hash(n(this.street), n(this.city), n(this.stateRegion), n(this.zipcode));
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

    private static boolean proxySafeAddressEquals(AddressType addressType1, AddressType addressType2){
        return Objects.equals(addressType1 != null ? addressType1.getId() : null, addressType2 != null ? addressType2.getId() : null);
    }

    private static boolean proxySafeCountryEquals(Country country1, Country country2){
        return Objects.equals(country1 != null ? country1.getId() : null, country2 != null ? country2.getId() : null);
    }
}
