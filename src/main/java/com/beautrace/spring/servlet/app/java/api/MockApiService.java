package com.beautrace.spring.servlet.app.java.api;

import com.beautrace.spring.servlet.app.java.service.MockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MockApiService {

    private final MockService mockService;

    public MockApiService(MockService mockService) {
        this.mockService = mockService;
    }

    @GetMapping(path = "/mock")
    public Boolean doApiWork(
      @RequestParam(required = false) Integer argOne,
      @RequestParam(required = false) String argTwo
    ) {
        mockService.doWork();
        return true;
    }

    @GetMapping(path = "/exception")
    public Boolean doWorkWithException(
      @RequestParam(required = false) Integer argOne,
      @RequestParam(required = false) String argTwo
      ) throws IllegalStateException {
        mockService.doWork();
        throw new IllegalStateException("exception!");
    }
}
