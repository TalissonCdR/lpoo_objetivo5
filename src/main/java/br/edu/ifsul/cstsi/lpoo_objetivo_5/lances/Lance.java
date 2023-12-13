package br.edu.ifsul.cstsi.lpoo_objetivo_5.lances;

import br.edu.ifsul.cstsi.lpoo_objetivo_5.model.Item_Leilao;
import br.edu.ifsul.cstsi.lpoo_objetivo_5.participantes.Participante;
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

}
