package com.manabaware.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "services")
@Getter
@Setter
public class Service {

    // ENCAPSULAMIENTO
    // Atributos de la clase Service
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Modificador de acceso en privado. Quiere decir que solo se puede acceder a
                     // este atributo desde dentro de la clase Service.

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    private String icon;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}