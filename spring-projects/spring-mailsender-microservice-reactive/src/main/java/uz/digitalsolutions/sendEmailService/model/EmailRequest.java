package uz.digitalsolutions.sendEmailService.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailRequest {

    @JsonCreator
    public EmailRequest(String fullName, String usersEmail, String message) {
        this.fullName = fullName;
        this.usersEmail = usersEmail;
        this.message = message;
    }

    @JsonProperty(value = "full_name", required = true)
    private String fullName;

    @JsonProperty(value = "users_email", required = true)
    private String usersEmail;

    @JsonProperty(value = "message", required = true)
    private String message;

}