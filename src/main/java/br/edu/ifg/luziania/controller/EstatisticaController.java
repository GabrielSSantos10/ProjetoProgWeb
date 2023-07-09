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
@Path("estatisticas")
public class EstatisticaController {
    @Inject
    Sessao sessao;

    private final Template estatisticas;

    public EstatisticaController(Template estatisticas) {
        this.estatisticas = estatisticas;
    }
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance estatisticas(){
        if (sessao.getUsuario().isEmpty())
            return ErroTemplates.acessoNegado();
        return estatisticas.instance();
    }
}
