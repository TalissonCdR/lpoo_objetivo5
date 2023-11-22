package br.edu.ifsul.cstsi.lpoo_objetivo_5.model;

import jakarta.persistence.*;

import java.util.List;


@Entity(name = "Item_Leilao")
@Table(name = "itens_leilao")
public class Item_Leilao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_item")
    private String titulo;

    @Column(name = "descricao_item")
    private String descricao;

    @Column(name = "lance_minimo_item")
    private double lance_minimo;

    @Column(name = "caminho_foto_item")
    private String caminho_foto;

    @Column(name = "arrematado_item")
    private int arrematado;

    @OneToMany(mappedBy = "item_leilao")
    private List<Lance> lances;

    @ManyToOne
    @JoinColumn(name = "leilao_id", referencedColumnName = "id")
    private Leilao leilao;
}
