package kodlama.io.rentACar.core.utulities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMappersService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
