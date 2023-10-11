package test.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityResponseModel {
    private int id;
    private String title;
    private boolean verified;

    public Boolean getVerified() {
        return verified;
    }
}
