package site.rapideposte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import site.rapideposte.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}
