package com.softdesing.api.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdesing.api.model.Aluguel;
import com.softdesing.api.model.Book;
import com.softdesing.api.repository.AluguelRepository;
import com.softdesing.api.service.AluguelService;

@Service
public class AluguelServiceImpl implements AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;

	@Override
	public List<Aluguel> listarTodosAlugueis() {
		return this.aluguelRepository.findAll();
	}

	@Override
	public Aluguel listarPorIdAluguel(String id) {
		Optional<Aluguel> aluguel = aluguelRepository.findById(id);

		return aluguel.get();
	}

	@Override
	public Aluguel cadastrarAluguel(Aluguel aluguel) {
		return this.aluguelRepository.save(aluguel);
	}

	@Override
	public Aluguel atualizarAluguel(Aluguel aluguel) {
		return this.aluguelRepository.save(aluguel);
	}

	@Override
	public void removerAluguel(String id) {
		this.aluguelRepository.deleteById(id); 
	}

}
