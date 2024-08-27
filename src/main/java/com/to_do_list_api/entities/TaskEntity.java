package com.to_do_list_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la tarea no puede estar vacío.")
    @Size(max = 60, message = "El nombre no puede tener más de 60 caracteres.")
    @Column(length = 60, nullable = false)
    private String name;

    @Size(max = 150, message = "La descripción no puede tener más de 150 caracteres.")
    @Column(length = 150)
    private String description;

    @NotNull(message = "La fecha límite no puede estar vacía.")
    @Column(nullable = false)
    private LocalDateTime limitDate;

    @Column(nullable = false)
    private boolean important = false;

    @Column(nullable = false)
    private boolean done = false;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt = null;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
