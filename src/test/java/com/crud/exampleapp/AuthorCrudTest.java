package com.crud.exampleapp;

import com.crud.exampleapp.Web.Controllers.SimpleAuthorCrudController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@WebFluxTest(controllers = SimpleAuthorCrudController.class)
public class AuthorCrudTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void postAuthor()
    {

    }

    @Test
    public void getAuthor(){

    }



}
