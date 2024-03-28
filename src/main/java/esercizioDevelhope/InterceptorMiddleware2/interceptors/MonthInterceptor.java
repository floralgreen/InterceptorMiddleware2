package esercizioDevelhope.InterceptorMiddleware2.interceptors;

import esercizioDevelhope.InterceptorMiddleware2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.query.sqm.mutation.internal.Handler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {


    private final List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1, "january", "gennaio", "januar"),
            new Month(3, "march", "marzo", "marz"),
            new Month(5, "May", "maggio", "mai"),
            new Month(7, "July", "luglio", "juli"),
            new Month(9, "September", "settembre", "september"),
            new Month(11, "november", "novembre", "november")
    ));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //recupero l'header se esiste
        String monthNumberHeader = request.getHeader("monthNumber");

        //se è null o stringa vuota ritorno bad request
        if(monthNumberHeader == null || monthNumberHeader.isEmpty()){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "monthNumber is null or empty!");
            return false;
        }

        //altrimenti faccio il cast a int e utilizzo la funzione findMonthByNumber in maniera veloce
        Integer monthNumberInt = Integer.parseInt(monthNumberHeader);
        Month monthFound = findMonthByNumber(monthNumberInt);

        //ritorno l'attribute con il mese selezionato altrimenti nope se non è presente e ritorno lo status OK 200
        request.setAttribute("month", monthFound);
        response.setStatus(HttpServletResponse.SC_OK);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    public Month findMonthByNumber(Integer monthNumber){
        for (Month currentMonth: months) {
            if (currentMonth.getMonthNumber().equals(monthNumber)){
                return currentMonth;
            }
        }
        return new Month(null,"nope","nope","nope");
    }

}
