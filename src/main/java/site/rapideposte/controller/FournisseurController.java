package site.rapideposte.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import site.rapideposte.dao.FournisseurRepository;

import site.rapideposte.entities.Fournisseur;

@RestController
@RequestMapping(path="/api")
public class FournisseurController {
	@Autowired
	private FournisseurRepository em;
	
	@GetMapping("/Fournisseur")
	public @ResponseBody  List<Fournisseur> getAllFournisseur(){
		return em.findAll();
	}
	
	
	
	@GetMapping(path="/Fournisseur/{id}")
	public @ResponseBody  Optional<Fournisseur> getFournisseurid(@PathVariable("id") long id){
		return em.findById(id);
	}
	
	@DeleteMapping(path="/Fournisseur/{id}")
	public @ResponseBody  Boolean deleteFournisseur(@PathVariable("id") long id){
		
		 em.deleteById(id);
		 return true;
		
	}
	
	
	@PostMapping(path="/Fournisseur")
	public @ResponseBody  Fournisseur addFournisseur(@RequestBody  Fournisseur p){
		 return em.save(p);
	
		
	}
	
	@PutMapping("/Fournisseur")
	public @ResponseBody Fournisseur updateFournisseur(@RequestBody Fournisseur p) {

		
		return em.save(p);

		 
	}

}
