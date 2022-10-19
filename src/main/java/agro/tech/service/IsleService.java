package agro.tech.service;

import agro.tech.exceptions.NotFoundException;
import agro.tech.model.Isle;
import agro.tech.repository.IsleRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.bson.types.ObjectId;

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

  /** Find isle by id.
   */
  public Isle findById(String id) throws NotFoundException {
    Isle isle = isleRepository.findById(new ObjectId(id));
    if (isle == null) {
      throw new NotFoundException();
    }
    return isle;
  }

  /** Update isle by id.
   */
  public Isle update(String id, Isle updated) throws NotFoundException {
    Isle isle = findById(id);
    if (isle == null) {
      throw new NotFoundException();
    }
    isle.setStatus(updated.getStatus());
    isleRepository.update(isle);
    return isle;
  }

  /** Delete isle by id.
   */
  public void delete(String id) throws NotFoundException {
    Isle isle = findById(id);
    if (isle == null) {
      throw new NotFoundException();
    }
    isleRepository.delete(isle);
  }
}
