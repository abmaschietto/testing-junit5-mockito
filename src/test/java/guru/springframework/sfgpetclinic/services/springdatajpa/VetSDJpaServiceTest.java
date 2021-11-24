package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.repositories.VetRepository;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {
	
	@InjectMocks
	VetSDJpaService vetService;
	
	@Mock
	VetRepository vetRepo;
	
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testeDeleteById() {
		vetService.deleteById(1l);
		verify(vetRepo, atLeast(1)).deleteById(1l);
	}

}
