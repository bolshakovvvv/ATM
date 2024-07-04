package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

    @Id
    private Integer id;

    @Column(name = "balance")
    private int balance;

    @Column(name = "number")
    private int number;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Users user;
}
