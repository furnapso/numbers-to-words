package io.github.furnapso.numberstowordsbackend;

import io.github.furnapso.numberstowordsbackend.model.Response;
import io.github.furnapso.numberstowordsbackend.parse.NumberToWordParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@SpringBootApplication
@RestController
public class NumbersToWordsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumbersToWordsBackendApplication.class, args);
    }

    @GetMapping("/convert")
    public ResponseEntity<Response<String>> convertNumber(@RequestParam BigDecimal number) {
        try {
            var result = new NumberToWordParser(number).parse();
            return ResponseEntity.ok(Response.<String>builder().status("Success").data(result).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Response.<String>builder().status("Error").data(e.getMessage()).build());
        }
    }
}
