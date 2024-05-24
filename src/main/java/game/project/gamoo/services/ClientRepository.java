package game.project.gamoo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import game.project.gamoo.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
