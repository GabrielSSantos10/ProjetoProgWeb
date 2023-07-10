package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.bo.PartidaBO;
import br.edu.ifg.luziania.model.bo.UsuarioBO;
import br.edu.ifg.luziania.model.dto.PartidaDTO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import br.edu.ifg.luziania.model.util.ErroTemplates;
import br.edu.ifg.luziania.model.util.Sessao;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("partida")
public class PartidaController {
    @Inject
    Sessao sessao;

    @Inject
    PartidaBO partidaBO;

    private final Template partida;

    public PartidaController(Template partida) {
        this.partida = partida;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance partida(){
        if (sessao.getUsuario().isEmpty())
            return ErroTemplates.acessoNegado();
        return partida.instance();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("salvarPartida")
    public Response salvarPartida(PartidaDTO dto){
        RespostaDTO respostaDTO = partidaBO.salvarPartida(dto);

        return Response
                .status(respostaDTO.getStatus())
                .entity(respostaDTO)
                .build();
    }
}

//    private final Template historicoPartidas;

//    public PartidaController(Template partida, Template historicoPartidas) {
//        this.partida = partida;
//        this.historicoPartidas = historicoPartidas;
//    }

//    @GET
//    @Path("historico")
//    @Produces(MediaType.TEXT_HTML)
//    public TemplateInstance historicoPartidas(){
//        if (sessao.getUsuario().isEmpty())
//            return ErroTemplates.acessoNegado();
////        List<PartidaHistoricoDTO> historicos = historicoBO.getHistoricos(){
////          List<PartidaHistoricoDTO> historicoPartida = dao.getHistoricos(from HistoricoPartida)
////        };
////        return historicoPartidas.data("historicos", historicos);
//        return historicoPartidas.instance();
//    }

