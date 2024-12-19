package kodlama.io.rentACar.entities.concretes;



import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Brand {
@Id
    private String id;
    @Field("brandName")
    private String name;

    
    List<Model> models;


}
