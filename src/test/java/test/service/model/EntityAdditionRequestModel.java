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

    public EntityAdditionRequestModel(String title, Boolean verified, AdditionRequestModel addition, List<Integer> important_numbers) {
        this.title = title;
        this.verified = verified;
        this.addition = addition;
        this.important_numbers = important_numbers;
    }
}
