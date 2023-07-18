//package com.example.unia.api.service;
//
//import com.example.unia.api.dto.KakaoApiResponseDto;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.URI;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class KakaoCategorySearchService {
//
//    private final KakaoUriBuilderService kakaoUriBuilderService;
//    private final RestTemplate restTemplate;
//
//    private static final String RESTAURANT_CATEGORY = "FD6";
//
//    @Value("${kakao.rest.api.key}")
//    private String kakaoRestApiKey;
//
//    public KakaoApiResponseDto requestRestaurantCategorySearch(double latitude, double longitude, double radius){
//        URI uri = kakaoUriBuilderService.buildUriByCategorySearch(latitude, longitude, radius, RESTAURANT_CATEGORY);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(HttpHeaders.AUTHORIZATION, "KakaoAK " + kakaoRestApiKey);
//        HttpEntity httpEntity = new HttpEntity<>(headers);
//
//        return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, KakaoApiResponseDto.class).getBody();
//    }
//
//
//}