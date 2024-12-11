package pzn.restful.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {

    //because it's optional, we don't need annotation @NotBlank

    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String password;
}
