package com.example.demo.domen;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "person")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "person_rols",joinColumns = @JoinColumn(name = "person_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Collection<Rols> rols;

    public User(String firstName, String lastName,String email, Collection<Rols> rols,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.rols = rols;
        this.password=password;
    }
}
