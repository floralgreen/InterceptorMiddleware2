package esercizioDevelhope.InterceptorMiddleware2.controllers;

import esercizioDevelhope.InterceptorMiddleware2.services.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    BasicService basicService;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok(basicService.sayHello()); //finire
    }

}
