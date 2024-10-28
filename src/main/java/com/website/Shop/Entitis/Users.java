package com.website.Shop.Entitis;

import jakarta.validation.constraints.Pattern;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long user_id;

    @Column(name="user_password", nullable = false)
    private String userPassword;

    @Column(name="user_email", length=50, nullable=false, unique=true)
    @Pattern(regexp = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", message = "Must be a valid e-mail address")
    private String userEmail;

    @Column(name="user_first_name", length=50, nullable=false, unique=false)
    private String userFirstName;

    @Column(name="user_last_name", length=50, nullable=false, unique=false)
    private String userLastName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;
}
