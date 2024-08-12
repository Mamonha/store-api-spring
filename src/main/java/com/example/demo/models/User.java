package com.example.demo.models;

import com.example.demo.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String nome;
    protected String email;
    protected String descricao;
    protected String telefone;
    protected Integer idade;
    protected String endereco;
    @Column(nullable = true)
    protected String funcao;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    protected UserType userType;

    public User(UserType userType, Integer idade, String nome, Long id, String email, String descricao, String telefone, String funcao, String endereco) {
        this.userType = userType;
        this.idade = idade;
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.descricao = descricao;
        this.telefone = telefone;
        this.funcao = funcao;
        this.endereco = endereco;
    }
}
