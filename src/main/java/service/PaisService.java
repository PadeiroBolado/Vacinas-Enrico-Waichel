package service;

import exception.VacinasException;
import model.entity.Pais;
import model.repository.PaisRepository;

public class PaisService {

	private PaisRepository repository = new PaisRepository();
	
	public Pais salvar(Pais novo) throws VacinasException {
		return repository.salvar(novo);
	}
	
	public Pais consultarPorId(int id) {
		return repository.consultarPorId(id);
	}
}
