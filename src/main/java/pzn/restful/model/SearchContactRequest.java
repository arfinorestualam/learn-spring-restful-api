package pzn.restful.model;
//cause param to search contact are much, we bundle it with request like this

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchContactRequest {

    private String name;

    private String phone;

    private String email;

    @NotNull
    private Integer page;

    @NotNull
    private Integer size;
}
