package com.webapp.service;

import com.webapp.dao.entity.BookmarkCard;
import com.webapp.dao.repository.BookmarkCardRepository;
import com.webapp.model.BookmarkRegistrationRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BookmarkCardServiceTest {

    @InjectMocks
    private BookmarkCardService bookmarkCardService;

    @Mock
    private BookmarkCardRepository bookmarkCardRepository;


    @Test
    public void registerBookmarkCard_notNull(){

        BookmarkCard bookmarkCard = new BookmarkCard();

        BookmarkRegistrationRequest bookmarkRegistrationRequest = new BookmarkRegistrationRequest();
        bookmarkCard.setLongURL("https://bookmark.com/");
        bookmarkCard.setShortTitle("Bookmark");
        bookmarkCard.setBriefDescription("Bookmark manager");
        bookmarkCard.setImageURL("https://image.com/");
        bookmarkCard.setExpirationDate("2020-09-17");
        bookmarkRegistrationRequest.setLongURL("long_url");
        bookmarkRegistrationRequest.setShortTitle("title");
        bookmarkRegistrationRequest.setBriefDescription("description");
        bookmarkRegistrationRequest.setExpirationDate("expiration_date");
        bookmarkRegistrationRequest.setImageURL("image_url");
        Mockito.when(bookmarkCardRepository.save(Mockito.any(BookmarkCard.class))).thenReturn(bookmarkCard);

        BookmarkCard bookmarkCardSave = bookmarkCardService.registerBookmarkCard(bookmarkRegistrationRequest);

        Mockito.verify(bookmarkCardRepository, Mockito.times(1)).save(Mockito.any(BookmarkCard.class));
        Assert.assertNotNull(bookmarkCardSave);
    }

    @Test
    public void getBookmarks_findAll(){
        List<BookmarkCard> bookmarkCardList = new ArrayList<>();
        BookmarkCard bookmarkCard = new BookmarkCard();
        bookmarkCardList.add(bookmarkCard);
        Mockito.when(bookmarkCardRepository.findAll()).thenReturn(bookmarkCardList);

        List<BookmarkCard> bookmarkCardListFind = bookmarkCardService.getBookmarks();

        Mockito.verify(bookmarkCardRepository, Mockito.times(1)).findAll();
    }
}
