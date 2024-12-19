package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BrandRepository extends MongoRepository<Brand, String> {

}
