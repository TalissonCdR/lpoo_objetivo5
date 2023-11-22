package br.edu.ifsul.cstsi.lpoo_objetivo_5.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity(name = "Lance")
@Table(name = "lances")
public class Lance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double val_lance;

    private LocalTime hora_lance;

    @ManyToOne
    @JoinColumn(name = "participante_id", referencedColumnName="id")
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "item_leilao_id", referencedColumnName="id")
    private Item_Leilao item_leilao;

    public Lance() {
    }

    public Lance(double val_lance, LocalTime hora_lance, Participante participante, Item_Leilao item_leilao) {
        this.val_lance = val_lance;
        this.hora_lance = hora_lance;
        this.participante = participante;
        this.item_leilao = item_leilao;
    }

    public double getVal_lance() {
        return val_lance;
    }

    public void setVal_lance(double val_lance) {
        this.val_lance = val_lance;
    }

    public LocalTime getHora_lance() {
        return hora_lance;
    }

    public void setHora_lance(LocalTime hora_lance) {
        this.hora_lance = hora_lance;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Item_Leilao getItem_leilao() {
        return item_leilao;
    }

    public void setItem_leilao(Item_Leilao item_leilao) {
        this.item_leilao = item_leilao;
    }


    @Override
    public String toString() {
        return "\nLance{" +
                "id=" + id +
                ", val_lance=" + val_lance +
                ", hora_lance=" + hora_lance +
                ", participante=" + participante +
                ", item_leilao=" + item_leilao +
                '}';
    }
}
