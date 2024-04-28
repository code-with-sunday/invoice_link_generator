package com.sunday.invoice_link_generator.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
@EnableJpaAuditing
public abstract class Base {
    @Id
    @Column(name = "sha_key", length = 64, nullable = false)
    private String shaKey;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base that = (Base) o;
        return Objects.equals(shaKey, that.shaKey);
    }

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (createDate == null) {
            createDate = LocalDateTime.now();
        }
        updateDate = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        return shaKey != null ? shaKey.hashCode() : 0;
    }
}
