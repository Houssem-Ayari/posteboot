package site.rapideposte.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import site.rapideposte.dao.TarifIntRepository;
import site.rapideposte.entities.TarifInt;
import site.rapideposte.entities.TarifIntKey;


@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class TarifIntController {
	@Autowired
	private TarifIntRepository em;
	
	@GetMapping(path="/TarifInt")
	public @ResponseBody  List<TarifInt> getAllTarifInt(){

		return em.findAll();
	}
	
	
	
	@GetMapping(path="/TarifInt/{id}")
	public @ResponseBody  Optional<TarifInt> getTarifIntid(@PathVariable("id") TarifIntKey id){
		return em.findById(id);
	}
	
	@DeleteMapping(path="/TarifInt/{id}")
	public @ResponseBody  Boolean deleteTarifInt(@PathVariable("id") TarifIntKey id){
		
		 em.deleteById(id);
		 return true;
		
	}
	
	
	@PostMapping(path="/TarifInt")
	public @ResponseBody  TarifInt addTarifInt(@RequestBody  TarifInt p){
		
		System.out.print(p.toString());
		 return em.save(p);
	
		
	}
	
	@PutMapping("/TarifInt")
	public @ResponseBody TarifInt updateTarifInt(@RequestBody TarifInt p) {

		System.out.print(p.toString());
		return em.save(p);

		 
	}

}
