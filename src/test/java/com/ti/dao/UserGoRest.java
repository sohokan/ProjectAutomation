package com.ti.dao;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "email",
        "title",
        "birth_day",
        "birth_month",
        "birth_year",
        "first_name",
        "last_name",
        "company",
        "address1",
        "address2",
        "country",
        "state",
        "city",
        "zipcode"
})

public class UserGoRest extends Root{

    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("email")
    public String email;
    @JsonProperty("title")
    public String title;
    @JsonProperty("birth_day")
    public String birthDay;
    @JsonProperty("birth_month")
    public String birthMonth;
    @JsonProperty("birth_year")
    public String birthYear;
    @JsonProperty("first_name")
    public String firstName;
    @JsonProperty("last_name")
    public String lastName;
    @JsonProperty("company")
    public String company;
    @JsonProperty("address1")
    public String address1;
    @JsonProperty("address2")
    public String address2;
    @JsonProperty("country")
    public String country;
    @JsonProperty("state")
    public String state;
    @JsonProperty("city")
    public String city;
    @JsonProperty("zipcode")
    public String zipcode;

}