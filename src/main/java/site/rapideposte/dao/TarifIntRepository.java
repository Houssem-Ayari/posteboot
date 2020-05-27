package site.rapideposte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import site.rapideposte.entities.TarifInt;
import site.rapideposte.entities.TarifIntKey;


public interface TarifIntRepository extends JpaRepository<TarifInt,TarifIntKey>{

}
