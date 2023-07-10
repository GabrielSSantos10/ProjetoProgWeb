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
@Path("logs")
public class LogsController {
    @Inject
    Sessao sessao;

    private final Template logs;

    public LogsController(Template logs) {
        this.logs = logs;
    }
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance logs(){
        if (sessao.getUsuario().isEmpty())
            return ErroTemplates.acessoNegado();
        return logs.instance();
    }
}