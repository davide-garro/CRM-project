package com.davidev.account;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;


@Entity
@Table(
        name = "size",
        schema = "dbo",
        indexes = {
                @Index(name = "IX_size_lbl_rng_seg", columnList = "label,[range],segment")
        }
)
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 20, name = "[range]", nullable = false)
    private String range;

    @Column(length = 32, nullable = false)
    private String label;

    @Column(length = 32, nullable = false)
    private String segment;

    public Size() {
    }

    public Size(String range, String label, String segment) {
        this.range = range;
        this.label = label;
        this.segment = segment;
    }

    public Size(UUID id, String range, String label, String segment) {
        this.id = id;
        this.range = range;
        this.label = label;
        this.segment = segment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Size size)) return false;
        return Objects.equals(id, size.id) && Objects.equals(range, size.range) && Objects.equals(label, size.label) && Objects.equals(segment, size.segment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, range, label, segment);
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