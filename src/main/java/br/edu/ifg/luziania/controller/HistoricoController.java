package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.bo.PartidaBO;
import br.edu.ifg.luziania.model.dao.PartidaDAO;
import br.edu.ifg.luziania.model.entity.Partida;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.PartidaDTO;
import br.edu.ifg.luziania.model.util.ErroTemplates;
import br.edu.ifg.luziania.model.util.Sessao;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("historicoPartidas")
public class HistoricoController {
    @Inject
    Sessao sessao;

//    @Inject
//    PartidaBO partidaBO;
//    @Inject
//    PartidaDTO partidaDTO;
//    @Inject
//    PartidaDTO partidaDAO;
    private final Template historicoPartidas;

    public HistoricoController(Template historicoPartidas) {
        this.historicoPartidas = historicoPartidas;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance historicoPartidas(){
        if (sessao.getUsuario().isEmpty())
            return ErroTemplates.acessoNegado();
        return historicoPartidas.instance();
    }

//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    @Scheduled
//    @Path("gerarHistorico/teste2")
//    public TemplateInstance historicoPartidas(){
////        List<PartidaBO> partidas = partidaBO.listarAll(partidaDTO);
////        if (sessao.getUsuario().isEmpty())
////            return ErroTemplates.acessoNegado();
//        return historicoPartidas.data(partidaBO.listarAll(partidaDTO));
//    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Scheduled
//    @Path("gerarHistorico/teste")
//    public Response listarAll(PartidaDTO dto){
//        Response respostaDTO = partidaBO.listarAll(dto);
//
//        return Response
//                .status(respostaDTO.getStatus())
//                .entity(respostaDTO)
//                .build();
//    }
}
