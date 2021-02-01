package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author allin1230
 */
@SpringBootApplication
public class SpringlearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringlearnApplication.class, args);
    }


    public void m1() {

        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        DeferredResult forObject1 = template.getForObject("http://localhost:8080/get/{v1}", DeferredResult.class, "12");


        String uriTemplate = "https://example.com/hotels/{hotel}";
        URI uri = UriComponentsBuilder.fromUriString(uriTemplate).build(42);

        RequestEntity<Void> requestEntity = RequestEntity.get(uri)
                .header("MyRequestHeader", "MyValue")
                .build();

        ResponseEntity<String> response = template.exchange(requestEntity, String.class);

        String responseHeader = response.getHeaders().getFirst("MyResponseHeader");
        String body = response.getBody();


    }
}
