package agro.tech.model.repository;

import javax.enterprise.context.ApplicationScoped;
import agro.tech.model.Measurements;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class MeasurementsRepository implements PanacheMongoRepository<Measurements> {
}