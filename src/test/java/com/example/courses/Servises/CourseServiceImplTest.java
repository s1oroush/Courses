package com.example.courses.Servises;

import com.example.courses.Entity.Course;
import com.example.courses.Repositories.CourseRepositories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.example.courses.MotherObject.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CourseServiceImplTest {

    @InjectMocks
    CourseServiceImpl service;
    @Mock
    CourseRepositories repositories;

    @Test
    void findAll() {
        //when
        doReturn(courseIterable()).when(repositories).findAll();
        //given
        Iterable<Course> courses = service.findAll();
        //then courses not empty
        assertTrue(courses.iterator().hasNext());
    }


    @Test
    void saveCourse() {
        //when
        doReturn(anyCourse()).when(repositories).save(any());
        //given
        Course course = service.saveCourse(anyCourse());
        // then
        assertEquals(anyCourse(), course);
    }

    @Test
    @DisplayName("for given id exists courses for update")
    void updateCourseById() {
        //when
        doReturn(Optional.of(anyCourse())).when(repositories).findById(anyLong());
        //given
        service.updateCourseById(anyId(), anyCourse());
        //then
        verify(repositories, atLeastOnce()).save(any(Course.class));
    }

    @Test
    @DisplayName("for given id not exists courses for update")
    void updateCourseByIdNotExist() {
        //when
        doReturn(Optional.empty()).when(repositories).findById(anyLong());
        //given
        //then
        assertThrows(RuntimeException.class, () -> service.updateCourseById(anyId(), anyCourse()));
    }

    @Test
    void fetchCourseByCourseId() {
        //when
        doReturn(anyCourse()).when(repositories).findAllByCourseId(anyString());
        //given
        Course course = service.fetchCourseByCourseId(anyCourseId());
        //then
        assertNotNull(course);
    }


    @Test
    void deleteByCourseId() {
        //when
        doNothing().when(repositories).deleteByCourseId(anyString());
        //given
        service.deleteByCourseId(anyCourseId());
        //then
        verify(repositories, atLeastOnce()).deleteByCourseId(anyString());
    }

    @Test
    void fetchCourseById(){
        //when
        doReturn(Optional.of(anyCourse())).when(repositories).findById(anyLong());
        //given
        Course course =  service.fetchCourseById(anyId());
        //then
        assertNotNull(course);
    }

    @Test
    @DisplayName("for given id exists Course for update")
    void patchCourseById() {
        //when
        doReturn(anyCourse()).when(repositories).findByCourseId(anyString());
        //given
        service.patchCourseById(anyCourseId(), anyCourse());
        //then
        verify(repositories, atLeastOnce()).save(any(Course.class));

    }

    @Test
    @DisplayName("for given id not exists Course for update")
    void patchCourseByIdNotExist() {
        //when
        doReturn(Optional.empty()).when(repositories).findById(anyLong());
        //given
        //then
        assertThrows(RuntimeException.class, () -> service.updateCourseById(anyId() , anyCourse()));
    }


}