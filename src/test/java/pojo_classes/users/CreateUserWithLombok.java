package pojo_classes.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor


public class CreateUserWithLombok {

    private String name = "Tech Global";
    private String gender = "male";
    private String email = utils.CommonUtils.genRandomEmailAddress();
    private String status = "active";

}
