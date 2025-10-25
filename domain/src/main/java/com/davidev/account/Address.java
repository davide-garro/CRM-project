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
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
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

    protected Address() {
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

    public String getAttention() {
        return attention;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getStateRegion() {
        return stateRegion;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Country getCountry() {
        return country;
    }

    /*The address fields are all required and cannot be null, but validation is performed on payload reception, no null shall reach the persistence*/
    /*The equals allows to safely compare object coming from the hibernate proxy, without fetching the whole referenced entity*/
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (Address) object;
        if(this.id != null && that.id != null){
            return Objects.equals(this.id, that.id);
        }
        return proxySafeAddressEquals(this.addressType,that.addressType) && Objects.equals(n(this.street), n(that.street)) && Objects.equals(n(this.city), n(that.city)) && Objects.equals(n(this.stateRegion),n(that.stateRegion)) && Objects.equals(n(this.zipcode), n(that.zipcode)) && proxySafeCountryEquals(this.country, that.country);
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode():Objects.hash(
                idof(this.addressType),
                n(this.street),
                n(this.city),
                n(this.stateRegion),
                n(this.zipcode),
                idof(this.country)
        );
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressType=" + (addressType != null ? addressType.getId() : null) +
                ", attention='" + attention + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", stateRegion='" + stateRegion + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", country=" + ((country!= null) ?country.getId(): null) +
                '}';
    }

    private static boolean proxySafeAddressEquals(AddressType addressType1, AddressType addressType2){
        return Objects.equals(addressType1 != null ? addressType1.getId() : null, addressType2 != null ? addressType2.getId() : null);
    }

    private static boolean proxySafeCountryEquals(Country country1, Country country2){
        return Objects.equals(country1 != null ? country1.getId() : null, country2 != null ? country2.getId() : null);
    }
    private static UUID idof(Object o){
        if(o == null){
            return null;
        }
        if(o instanceof org.hibernate.proxy.HibernateProxy p){
            return (UUID) p.getHibernateLazyInitializer().getIdentifier();
        }
        if(o instanceof AddressType) {
            return ((AddressType) o).getId();
        }
        if(o instanceof Country){
            return ((Country) o).getId();
        }
        throw new IllegalArgumentException("Invalid Object type supplied to helper: accepted types: AddressType, Country");
    }
}