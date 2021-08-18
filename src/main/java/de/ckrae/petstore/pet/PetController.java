package de.ckrae.petstore.pet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "pet")
public class PetController {

	private final PetService petService;

	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}

	@PostMapping
	@Operation(summary = "Add a new pet to the store")
	public void addPet(@RequestBody Pet pet) {
		this.petService.addPet(pet);
	}

	@PutMapping
	@Operation(summary = "Update an existing pet")
	public void updatePet(@RequestBody Pet pet) {
		this.petService.updatePet(pet);
	}

	@GetMapping(path = "/findByStatus")
	@Operation(summary = "Finds Pets by status")
	public Collection<Pet> getPetsbyStatus(@RequestParam("status") String status) {

		return petService.getAll(status);
	}

	@GetMapping(path = "/findByTags")
	@Operation(summary = "Finds Pets by tags")
	public Collection<Pet> getPetsbyTags(@RequestParam("tags") Collection<String> tags) {

		return petService.getAll(tags);
	}

	@GetMapping(path = "/{petId}")
	@Operation(summary = "Find pet by ID")
	public Pet getPet(@PathVariable("petId") Long id) {
		return this.petService.getPet(id);
	}

	@DeleteMapping(path = "/{petId}")
	@Operation(summary = "Deletes a pet")
	public void deletePet(@PathVariable("petId") Long id) {
		this.petService.deletePet(id);
	}

}
