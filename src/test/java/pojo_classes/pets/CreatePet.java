package pojo_classes.pets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreatePet {

    /**
     * {
     *   "id": 0,
     *   "category": {
     *     "id": 0,
     *     "name": "string"
     *   },
     *   "name": "doggie",
     *   "photoUrls": [
     *     "string"
     *   ],
     *   "tags": [
     *     {
     *       "id": 0,
     *       "name": "string"
     *     }
     *   ],
     *   "status": "available"
     * }
     */


    //Note: If you do not use @Builder.Default
    //it will not pick the attribute's value from this class

//  Use the following when you assign the value in the pojo
//    @Builder.Default
//    private int id = 3;

    private int id;
    private Category category;
//    @Builder.Default
//    private String name = "Marco";
    private String name ;
    private List<String> photoUrls;
    private List<Tags> tags;
    @Builder.Default
    private String status = "available";

}
