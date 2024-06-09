package org.example.httpheadersofrestapi;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HttpHeadersSampleController {

    @GetMapping("/readHttpHeaders")
    public String readHttpHeaders(@RequestHeader Map<String,Object> headers) {

        System.out.println("headers :- "+headers);
        if(headers.get("name").equals("Amit")){
            System.out.println("headers are being read correctly");
        }
        else{
            System.out.println("not able to read headers");
        }
        return "reading http headers";
    }

    @GetMapping("/setHttpHeaders")
    public String readHttpHeaders(HttpServletResponse headersResponse) {

        System.out.println("headers response  :- "+headersResponse);
        headersResponse.setHeader("Name", "Aamir");
        return "setting http  headers response ";
    }

    @GetMapping("/responseEntity")
    public ResponseEntity<String> settingHttpResponseHeader() {

       HttpHeaders  headers = new HttpHeaders();
       headers.set("Name" ,"Ravi");
       return ResponseEntity.ok()
               .headers(headers)
               .body("setting up the http response headers");
    }



}
