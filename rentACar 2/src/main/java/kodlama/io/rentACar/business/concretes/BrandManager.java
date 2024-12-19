package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandeResponse;
import kodlama.io.rentACar.core.utulities.mappers.ModelMappersService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;

import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final HandlerExceptionResolver handlerExceptionResolver;
    private BrandRepository brandRepository;
    private ModelMappersService modelMappersService;


    @Override
    public List<GetAllBrandResponse> getAll() {

        List<Brand> brands = this.brandRepository.findAll();
        List<GetAllBrandResponse> brandResponse = new ArrayList<GetAllBrandResponse>();


        List<GetAllBrandResponse> brandsResponse = brands.stream().map(brand ->this.modelMappersService.forResponse()
                        .map(brand,GetAllBrandResponse.class))
                .toList();

        return brandResponse;
        }
    @Override
    public void add( CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMappersService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }
    @Override
    public GetByIdBrandeResponse getById(String id) {
        Brand brand = this.brandRepository.findById("id").orElseThrow();
        GetByIdBrandeResponse response = this.modelMappersService.forResponse().map(brand,GetByIdBrandeResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
    Brand brand = this.modelMappersService.forRequest().map(updateBrandRequest,Brand.class);
    this.brandRepository.save(brand);
    }

    @Override
    public void delete(String id) {
    this.brandRepository.deleteById("id");
    }

}

