package br.edu.ifsul.cstsi.lpoo_objetivo_5.model;


import jakarta.persistence.*;

import java.util.List;

@Entity (name = "Participante")
@Table (name = "participantes")
public class Participante {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name = "nome_participantes", nullable = false)
    private String nome;
   @Column(name = "login_participantes", nullable = false, unique = true)
    private String login;

   @Column(name = "senha_participantes", nullable = false)
    private String senha;
   @Column(name = "email_participantes", nullable = false, unique = true)
    private String email;

    @Column(name = "endereco_participantes")
    private String endereco;

    @Column(name = "telefone_participantes")
    private String telefone;

    @OneToMany(mappedBy = "participante")
    private List<Lance> lances;

    public Participante() {
    }

    public Participante(String nome, String login, String senha, String email, String endereco, String telefone, List<Lance> lances) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.lances = lances;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }


    @Override
    public String toString() {
        return "\nParticipante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", lances=" + lances +
                '}';
    }
}
