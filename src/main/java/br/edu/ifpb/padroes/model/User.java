package br.edu.ifpb.padroes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "*Forneça um E-mail válido")
    @NotEmpty(message = "*Forneça um E-mail")
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "*Senha deve ter ao menos 5 caracteres")
    @NotEmpty(message = "*Forneça uma senha")
    @JsonIgnore
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 5, message = "*Nome de usuário deve ter ao menos 5 caracteres")
    @NotEmpty(message = "*Forneça seu nome de usuário")
    private String username;

    @Column(name = "name")
    @NotEmpty(message = "*Forneça seu primeiro nome")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "*Forneça seu último nome")
    private String lastName;

    @Column(name = "active", nullable = false)
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
