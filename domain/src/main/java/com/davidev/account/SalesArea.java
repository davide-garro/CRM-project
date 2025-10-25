package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

import static com.davidev.util.Util.n;

@Entity
@Table(name = "sales_area", schema = "dbo", indexes = {
        @Index(name = "IX_sales_area_dims", columnList = "market, channel, sales_org, division", unique = true)
})
@Access(AccessType.FIELD)
public class SalesArea {
    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 32)
    private String market;

    @Column(length = 32)
    private String channel;

    @Column(name="sales_org", length = 32)
    private String salesOrg;

    @Column(length = 32)
    private String division;

    protected SalesArea() {
    }

    public SalesArea(String market, String channel, String salesOrg, String division) {
        this.market = market;
        this.channel = channel;
        this.salesOrg = salesOrg;
        this.division = division;
    }

    public UUID getId() {
        return id;
    }

    public String getMarket() {
        return market;
    }

    public String getChannel() {
        return channel;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public String getDivision() {
        return division;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (SalesArea) object;
        if(this.id != null && that.id != null){
            return Objects.equals(this.id,that.id);
        }
        return Objects.equals(n(this.market), n(that.market)) && Objects.equals(n(this.channel),n(that.channel)) && Objects.equals(n(this.salesOrg),n(that.salesOrg)) && Objects.equals(n(this.division),n(that.division));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hash(n(this.market), n(this.channel), n(this.salesOrg), n(this.division));
    }

    @Override
    public String toString() {
        return "SalesArea{" +
                "id=" + id +
                ", market='" + market + '\'' +
                ", channel='" + channel + '\'' +
                ", salesOrg='" + salesOrg + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
