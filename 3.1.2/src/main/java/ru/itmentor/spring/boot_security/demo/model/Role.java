package ru.itmentor.spring.boot_security.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String role;

    public Role(String name) {
        this.role = name;
    }

    @Override
    public String getAuthority() {
        return this.getName();
    }

    public String getName() {
        return role;
    }

}
