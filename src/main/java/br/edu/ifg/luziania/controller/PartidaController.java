package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.util.ErroTemplates;
import br.edu.ifg.luziania.model.util.Sessao;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
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
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance partida(){
//        if (sessao.getUsuario().isEmpty())
//            return ErroTemplates.proibido();
        return partida.instance();
    }
}
