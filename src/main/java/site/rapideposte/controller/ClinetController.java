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

import site.rapideposte.dao.ClientRepository;
import site.rapideposte.entities.Client;

@RestController
@RequestMapping(path="/api")
public class ClinetController {
	@Autowired
	private ClientRepository em;
	
	@GetMapping("/Client")
	public @ResponseBody  List<Client> getAllClient(){
		return em.findAll();
	}
	
	
	
	@GetMapping(path="/Client/{id}")
	public @ResponseBody  Optional<Client> getClientid(@PathVariable("id") long id){
		return em.findById(id);
	}
	
	@DeleteMapping(path="/Client/{id}")
	public @ResponseBody  Boolean deleteClient(@PathVariable("id") long id){
		
		 em.deleteById(id);
		 return true;
		
	}
	
	
	@PostMapping(path="/Client")
	public @ResponseBody  Client addClient(@RequestBody  Client p){
		 return em.save(p);
	
		
	}
	
	@PutMapping("/Client")
	public @ResponseBody Client updateClient(@RequestBody Client p) {

		
		return em.save(p);

		 
	}

}
