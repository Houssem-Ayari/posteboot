package site.rapideposte.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import site.rapideposte.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {

}
