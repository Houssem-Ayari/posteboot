package site.rapideposte.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import site.rapideposte.dao.DestinationRepository;
import site.rapideposte.entities.Destination;
import site.rapideposte.securityV1.AuthRequest;
import site.rapideposte.securityV1.AuthResponse;
import site.rapideposte.securityV1.JwtUtil;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DestinationRepository em;

    @GetMapping("/welcome")
    public @ResponseBody  List<Destination> getAllDestination(){
		return em.findAll();
	}
    
    
    @PostMapping("authenticate")
    public @ResponseBody String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
           
        }
        return jwtUtil.generateToken(authRequest.getUserName());
        
    }
    
    @PostMapping("authenticate2")
    public ResponseEntity<?> generateToken2(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        String token= jwtUtil.generateToken(authRequest.getUserName());
        return ResponseEntity.ok(new AuthResponse(authRequest.getUserName(),authRequest.getPassword(),token));
         
    }
}
