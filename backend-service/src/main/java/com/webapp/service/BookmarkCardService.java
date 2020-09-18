package com.webapp.service;


import com.webapp.dao.entity.BookmarkCard;
import com.webapp.dao.repository.BookmarkCardRepository;
import com.webapp.model.BookmarkRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookmarkCardService {

    @Autowired
    private BookmarkCardRepository bookmarkCardRepository;

    public BookmarkCard registerBookmarkCard(BookmarkRegistrationRequest bookmarkRegistrationRequest){
        BookmarkCard bookmarkCard = new BookmarkCard();

       // bookmarkCard.setShortURL(shortURL);
        bookmarkCard.setLongURL(bookmarkRegistrationRequest.getLongURL());
        bookmarkCard.setShortTitle(bookmarkRegistrationRequest.getShortTitle());
        bookmarkCard.setBriefDescription(bookmarkRegistrationRequest.getBriefDescription());
        bookmarkCard.setImageURL(bookmarkRegistrationRequest.getImageURL());
        bookmarkCard.setExpirationDate(bookmarkRegistrationRequest.getExpirationDate());
        return bookmarkCardRepository.save(bookmarkCard);
    }

    public List<BookmarkCard> getBookmarks(){
        return bookmarkCardRepository.findAll();
    }

}
