package com.softdesing.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.softdesing.api.model.Aluguel;
import com.softdesing.api.model.Book;
import com.softdesing.api.repository.AluguelRepository;
import com.softdesing.api.service.AluguelService;

@RestController
@RequestMapping(path = "/aluguel")
public class AluguelController {

	@Autowired
	private AluguelService aService;

	// Retorna a listagem de todos os livros
	@GetMapping(path = "/findAllAlugueis")
	public ResponseEntity<List<Aluguel>> listarAlugueis() {
		return ResponseEntity.ok(this.aService.listarTodosAlugueis());
	}

	// Retorna aluguel por id
	@GetMapping(path = "/{id}")
	public ResponseEntity<Aluguel> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(this.aService.listarPorIdAluguel(id));
	}

	@PostMapping
	public ResponseEntity<Aluguel> cadastrarAluguel(@RequestBody Aluguel aluguel) {
		if (aluguel.isRented() != true) {
			aluguel.setRented(true);
			aluguel.setDataInicioAluguel(aluguel.getDataInicioAluguel());
			return ResponseEntity.ok(this.aService.cadastrarAluguel(aluguel));
		} else

		{
			System.out.println("Livro alugado. Aguarde a devolução.");
			return null;
		}
	}

	@PostMapping
	public ResponseEntity<Aluguel> devolucaoAluguel(@RequestBody Aluguel aluguel) {
		if (aluguel.isRented() == true) {
			return ResponseEntity.ok(this.aService.devolverAluguel(aluguel));
		} else

		{
			System.out.println("Disponível para aluguel.");
			return null;
		}
	}

	// Atualiza aluguel por id
	@PutMapping(path = "/{id}")
	public ResponseEntity<Aluguel> atualizarAluguel(@PathVariable(name = "id") String id,
			@RequestBody Aluguel aluguel) {
		aluguel.setCodigo(id);
		;
		return ResponseEntity.ok(this.aService.atualizarAluguel(aluguel));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> removerAluguel(@PathVariable(name = "id") String id) {
		this.aService.removerAluguel(id);
		return ResponseEntity.ok(1);
	}

}
