package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.bo.UsuarioBO;
import br.edu.ifg.luziania.model.dto.AutenticacaoDTO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class AuthenticationController {

    @Inject
    UsuarioBO usuarioBO;

    private final Template login;

    public AuthenticationController(Template login) {
        this.login = login;
    }

    @GET
    public TemplateInstance login(){
        return login.instance();
    }

    @POST
    @Path("autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticar(AutenticacaoDTO autenticacaoDTO){
        return usuarioBO.autenticar(autenticacaoDTO);
    }

    @POST
    @Path("deslogar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deslogar(){
        return usuarioBO.deslogar();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("salvar")
    public Response salvar(UsuarioDTO dto){
        RespostaDTO respostaDTO = usuarioBO.salvar(dto);

        return Response
                .status(respostaDTO.getStatus())
                .entity(respostaDTO)
                .build();
    }
}

