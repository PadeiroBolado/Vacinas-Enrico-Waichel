package service;

import java.util.List;

import exception.VacinasException;
import model.entity.Pessoa;
import model.repository.PessoaRepository;
import model.entity.Vacinacao;
import model.repository.VacinacaoRepository;

public class PessoaService {
	private PessoaRepository repository = new PessoaRepository();
	
	public Pessoa salvar(Pessoa novaPessoa){
		return repository.salvar(novaPessoa);
	}

	public boolean atualizar(Pessoa pessoaEditada) {
		return repository.alterar(pessoaEditada);
	}

	public boolean excluir(int id) throws VacinasException {
		
		return repository.excluir(id);
	}

	public Pessoa consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

	public List<Pessoa> consultarTodas() {
		return repository.consultarTodos();
	}
}
