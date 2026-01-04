package com.securebiz.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="business_data")
@Getter@Setter
public class BusinessData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;
    private Double amount;

    @ManyToOne
    @JoinColumn(name ="created_by")

    private User createdBy;

    private LocalDateTime createdAt = LocalDateTime.now();
}
