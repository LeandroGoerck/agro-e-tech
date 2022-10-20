package agro.tech.repository;

import agro.tech.model.Isle;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IsleRepository implements PanacheMongoRepository<Isle> {

  public Isle findByName(String name) {
    return find("name", name).firstResult();
  }
}
