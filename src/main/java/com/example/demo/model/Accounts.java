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
    @Column(name = "user_id")
    private Integer id;

    Integer number;
    Integer balance;

}
