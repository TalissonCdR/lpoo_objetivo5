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
}
