package agro.tech.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import agro.tech.model.Measurements;
import agro.tech.repository.MeasurementsRepository;

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