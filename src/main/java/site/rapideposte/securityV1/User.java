package site.rapideposte.securityV1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@javax.persistence.Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String username;
	private String password;
	private String email;
	private String role;
	private String nom;
	private String prenom;
	private String adresse;

}
