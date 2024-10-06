package ru.pickme.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    @NotEmpty(message = "please provide a username")
    @Size(min = 2,max = 20,message="username should be greater than 2 and less than 20")

    private String username;

    @Column(name="password")
    @NotEmpty(message = "please provide a password")
    private String password;

    @Column(name="email")
    @NotEmpty(message = "please provide a email")
    private String email;

    @Column(name="phone_number")
    @NotEmpty(message = "please provide a phone number")
    private String phone_number;

    public User(String username, String password){
        this.username=username;
        this.password=password;
    }

}
