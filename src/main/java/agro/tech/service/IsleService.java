package agro.tech.service;

import org.bson.types.ObjectId;

import agro.tech.exceptions.NotFoundException;
import agro.tech.model.Isle;
import agro.tech.repository.IsleRepository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class IsleService {

  @Inject
  IsleRepository isleRepository;

  public List<Isle> list() {
    List<Isle> isles = isleRepository.listAll();
    return isles;
  }

  public void add(Isle isle) {
    isleRepository.persist(isle);
  }

  public Isle findById(String id) throws NotFoundException {
    Isle isle = isleRepository.findById(new ObjectId(id));
    if (isle == null) {
      throw new NotFoundException();
    }
    return isle;
  }

}
