package br.edu.ifsul.cstsi.lpoo_objetivo_5.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "Leilao")
@Table(name = "leiloes")
public class Leilao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dt_inicio;

    private LocalTime hor_inicio;

    private LocalDate dt_final;

    private LocalTime hor_final;


   @OneToMany(mappedBy = "leilao")
    private List<Item_Leilao> item_leilao;

    public Leilao() {
    }

    public Leilao(LocalDate dt_inicio, LocalTime hor_inicio, LocalDate dt_final, LocalTime hor_final, List<Item_Leilao> item_leilao) {
        this.dt_inicio = dt_inicio;
        this.hor_inicio = hor_inicio;
        this.dt_final = dt_final;
        this.hor_final = hor_final;
        this.item_leilao = item_leilao;
    }

    public LocalDate getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(LocalDate dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public LocalTime getHor_inicio() {
        return hor_inicio;
    }

    public void setHor_inicio(LocalTime hor_inicio) {
        this.hor_inicio = hor_inicio;
    }

    public LocalDate getDt_final() {
        return dt_final;
    }

    public void setDt_final(LocalDate dt_final) {
        this.dt_final = dt_final;
    }

    public LocalTime getHor_final() {
        return hor_final;
    }

    public void setHor_final(LocalTime hor_final) {
        this.hor_final = hor_final;
    }

    public List<Item_Leilao> getItem_leilao() {
        return item_leilao;
    }

    public void setItem_leilao(List<Item_Leilao> item_leilao) {
        this.item_leilao = item_leilao;
    }


    @Override
    public String toString() {
        return "\nLeilao{" +
                "id=" + id +
                ", dt_inicio=" + dt_inicio +
                ", hor_inicio=" + hor_inicio +
                ", dt_final=" + dt_final +
                ", hor_final=" + hor_final +
                ", item_leilao=" + item_leilao +
                '}';
    }
}
