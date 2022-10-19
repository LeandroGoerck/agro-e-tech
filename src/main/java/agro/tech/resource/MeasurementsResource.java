package agro.tech.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import agro.tech.model.Measurements;
import agro.tech.service.MeasurementsService;

@Path("/measurements")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MeasurementsResource {

  @Inject
  MeasurementsService measurementsService;

  @POST
  public Response create(Measurements measurements) {
    measurementsService.add(measurements);
    return Response.status(201).build();
  }

  @GET
  public List<Measurements> listAll() {
    return measurementsService.list();
  }
}