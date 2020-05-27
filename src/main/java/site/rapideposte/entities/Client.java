package site.rapideposte.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.rapideposte.securityV1.User;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long Id;
	
	private String Cin;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
