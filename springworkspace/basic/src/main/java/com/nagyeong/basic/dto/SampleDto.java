package com.nagyeong.basic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    // Request Body로 받아오는 데이터는 Wrapper 클래스 타입으로 데이터를 받는 것이 좋음
    @NotNull
    // NotEmpty, NotBlank는 문자열에서만 유효함
    // @NotEmpty @NotBlank : 타입 mismatch
    private Integer requiredInt;

    @Length(min=5, max=10) // 문자열일 경우 문자열 길이의 최소, 최대를 지정(null 값이면 검사 안 함)
    @NotNull
    private String length;

    // 최댓값과 최솟값을 지정
    @Max(100)
    @Min(0)
    @NotNull
    private Integer maxMin;

    // 최대 최소 범위를 지정
    @Range(min=0, max=100)
    @NotNull
    private Integer range;

    // 문자열이 이메일 형식인지 확인
    @Email
    @NotEmpty
    private String email;

    // 정규식을 이용해 문자열의 패턴 검사를 진행
    // 전화번호, 이메일, url, 주민등록번호, 비밀번호, 영어(/한글/숫자)로만 이루어진 문자열
    // 비밀번호와 관련한 정규표현식은 각 국마다 법으로 지정해둠
    @Pattern(regexp="^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String emailPattern;

}
