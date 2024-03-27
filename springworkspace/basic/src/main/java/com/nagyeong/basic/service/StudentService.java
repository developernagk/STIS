package com.nagyeong.basic.service;

import org.springframework.http.ResponseEntity;

import com.nagyeong.basic.dto.request.student.PostStudentRequestDto;

public interface StudentService {
  ResponseEntity<String> postStudent(PostStudentRequestDto dto);
}
