package site.rapideposte.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarifIntKey implements Serializable{
	@Column(name = "intervale_id")
    long intervaleid;
 
    @Column(name = "destination_id")
    long destinationid;

}
