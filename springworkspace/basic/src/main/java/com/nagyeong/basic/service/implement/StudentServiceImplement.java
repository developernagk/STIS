package com.nagyeong.basic.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagyeong.basic.dto.request.student.PatchStudentRequestDto;
import com.nagyeong.basic.dto.request.student.PostStudentRequestDto;
import com.nagyeong.basic.entity.StudentEntity;
import com.nagyeong.basic.repository.StudentRepository;
import com.nagyeong.basic.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentService {

  private final StudentRepository studentRepository;

  @Override
  public ResponseEntity<String> postStudent(PostStudentRequestDto dto) {
    // CREATE(SQL : INSERT)
    // 1. Entity 클래스의 인스턴스를 생성
    // 2. 생성한 인스턴스를 repository.save() 메서드로 저장
    StudentEntity studentEntity = new StudentEntity(dto);
    // save() : 저장 및 수정(덮어쓰기)
    StudentEntity savedEntity = studentRepository.save(studentEntity);

    return ResponseEntity.status(HttpStatus.CREATED).body("성공!");
  }

  @Override
  public ResponseEntity<String> patchStudent(PatchStudentRequestDto dto) {
    // UPDATE(SQL : UPDATE)

    Integer studentNumber = dto.getStudentNumber();
    String address = dto.getAddress();

    // 1. student 테이블로 접근 (StudentRepository 사용)
    StudentEntity studentEntity = studentRepository.
    // 2. dto.studentNumber에 해당하는 레코드를 검색
    findById(studentNumber).get();
    // 3. 검색된 레코드의 address 값을 dto.address로 변경
    studentEntity.setAddress(address);
  }
  
}
