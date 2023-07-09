package br.edu.ifg.luziania.model.bo;

import br.edu.ifg.luziania.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.model.dto.AutenticacaoDTO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import br.edu.ifg.luziania.model.entity.Usuario;
import br.edu.ifg.luziania.model.util.Sessao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import static java.util.Objects.nonNull;

@Dependent
public class UsuarioBO {

    @Inject
    Sessao sessao;

    @Inject
    UsuarioDAO usuarioDAO;

    public Response autenticar(AutenticacaoDTO autenticacaoDTO){
        RespostaDTO respostaDTO = new RespostaDTO();

        if (nonNull(autenticacaoDTO)){
            Usuario usuario = usuarioDAO.getByEmailAndSenha(autenticacaoDTO.getEmail(), autenticacaoDTO.getSenha());
            if (nonNull(usuario)) {
                sessao.setUsuario(usuario.getNome());
                respostaDTO.setMensagem("Bem vindo "+usuario.getNome()+"!");
                respostaDTO.setStatus(200);
                respostaDTO.setUrl("/principal");
                return Response.ok(respostaDTO).build();
            }
            else {
                respostaDTO.setMensagem("Usuário não encontrado!");
                respostaDTO.setUrl("/erro/acesso-negado");
                return Response.status(Response.Status.NOT_FOUND).entity(respostaDTO).build();
            }

        }else {
            respostaDTO.setMensagem("Dados obrigatórios não presentes!");
            respostaDTO.setUrl("/erro/acesso-negado");
            return Response.status(Response.Status.BAD_REQUEST).entity(respostaDTO).build();
        }
    }
    public Response deslogar(){
        RespostaDTO respostaDTO = new RespostaDTO();
        sessao.clearSession();
        if(!nonNull(sessao.getUsuario())) {
            respostaDTO.setMensagem("Deslogado com sucesso");
            respostaDTO.setStatus(200);
            respostaDTO.setUrl("/");
            return Response.ok(respostaDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Opss! houve um erro no servidor, não foi possivel deslogar, tente novamente mais tarde.").build();
        }
    }

    @Transactional
    public RespostaDTO salvar(UsuarioDTO dto) {

        RespostaDTO respostaDTO = new RespostaDTO();

        Usuario entity = new Usuario();

        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setSenha(dto.getSenha());

        try {
            usuarioDAO.save(entity);
            sessao.setUsuario(entity.getNome());
            respostaDTO.setStatus(200);
            respostaDTO.setMensagem("Usuário salvo com sucesso!");
            respostaDTO.setUrl("/principal");
        }catch (Exception e){
            respostaDTO.setStatus(500);
            respostaDTO.setMensagem("Falha ao salvar usuário!");
            respostaDTO.setUrl("/");
        }

        return respostaDTO;
    }
}
