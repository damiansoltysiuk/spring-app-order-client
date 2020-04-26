package com.sda.springapporderclient.model;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String description;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public enum RoleEnum {
        USER, SUPERUSER, ADMIN, WRITER, READER
    }

    public Role() {
    }

    public Role(String description, RoleEnum role) {
        this.description = description;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", role=" + role +
                '}';
    }
}
