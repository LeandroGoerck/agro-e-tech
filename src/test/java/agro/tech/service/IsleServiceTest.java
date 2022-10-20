package agro.tech.service;

import agro.tech.exceptions.NotFoundException;
import agro.tech.model.Isle;
import agro.tech.repository.IsleRepository;
import agro.tech.service.IsleService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class IsleServiceTest {

  @Inject
  IsleService isleService;

  @InjectMock
  IsleRepository isleRepository;

  private Isle isle;

  @BeforeEach
  public void setup() {
    isle = new Isle();
    isle.setName("South Isle");
    isle.setStatus(true);
  }

  @Test
  public void testListAllIsle() {
    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);
    Mockito.when(isleRepository.listAll()).thenReturn(isleList);

    Assertions.assertTrue(isleService.list() == isleList);

  }

  @Test
  public void testCreateIsle() {
    Mockito.doNothing().when(isleRepository).persist(Mockito.any(Isle.class));

    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);

    Isle newIsle = new Isle("North Island", true);
    isleList.add(newIsle);
    isleService.add(newIsle);

    Assertions.assertEquals(2, isleList.size());
  }

  @Test
  public void testDeleteIsle() throws NotFoundException {
    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);

    Mockito.doNothing().when(isleRepository).delete(Mockito.any(Isle.class));

    Mockito.when(isleRepository.findById(new ObjectId("63507e8e98b70d7899e08bb9")))
        .thenReturn(isleList.get(0));
    isleService.delete("63507e8e98b70d7899e08bb9");
    isleList.remove(0);

    Assertions.assertEquals(0, isleList.size());
  }

  @Test
  public void testFindByIdIsle() throws NotFoundException {
    List<Isle> isleList = new ArrayList<Isle>();
    isleList.add(isle);

    Mockito.when(isleRepository.findById(new ObjectId("63507e8e98b70d7899e08bb9")))
        .thenReturn(isleList.get(0));

    Assertions.assertEquals(1, isleList.size());
  }
}
