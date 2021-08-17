package uz.javokhir.sendEmailService.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailRequest {

    @JsonCreator
    public EmailRequest(String fullName, String subject, String message) {
        this.fullName = fullName;
        this.subject = subject;
        this.message = message;
    }

    @JsonProperty(value = "full_name", required = true)
    private String fullName;

    @JsonProperty(value = "subject", required = true)
    private String subject;

    @JsonProperty(value = "message", required = true)
    private String message;
}