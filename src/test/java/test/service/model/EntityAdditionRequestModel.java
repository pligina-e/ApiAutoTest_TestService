package test.service.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class EntityAdditionRequestModel {
    private String title;
    private Boolean verified;
    private AdditionRequestModel addition;
    private List<Integer> important_numbers;
}
