package com.webapp.service;

import com.webapp.dao.entity.BookmarkCard;
import com.webapp.dao.repository.BookmarkCardRepository;
import com.webapp.exception.URLGenerationException;
import com.webapp.model.BookmarkRegistrationRequest;
import com.webapp.model.BookmarkRegistrationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class URLGeneratorService {

    @Autowired
    private HashingService hashingService;

    @Autowired
    private BookmarkCardRepository bookmarkCardRepository;

    @Autowired
    private BookmarkCardService bookmarkCardService;

    public BookmarkRegistrationResponse generateShortURL(BookmarkRegistrationRequest bookmarkRegistrationRequest) throws URLGenerationException{
        String shortURL="";

        BookmarkCard bookmarkCard = bookmarkCardService.registerBookmarkCard(bookmarkRegistrationRequest);
        log.info("BookmarkCard has been registered successfully");
        shortURL = hashingService.encode(bookmarkCard.getId());
        bookmarkCard.setShortURL(shortURL);
        bookmarkCardRepository.save(bookmarkCard);
        log.info("ShortURL has been generated");

        return getResponse(shortURL);
    }

    public String getLongURL(String shortURL){
        List<BookmarkCard> bookmarkCardList = bookmarkCardRepository.findByshortURL(shortURL);
        if(bookmarkCardList.size()>0) {
            return bookmarkCardList.get(0).getLongURL();
        }else{
            throw new URLGenerationException("ShortURL doesn't exist");
        }
    }

    private BookmarkRegistrationResponse getResponse(String shortUrl){
        BookmarkRegistrationResponse bookmarkRegistrationResponse = new BookmarkRegistrationResponse();
        bookmarkRegistrationResponse.setShortURL(shortUrl);
        bookmarkRegistrationResponse.setProcessedTimestamp(System.currentTimeMillis());
        return bookmarkRegistrationResponse;
    }




}
