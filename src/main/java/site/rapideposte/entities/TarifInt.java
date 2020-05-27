package site.rapideposte.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarifInt {
	@EmbeddedId
    TarifIntKey Id;
 
    @ManyToOne
    @MapsId("intervaleid")
    @JoinColumn(name = "intervale_id")
    
    Intervale intervale;
 
    @ManyToOne
    @MapsId("destinationid")
    @JoinColumn(name = "destination_id")
    
    Destination destination ;
    
    
	private int tarif;

}
