package com.webapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BookmarkRegistrationRequest {

    @JsonProperty("longURL")
    private String longURL;

    @JsonProperty("shortTitle")
    private String shortTitle;

    @JsonProperty("briefDescription")
    private String briefDescription;

    @JsonProperty("imageURL")
    private String imageURL;

    @JsonProperty("expirationDate")
    private String expirationDate;

}
