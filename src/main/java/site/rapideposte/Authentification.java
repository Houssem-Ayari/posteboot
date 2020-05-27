package site.rapideposte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import site.rapideposte.securityV1.User;
import site.rapideposte.securityV1.UserRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class Authentification {
	
	@Autowired
	private UserRepository userrep;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@PostMapping("/register")
	ResponseEntity<String> register(@RequestBody User r){
	  
	    if (userrep.existsByUsername(r.getUsername())) {
	        return new ResponseEntity<>(
	          "Year of birth cannot be in the future", 
	          HttpStatus.BAD_REQUEST);
	    }
	    
	    if (userrep.existsByEmail(r.getEmail())) {
	        return new ResponseEntity<>(
	          "Year of birth cannot be in the future", 
	          HttpStatus.BAD_REQUEST);
	    }
	    else
	    r.setPassword(encoder.encode(r.getPassword()));
	    userrep.save(r);	
	    return new ResponseEntity<>(
	      "Your age is ", 
	      HttpStatus.OK);
	}

}
