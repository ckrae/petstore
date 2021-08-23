package de.ckrae.petstore.pet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PetService {

	private final PetRepository petRepository;

	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public void addPet(Pet pet) {

		Assert.notNull(pet, "pet is null");

		petRepository.save(pet);

	}

	public void updatePet(Pet pet) {

		Assert.notNull(pet, "pet is null");
		Assert.notNull(pet.getId(), "pet has no id");

		if (!petRepository.existsById(pet.getId()))
			throw new PetNotFoundException("can not update, no pet of id " + pet.getId() + "found");

		petRepository.save(pet);

	}

	public void deletePet(Long id) {

		Assert.notNull(id, "id is null");

		if (!petRepository.existsById(id))
			throw new PetNotFoundException("can not delete, no pet of id " + id + "found");

		this.petRepository.deleteById(id);
	}

	public Pet getPet(Long id) {

		Assert.notNull(id, "id is null");

		return petRepository.findById(id)
				.orElseThrow(() -> new PetNotFoundException("No pet with id = " + id + " found."));
	}

	public Collection<Pet> getAll(String status) {
		Assert.notNull(status, "status parameter is null");

		Status statusEnum = null;
		try {
			statusEnum = Status.valueOf(status);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("no status of type " + status + " exists");
		}

		return petRepository.getByStatus(statusEnum);
	}

	public Collection<Pet> getAll(Collection<String> tags) {
		// TODO Auto-generated method stub
		return null;
	}

}
