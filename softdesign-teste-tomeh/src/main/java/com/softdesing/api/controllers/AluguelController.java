package com.softdesing.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.softdesing.api.model.Aluguel;
import com.softdesing.api.repository.AluguelRepository;

@RestController
@RequestMapping(path = "/aluguel")
public class AluguelController {
	
	@Autowired
	private AluguelRepository er;
	
	@GetMapping(value="/cadastrarAluguel")
	public String form() {
		return "aluguel/formAluguel";
	}
	
	@PostMapping(value="/cadastrarAluguel")
	public String form(Aluguel aluguel) {
		
		er.save(aluguel);
		
		return "redirect:/cadastrarAluguel";
	}	
	
	
	@GetMapping(value="/alugueis", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<Aluguel>listaAlugueis(){
		Iterable<Aluguel> alugueis = er.findAll();
		return alugueis;
	}
	
	/*@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
		Aluguel aluguel = er.findByCodigo(codigo);
		return aluguel;
		
	}*/
	
	@DeleteMapping(value="/{codigo}")
	public String deletarAluguel(@PathVariable("codigo")long codigo){
		Aluguel aluguel = er.findByCodigo(codigo);
		er.delete(aluguel);
		return "redirect:/alugueis";
	}

}	
	
	
/*	@RequestMapping(produces="alugueis/json")
	//@GetMapping(produces="/json")
	public ModelAndView listaALugueis(){
		ModelAndView mv = new ModelAndView("index");
		Iterable<Aluguel> alugueis = er.findAll();
		mv.addObject("alugueis", alugueis);
		return mv;
	}*/
	


/*@RestController
@RequestMapping("/alugueis")
public class AluguelController {
	
	@Autowired
	private AluguelRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Aluguel>listaAlugueis(){
		Iterable<Aluguel> alugueis = er.findAll();
		return alugueis;
	}


}*/
