package com.nagyeong.basic.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// Request Body로 받는 데이터에 대한 유효성 검사를 validation 의존성을 추가해야함
public class SampleDto {

    @NotNull // 해당 속성을 null이 올 수 없도록 지정
    private String notNull;

    @NotEmpty // 문자열일 경우 null 또는 빈 문자열이 올 수 없도록 지정
    private String notEmpty;
    
    @NotBlank // 문자열일 경우 null 또는 빈 문자열 또는 공백으로 된 문자열이 올 수 없도록 지정
    private String notBlank;

    @Length(min=5, max=10) // 문자열일 경우 문자열 길이의 최소, 최대를 지정(null 값이면 검사 안 함)
    @NotNull
    private String length;

}
