package com.example.demo.events;
import org.junit.Test;

//import static org.assertj.core.api.Assertions.assertThat;


public class EventTest {

    @Test
    public void javaBean() {
        String name = "java bean constructor test";
        Event event = new Event();
        event.setName(name);
        //assertThat(event.getName()).isEqualTo(name);
    }

    @Test
    public void builder() {
        String name = "test event";
        Event event = Event.builder()
                .name(name)
                .description("builder event test")
                .build();

        //assertThat(event.getName()).isEqualTo(name);
    }



}
