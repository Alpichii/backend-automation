package pojo_classes.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
//@AllArgsConstructor we do not use this annotation
// when we use builder in the class where the object is.

//@NoArgsConstructor we do not use this annotation
// when we use builder in the class where the object is.


public class CreateUserWithLombok {

//    @Builder.Default // We need to use  @Builder.Default when we do not use @AllArgsConstructor
//    private String name = "Tech Global";

    private String name ;
//    @Builder.Default
//    private String gender = "male";
    private String gender;
    @Builder.Default
    private String email = utils.CommonUtils.genRandomEmailAddress();
    @Builder.Default
    private String status = "active";

}
