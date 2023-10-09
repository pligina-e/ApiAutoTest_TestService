package test.service.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdditionRequestModel {
    private String additional_info;
    private Integer additional_number;
}
