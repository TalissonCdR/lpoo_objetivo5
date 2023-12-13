package br.edu.ifsul.cstsi.lpoo_objetivo_5.Leilao;

import br.edu.ifsul.cstsi.lpoo_objetivo_5.model.Item_Leilao;
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

}
