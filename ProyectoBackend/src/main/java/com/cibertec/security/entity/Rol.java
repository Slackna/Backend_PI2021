package com.cibertec.security.entity;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.cibertec.security.enums.RolNombre;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "rol_nombre")
    private RolNombre rolNombre;

    public Rol() {
    }

    public Rol( RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
