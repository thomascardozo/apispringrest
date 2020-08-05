package com.softdesing.api.service;

import java.util.List;

import com.softdesing.api.model.Aluguel;

public interface AluguelService {

	List<Aluguel> listarTodosAlugueis();
	
	Aluguel listarPorIdAluguel(String id);
	
	Aluguel cadastrarAluguel(Aluguel aluguel);
	
	Aluguel devolverAluguel(Aluguel aluguel);
	
	Aluguel atualizarAluguel(Aluguel aluguel);
	
	void removerAluguel(String id);
}
