package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "sales_area", schema = "dbo", indexes = {
        @Index(name = "IX_sales_area_dims", columnList = "market, channel, sales_org, division", unique = true)
})
@Access(AccessType.FIELD)
public class SalesArea {
    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 32)
    private String market;

    @Column(length = 32)
    private String channel;

    @Column(name="sales_org", length = 32)
    private String salesOrg;

    @Column(length = 32)
    private String division;

    public SalesArea() {
    }

    public SalesArea(String market, String channel, String salesOrg, String division) {
        this.market = market;
        this.channel = channel;
        this.salesOrg = salesOrg;
        this.division = division;
    }

    public SalesArea(UUID id, String market, String channel, String salesOrg, String division) {
        this.id = id;
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

    public void setMarket(String market) {
        this.market = market;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof SalesArea salesArea)) return false;
        return Objects.equals(id, salesArea.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
