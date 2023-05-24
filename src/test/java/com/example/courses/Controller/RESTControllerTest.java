package com.example.courses.Controller;

import com.example.courses.Entity.Course;
import com.example.courses.Servises.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.courses.MotherObject.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RESTController.class)
class RESTControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CourseService courseService;

    @Test
    void testCreatNewCourse() throws Exception {
        given(courseService.saveCourse(any(Course.class))).willReturn(anyCourseWithId());
        mockMvc.perform(post("/course")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(anyCourse())))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));

    }

    @Test
    void getCourse() throws Exception {
        mockMvc.perform(get("/course/" + anyCourseId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteByCourseId() throws Exception {
        mockMvc.perform(delete("/course/" + anyCourseId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(courseService).deleteByCourseId(argumentCaptor.capture());

        assertEquals(anyCourseId(), argumentCaptor.getValue());
    }

    @Test
    void testUpdateCourse() throws Exception {
        mockMvc.perform(put("/course/" + anyCourseId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(anyCourse())))
                .andExpect(status().isNoContent());

        verify(courseService).updateCourseById(anyLong(), any(Course.class));
    }

    @Test
    void testPatchCourse() throws Exception {
        mockMvc.perform(patch("/course/" + anyCourseId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(anyCourse())))
                .andExpect(status().isNoContent());

        verify(courseService).patchCourseById(anyString(), any(Course.class));
    }
    @Test
    void testGetCourse() throws Exception {
        mockMvc.perform(get("/course/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(courseService).findAll();
    }
}