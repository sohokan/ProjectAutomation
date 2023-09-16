package com.ti.dao;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "responseCode",
        "user"
})

public class Root {

    @JsonProperty("responseCode")
    public String responseCode;
    @JsonProperty("user")
    public UserGoRest users;

}
