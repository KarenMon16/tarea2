package org.example.domain.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {
    @Id
    @SequenceGenerator(name = "rol_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rol_sequence")
    private Integer id;
    private String name;
}
