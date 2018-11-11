package com.example.demo.events;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    EventDtoValidator eventDtoValidator;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("bagic")
    public ResponseEntity bagicCreate(@RequestBody  Event event) {
        event.setName("이름만 바꿔서 그대로 돌려주는 bagic 컨트롤러");
       return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }

    @PostMapping("validate")
    public ResponseEntity validateCreate(@RequestBody @Valid EventDto eventDto, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        eventDtoValidator.validate(eventDto, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }
        Event event = modelMapper.map(eventDto, Event.class);
        event.update();

        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }


}
