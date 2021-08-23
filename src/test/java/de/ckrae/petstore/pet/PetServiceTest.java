package de.ckrae.petstore.pet;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

	@Mock
	private PetRepository repo;

	@InjectMocks
	private PetService service;

	@Test
	public void addPet() {

		Category category = new Category();
		Pet pet = new Pet(1L, category, "Wauwau", new ArrayList<>(), new ArrayList<>(), Status.AVAILABLE);

		service.addPet(pet);

	}

	@Test
	public void updatePet() {

		Category category = new Category();
		Pet pet = new Pet(1L, category, "Wauwau", new ArrayList<>(), new ArrayList<>(), Status.AVAILABLE);

		when(repo.existsById(1L)).thenReturn(true);

		service.updatePet(pet);

	}

}
