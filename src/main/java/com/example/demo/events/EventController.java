package com.example.demo.events;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
public class EventController {

    @PostMapping("bagic")
    public ResponseEntity bagiccreate(@RequestBody @Valid Event event, Errors errors) {
        event.setName("이름만 바꿔서 그대로 돌려주는 bagic 컨트롤러");
       return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }

}
