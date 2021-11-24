package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {
	
	@InjectMocks
	VisitSDJpaService visitService;
	
	@Mock
	VisitRepository visitRepo;
	
	

	@BeforeEach
	void setUp() throws Exception {
		Visit visit = new Visit();
		visit.setDescription("Test visit");
		Mockito.when(visitRepo.findById(1l)).thenReturn(Optional.of(visit));
	}

	@Test
	void testFindById() {
		Visit visit = visitService.findById(1l);
		assertThat("Test visit").isEqualTo(visit.getDescription());
		verify(visitRepo).findById(Mockito.anyLong());
	}

}
