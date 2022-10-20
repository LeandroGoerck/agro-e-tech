package agro.tech.service;

import agro.tech.model.Measurements;
import agro.tech.repository.MeasurementsRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MeasurementsService {

  @Inject
  MeasurementsRepository measurementsRepository;

  public List<Measurements> list() {
    List<Measurements> measurements = measurementsRepository.listAll();
    return measurements;
  }

  public void add(Measurements measurements) {
    measurementsRepository.persist(measurements);
  }
}