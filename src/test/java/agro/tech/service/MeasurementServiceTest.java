package agro.tech.service;

import static org.mockito.Mockito.times;

import agro.tech.model.Measurements;
import agro.tech.repository.MeasurementsRepository;
import com.mongodb.assertions.Assertions;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class MeasurementServiceTest {

  @Inject
  MeasurementsService measurementsService;

  @InjectMock
  MeasurementsRepository measurementsRepository;

  @BeforeAll
  public static void setup() {
    List<Measurements> mockList = new ArrayList<Measurements>();
    MeasurementsRepository mockRepository = Mockito.mock(MeasurementsRepository.class);
    Mockito.doNothing().when(mockRepository).persist(Mockito.any(Measurements.class));
    Mockito.when(mockRepository.listAll()).thenReturn(mockList);
    QuarkusMock.installMockForType(mockRepository, MeasurementsRepository.class);
  }

  @Test
  public void testListAllMeasurements() {
    List<Measurements> emptyList = measurementsService.list();
    Assertions.assertTrue(emptyList.size() == 0);
  }

  @Test
  public void testCreateMeasurement() {
    Measurements mockMeasurement = new Measurements("63507e8e98b70d7899e08bb9", 15.33, 3.33, 3.33);
    measurementsService.add(mockMeasurement);
    Mockito.verify(measurementsRepository, times(1)).persist(mockMeasurement);
  }

}
