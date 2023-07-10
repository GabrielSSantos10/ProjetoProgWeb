package br.edu.ifg.luziania.model.bo;

import br.edu.ifg.luziania.model.dao.PartidaDAO;
import br.edu.ifg.luziania.model.dto.PartidaDTO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.entity.Partida;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import java.util.List;

import static java.util.Objects.nonNull;

@Dependent
public class PartidaBO {

    @Inject
    PartidaDAO partidaDAO;

    public Response listarAll(PartidaDTO dto){
        RespostaDTO respostaDTO = new RespostaDTO();

        if (nonNull(dto)){
            List<Partida> partida = partidaDAO.getAllPartidas();
            if (nonNull(partida)) {
                return Response.ok(respostaDTO).build();
            }
            else {
                return Response.status(Response.Status.NOT_FOUND).entity(respostaDTO).build();
            }

        }else {
            return Response.status(Response.Status.BAD_REQUEST).entity(respostaDTO).build();
        }
    }

    @Transactional
    public RespostaDTO salvarPartida(PartidaDTO dto) {

        RespostaDTO respostaDTO = new RespostaDTO();

        Partida entity = new Partida();

        entity.setNomeJogador1Time1(dto.getNomeJogador1Time1());
        entity.setNomeJogador2Time1(dto.getNomeJogador2Time1());
        entity.setNomeJogador3Time1(dto.getNomeJogador3Time1());
        entity.setNomeJogador1Time2(dto.getNomeJogador1Time2());
        entity.setNomeJogador2Time2(dto.getNomeJogador2Time2());
        entity.setNomeJogador3Time2(dto.getNomeJogador3Time2());
        entity.setPontosTime1(dto.getPontosTime1());
        entity.setPontosTime2(dto.getPontosTime2());
        entity.setTimeVencedor(dto.getTimeVencedor());


        try {
            partidaDAO.save(entity);
            respostaDTO.setStatus(200);
            respostaDTO.setMensagem("Partida salva com sucesso!");
        }catch (Exception e){
            respostaDTO.setStatus(500);
            respostaDTO.setMensagem("Falha ao salvar partida!");
        }

        return respostaDTO;
    }
}
