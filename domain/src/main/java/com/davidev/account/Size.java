package com.davidev.account;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;
import static com.davidev.util.Util.n;


@Entity
@Table(name = "size", schema = "dbo", indexes = {
                @Index(name = "IX_size_lbl_rng_seg", columnList = "label,[range],segment")
        }
)
@Access(AccessType.FIELD)
public class Size {

    @Id
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 20, name = "[range]", nullable = false)
    private String range;

    @Column(length = 32, nullable = false)
    private String label;

    @Column(length = 32, nullable = false)
    private String segment;

    protected Size() {
    }

    public Size(String range, String label, String segment) {
        this.range = range;
        this.label = label;
        this.segment = segment;
    }

    public UUID getId() {
        return id;
    }

    public String getRange() {
        return range;
    }

    public String getLabel() {
        return label;
    }

    public String getSegment() {
        return segment;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (Size) object;
        if(this.id != null && that.id != null){
            return Objects.equals(this.id, that.id);
        }
        return Objects.equals(n(this.range), n(that.range)) && Objects.equals(n(this.label), n(that.label)) && Objects.equals(n(this.segment), n(that.segment));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hash(n(this.range), n(this.label), n(this.segment));
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", range='" + range + '\'' +
                ", label='" + label + '\'' +
                ", segment='" + segment + '\'' +
                '}';
    }
}