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

    public Item_Leilao() {
    }

    public Item_Leilao(String titulo, String descricao, double lance_minimo, String caminho_foto, int arrematado, List<Lance> lances, Leilao leilao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.lance_minimo = lance_minimo;
        this.caminho_foto = caminho_foto;
        this.arrematado = arrematado;
        this.lances = lances;
        this.leilao = leilao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getLance_minimo() {
        return lance_minimo;
    }

    public void setLance_minimo(double lance_minimo) {
        this.lance_minimo = lance_minimo;
    }

    public String getCaminho_foto() {
        return caminho_foto;
    }

    public void setCaminho_foto(String caminho_foto) {
        this.caminho_foto = caminho_foto;
    }

    public int getArrematado() {
        return arrematado;
    }

    public void setArrematado(int arrematado) {
        this.arrematado = arrematado;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }


    @Override
    public String toString() {
        return "\nItem_Leilao{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", lance_minimo=" + lance_minimo +
                ", caminho_foto='" + caminho_foto + '\'' +
                ", arrematado=" + arrematado +
                ", lances=" + lances +
                ", leilao=" + leilao +
                '}';
    }
}
