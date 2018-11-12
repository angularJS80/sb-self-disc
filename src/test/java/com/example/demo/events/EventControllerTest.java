package com.example.demo.events;

import com.example.demo.common.ControllerTests;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
public class EventControllerTest  extends ControllerTests {
    @Test
    public void createBagicEvent() throws Exception {
        Event event = Event.builder()
                .name("만나서 반가웠습니다")
                .description("너무나 알차서 어려웠지만 모든것을 이해 했습니다.")

                .limitOfEnrollment(100)
                .build();

        this.mockMvc.perform(
                post("/api/events/bagic")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(objectMapper.writeValueAsString(event))
                )
                .andDo(print())
                .andExpect(status().isCreated())

        ;

    }

    @Test
    public void createValidateEvent() throws Exception {
        Event event = Event.builder()
                .name("만나서 반가웠습니다")
                .description("너무나 알차서 어려웠지만 모든것을 이해 했습니다.")
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 2, 8, 0))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 3, 8, 0))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 4, 8, 0))
                .endEventDateTime(LocalDateTime.of(2018, 11, 5, 8, 0))
                .basePrice(0)
                .maxPrice(0)
                .location("네이버 D2 팩토리")
                .limitOfEnrollment(100)
                .build();

        this.mockMvc
                .perform(
                    post("/api/events/validate")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(event))
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()))
                .andExpect(jsonPath("free").value(true))
                //.andExpect(jsonPath("id").exists())
        ;

    }

    @Test
    public void createLinkEvent() throws Exception {
        Event event = Event.builder()
                .name("만나서 반가웠습니다")
                .description("너무나 알차서 어려웠지만 모든것을 이해 했습니다.")
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 2, 8, 0))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 3, 8, 0))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 4, 8, 0))
                .endEventDateTime(LocalDateTime.of(2018, 11, 5, 8, 0))
                .basePrice(0)
                .maxPrice(0)
                .location("네이버 D2 팩토리")
                .limitOfEnrollment(100)
                .build();

        this.mockMvc
                .perform(
                        post("/api/events/link")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(objectMapper.writeValueAsString(event))
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()))
                .andExpect(jsonPath("free").value(true))
                .andDo(document("create-event",
                        links(
                                linkWithRel("self").description("link to self"),
                                linkWithRel("profile").description("link to profile")
                                //linkWithRel("events").description("link to events"),
                                //linkWithRel("update").description("link to update"),

                        )
                ))
        //.andExpect(jsonPath("id").exists())
        ;

    }






}
