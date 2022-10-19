package agro.tech.repository;

import agro.tech.model.Measurements;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MeasurementsRepository implements PanacheMongoRepository<Measurements> {
}