package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.util.ErroTemplates;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("erro")
public class ErrosController {

    @GET
    @Path("acesso-negado")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance acessoNegado() {
        return ErroTemplates.acessoNegado();
    }

}
