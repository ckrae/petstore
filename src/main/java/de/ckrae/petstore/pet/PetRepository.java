package de.ckrae.petstore.pet;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	@Query("SELECT p FROM Pet p WHERE p.status = ?1")
	Collection<Pet> getByStatus(Status status);

}
