package test.service.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdditionRequestModel {
    private String additional_info;
    private Integer additional_number;

    public AdditionRequestModel(String additional_info, Integer additional_number) {
       this.additional_info = additional_info;
       this.additional_number = additional_number;
    }
}
