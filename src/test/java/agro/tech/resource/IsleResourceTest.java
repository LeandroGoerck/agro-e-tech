package agro.tech.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import agro.tech.exceptions.NotFoundException;
import agro.tech.model.Isle;
import agro.tech.service.IsleService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class IsleResourceTest {

  @InjectMock
  IsleService isleService;

  private Isle mockIsle;

  @BeforeEach
  public void setup() throws NotFoundException {
    List<Isle> mockList = new ArrayList<Isle>();
    mockIsle = new Isle();
    mockIsle.setName("South Isle");
    mockIsle.setStatus(true);
    mockList.add(mockIsle);
  }

  @Test
  public void testSuccessfulGetRequest() {
    Mockito.when(isleService.list()).thenReturn(List.of());
    given().when().get("/isles").then().statusCode(200).body(containsString("[]"));
  }

  @Test
  public void testSuccessfulGetByIdRequest() throws NotFoundException {
    Mockito.when(isleService.findById("63507e8e98b70d7899e08bb9")).thenReturn(mockIsle);
    given().when().get("/isles/63507e8e98b70d7899e08bb9").then().statusCode(200);
  }

  @Test
  public void testSuccessfullAddIsle() {
    Isle newIsle = new Isle();
    newIsle.setName("North Island");
    newIsle.setStatus(true);
    Mockito.doNothing().when(isleService).add(newIsle);
    given().contentType("application/json").body(newIsle).when().post("/isles").then()
        .statusCode(201);
  }

  @Test
  public void testSuccessfullUpdate() throws NotFoundException {
    Isle mockIsle = new Isle();
    Mockito.when(isleService.update("63507e8e98b70d7899e08bb9", mockIsle)).thenReturn(mockIsle);
    given().body(mockIsle).header("Content-Type", "application/json").when().put("/isles/blablabla")
        .then().statusCode(204);
  }

  @Test
  public void testSuccessfullDeleteIsle() throws NotFoundException {
    Mockito.doNothing().when(isleService).delete("63507e8e98b70d7899e08bb9");
    given().when().delete("/isles/63507e8e98b70d7899e08bb9").then().statusCode(204);
  }
}
