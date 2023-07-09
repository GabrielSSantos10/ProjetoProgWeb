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
@Path("historicoPartidas")
public class HistoricoController {
    @Inject
    Sessao sessao;

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
}
