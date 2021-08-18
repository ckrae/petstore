package de.ckrae.petstore.pet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	private final PetRepository petRepository;

	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public void addPet(Pet pet) {
		petRepository.save(pet);

	}

	public void updatePet(Pet pet) {
		petRepository.save(pet);

	}

	public void deletePet(Long id) {
		this.petRepository.deleteById(id);
	}

	public Pet getPet(Long id) {
		return petRepository.findById(id)
				.orElseThrow(() -> new PetNotFoundException("No pet with id = " + id + " found."));
	}

	public Collection<Pet> getAll(String status) {
		Status statusEnum = Status.valueOf(status);
		return petRepository.getByStatus(statusEnum);
	}

	public Collection<Pet> getAll(Collection<String> tags) {
		// TODO Auto-generated method stub
		return null;
	}

}
