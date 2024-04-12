package com.nagyeong.basic.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @Configurable :
// - 생성자나 '메서드'가 호출 시에 Spring bean 등록을 자동화(제어 역전)하는 어노테이션
@Configurable
// @EnableWebSecurity :
// - Web Security 설정을 지원하도록 하는 어노테이션
@EnableWebSecurity
public class WebSecurityConfig {
  
  // @Bean :
  // - Spring bean으로 등록하는 어노테이션(@Component 또한 같은 기능-클래스의 인스턴스를 자동 생성)
  // - @Component를 사용하지 못할 때 사용
  // - @Autowired의 목적이 아닐 때 사용
  // 클래스 자체에는 사용 가능
  @Bean
  // SecurityFilterChain 타입을 반환하는 configure 메서드
  // SecurityFilterChain : 인증이나 인가를 받지 않은 사용자에 대해 필터를 거쳐 바로 반환 됨(보안 관련 필터)
  protected SecurityFilterChain configure(HttpSecurity security) throws Exception {
    // class::method :
    // - 메소드 참조, 특정 클래스의 메서드를 참조할 때 사용
    // - 일반적으로 매개변수로 메서드를 전달할 때 사용됨
    // httpBasic는 매개변수로 메서드를 전달 받기를 원함(이후 수업에서 람다 함수 사용할 것)
    // HttpBasicConfigurer의 disable이라고 하는 메서드를 전달하겠다는 의미
    security
      // basic authentication 미사용 지정
      .httpBasic(HttpBasicConfigurer::disable);
    return security.build();
  }

}
