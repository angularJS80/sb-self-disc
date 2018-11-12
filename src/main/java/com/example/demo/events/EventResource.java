package com.example.demo.events;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
public class EventResource extends Resource<Event> {
    public EventResource(Event content, Link... links) {
        super(content, links);
        if(content.getId()!=null){
            add(linkTo(EventController.class).slash(content.getId()).withSelfRel());
        }
    }
}
