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
@Path("perfis")
public class PerfisController {
    @Inject
    Sessao sessao;

    private final Template perfis;

    public PerfisController(Template perfis) {
        this.perfis = perfis;
    }
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance perfis(){
//        if (sessao.getUsuario().isEmpty())
//            return ErroTemplates.acessoNegado();
        return perfis.instance();
    }
}