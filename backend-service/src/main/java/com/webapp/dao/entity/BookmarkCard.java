package com.webapp.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "bookmark_card")
@Data
public class BookmarkCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookmark_card_auto_id_generator")
    @SequenceGenerator(
            name = "bookmark_card_auto_id_generator",
            sequenceName = "bookmark_card_auto_id_sequence",
            allocationSize = 1
    )
    @Id
    private Long id;

    @Column(name = "short_url")
    private String shortURL;

    @Column(name = "long_url")
    private String longURL;

    @Column(name = "short_title")
    private String shortTitle;

    @Column(name = "brief_description")
    private String briefDescription;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "expiration_date")
    private String expirationDate;


}
