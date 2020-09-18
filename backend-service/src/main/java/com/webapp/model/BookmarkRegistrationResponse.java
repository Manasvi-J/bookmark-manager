package com.webapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookmarkRegistrationResponse {

    @JsonProperty("shortURL")
    private String shortURL;

    @JsonProperty("processedTimestamp")
    private long processedTimestamp;
}
