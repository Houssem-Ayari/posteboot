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

import site.rapideposte.dao.DestinationRepository;
import site.rapideposte.entities.Destination;


@RestController
@RequestMapping(path="/api")
public class DestinationController {
	@Autowired
	private DestinationRepository em;
	
	@GetMapping("/Destination")
	public @ResponseBody  List<Destination> getAllDestination(){
		return em.findAll();
	}
	
	
	
	@GetMapping(path="/Destination/{id}")
	public @ResponseBody  Optional<Destination> getDestinationid(@PathVariable("id") long id){
		return em.findById(id);
	}
	
	@DeleteMapping(path="/Destination/{id}")
	public @ResponseBody  Boolean deleteDestination(@PathVariable("id") long id){
		
		 em.deleteById(id);
		 return true;
		
	}
	
	
	@PostMapping(path="/Destination")
	public @ResponseBody  Destination addDestination(@RequestBody  Destination p){
		 return em.save(p);
	
		
	}
	
	@PutMapping("/Destination")
	public @ResponseBody Destination updateDestination(@RequestBody Destination p) {

		
		return em.save(p);

		 
	}

}
