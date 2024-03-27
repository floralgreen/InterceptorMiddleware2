package esercizioDevelhope.InterceptorMiddleware2.controllers;

import esercizioDevelhope.InterceptorMiddleware2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping("/find")
    public ResponseEntity<Month> getMonth(HttpServletRequest request){
        Month month = (Month) request.getAttribute("month");

        return ResponseEntity.ok(month);
    }

}
