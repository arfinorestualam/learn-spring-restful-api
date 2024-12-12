package pzn.restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> {

    //we use T (generic) because the response from data can be anything
    private T data;
    private String errors;

    //adding for pagination
    private PagingResponse paging;
}
