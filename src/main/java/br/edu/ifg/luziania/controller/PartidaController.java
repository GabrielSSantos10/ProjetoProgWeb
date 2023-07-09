package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.util.ErroTemplates;
import br.edu.ifg.luziania.model.util.Sessao;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("partida")
public class PartidaController {
    @Inject
    Sessao sessao;

    private final Template partida;

    public PartidaController(Template partida) {
        this.partida = partida;
    }

//    private final Template historicoPartidas;

//    public PartidaController(Template partida, Template historicoPartidas) {
//        this.partida = partida;
//        this.historicoPartidas = historicoPartidas;
//    }
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance partida(){
        if (sessao.getUsuario().isEmpty())
            return ErroTemplates.acessoNegado();
        return partida.instance();
    }

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
}
