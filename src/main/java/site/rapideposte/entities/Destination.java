package site.rapideposte.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
	@javax.persistence.Id @GeneratedValue(strategy=GenerationType.IDENTITY)

		private long Id;
		private String name;
		
		@OneToMany(mappedBy = "destination")
		@JsonIgnore
	    Set<TarifInt> tarifInt;
}
