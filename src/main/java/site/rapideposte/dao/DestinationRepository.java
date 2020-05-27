package site.rapideposte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import site.rapideposte.entities.Destination;

public interface DestinationRepository extends JpaRepository<Destination,Long> {

}
