package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BrandService {
    List<GetAllBrandResponse> getAll();
    GetByIdBrandeResponse getById(String id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(String id);
}
