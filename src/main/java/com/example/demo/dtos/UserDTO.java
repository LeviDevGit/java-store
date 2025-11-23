package com.example.demo.dtos;

import com.example.demo.entities.User;

public class UserDTO {

    Long id;
    String nome;
    Integer idade;

    public UserDTO() {

    }

    public UserDTO(Long id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.idade = entity.getIdade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
