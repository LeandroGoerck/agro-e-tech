package agro.tech.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import agro.tech.model.Measurements;
import agro.tech.service.MeasurementsService;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class MeasurementResourceTest {

  @Inject
  MeasurementsService measurementsService;

  @BeforeAll
  public static void setup() {
    List<Measurements> mockList = new ArrayList<Measurements>();
    Measurements mockMeasurement = new Measurements("63507e8d98b70d7899e08bb8", 15.33, 3.33, 3.33);
    MeasurementsService mockService = Mockito.mock(MeasurementsService.class);
    Mockito.when(mockService.list()).thenReturn(mockList);
    Mockito.doNothing().when(mockService).add(mockMeasurement);
    QuarkusMock.installMockForType(mockService, MeasurementsService.class);
  }

  @Test
  public void testSuccesfulGetRequest() {
    given().when().get("/measurements").then().statusCode(200).body(containsString("[]"));
  }

  @Test
  public void testSuccesfulPostRequest() {
    Measurements mockMeasurement = new Measurements("63507e8d98b70d7899e08bb8", 15.33, 3.33, 3.33);
    given().body(mockMeasurement).header("Content-Type", "application/json").when()
        .post("/measurements").then().statusCode(201);
  }
}
