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

import site.rapideposte.dao.IntervaleRepository;
import site.rapideposte.entities.Intervale;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class InervaleController {
	@Autowired
	private IntervaleRepository em;
	
	@GetMapping(path="/Intervale")
	public @ResponseBody  List<Intervale> getAllIntervale(){
		return em.findAll();
	}
	
	
	
	@GetMapping(path="/Intervale/{id}")
	public @ResponseBody  Optional<Intervale> getIntervaleid(@PathVariable("id") long id){
		return em.findById(id);
	}
	
	@DeleteMapping(path="/Intervale/{id}")
	public @ResponseBody  Boolean deleteIntervale(@PathVariable("id") long id){
		
		 em.deleteById(id);
		 return true;
		
	}
	
	
	@PostMapping(path="/Intervale")
	public @ResponseBody  Intervale addIntervale(@RequestBody  Intervale p){
		 return em.save(p);
	
		
	}
	
	@PutMapping("/Intervale")
	public @ResponseBody Intervale updateIntervale(@RequestBody Intervale p) {

		
		return em.save(p);

		 
	}

}
