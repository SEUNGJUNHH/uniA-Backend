package com.example.unia.member.config;

import com.example.unia.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //di를 위한 컨스트럭터 생성
    private final MemberService memberService;

    // 입력받은 비밀번호 암호화하여 저장
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Request 가 들어오는 경우 권한 설정 & 로그인 & 로그아웃 처리

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//csrf기능 사용X
                .authorizeRequests().antMatchers("/api/v1/member/**","/api/v1/todo/**").authenticated()//인증된 사용자만 넘어갈 수 있도록 구현
                .and()
                .formLogin()
                .loginPage("/api/v1/member/login")
                .loginProcessingUrl("/api/v1/member/login")
                .usernameParameter("loginId")
                .passwordParameter("password")
                .defaultSuccessUrl("/api/v1/member/login/success")
                .failureUrl("/api/v1/member/login/fail")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/api/v1/member/logout")
                .logoutSuccessUrl("/api/v1/logout/success")
                .invalidateHttpSession(true);
        //쿠키값을 가지고 있으면 제한한 url에 접근할때 로그인창 없이 접할 수 있다.
        http.rememberMe()
                .key("remember")//토큰에 사용되는 키값
                .rememberMeParameter("remember-login")//파라미터 이름
                .tokenValiditySeconds(43200 * 30)//15일 설정
                .userDetailsService(memberService);
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
