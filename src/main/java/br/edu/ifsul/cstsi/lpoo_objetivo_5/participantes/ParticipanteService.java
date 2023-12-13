package br.edu.ifsul.cstsi.lpoo_objetivo_5.participantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository rep;

    public List<Participante> getParticipantes() {
        return rep.findAll();
    }

    public Participante getParticipanteById(Long id) {
        Optional<Participante> optional = rep.findById(id);
        return optional.orElse(null);
    }


    public List<Participante> getParticipantesByNome(String nome) {
        return new ArrayList<>(rep.findByNome(nome + "%"));
    }

    public List<Participante> getParticipantesByLogin(String login) {
        return new ArrayList<>(rep.findByLogin(login + "%"));
    }

    public Participante insert(Participante participante) {
        Assert.isNull(participante.getId(),"Não foi possível inserir o registro");
        return rep.save(participante);
    }

    public Participante update(Participante participante) {
        Assert.notNull(participante.getId(),"Não foi possível atualizar o registro");


        Optional<Participante> optional = rep.findById(participante.getId());
        if(optional.isPresent()) {
            Participante db = optional.get();
            db.setNome(participante.getNome());
            db.setLogin(participante.getLogin());
            db.setSenha(participante.getSenha());
            db.setEmail(participante.getEmail());
            db.setEndereco(participante.getEndereco());
            db.setTelefone(participante.getTelefone());
            rep.save(db);

            return db;
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}
