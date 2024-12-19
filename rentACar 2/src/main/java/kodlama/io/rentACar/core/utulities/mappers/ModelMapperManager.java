package kodlama.io.rentACar.core.utulities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ModelMapperManager implements ModelMappersService {


    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse(){
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }
    @Override
    public ModelMapper forRequest(){
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }


}
