package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Pessoa;
import service.PessoaService;
import exception.VacinasException;

@Path("/pessoa")	
public class PessoaController {
	
	private PessoaService service = new PessoaService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa salvar(Pessoa novaPessoa) throws VacinasException {
		 return service.salvar(novaPessoa);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean atualizar(Pessoa pessoaEditada) throws VacinasException {
		 return service.atualizar(pessoaEditada);
	}
	
	@DELETE
	@Path("/{id}")
	public boolean excluir(@PathParam("id") int id){
		 return service.excluir(id);
	}
	
	@GET
	@Path("/{id}")
	public Pessoa consultarPorId(@PathParam("id") int id){
		 return service.consultarPorId(id);
	}
	
	@GET
	@Path("/todas")
	public List<Pessoa> consultarTodas(){
		 return service.consultarTodas();
	}
	
	//Apenas para testes
//	@GET
//	@Path("/sortear")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArrayList<Carta> sortear(){
//		return service.sortearSeisCartas();
//	}
}