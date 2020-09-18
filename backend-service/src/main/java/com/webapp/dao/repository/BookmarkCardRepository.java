package com.webapp.dao.repository;

import com.webapp.dao.entity.BookmarkCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookmarkCardRepository extends JpaRepository<BookmarkCard, UUID> {

    @Query("SELECT om FROM BookmarkCard om where om.shortURL = :shortURL")
    List<BookmarkCard> findByshortURL(@Param("shortURL") String shortURL);

}
