/*
package Config;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LastModelAndViewInterceptor extends HandlerInterceptorAdapter {

    //public static final String LAST_MODEL_VIEW = LastModelAndViewInterceptor.class.getName()+".lastModelAndView";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception{
      //  request.getSession(true).setAttribute(LAST_MODEL_VIEW, modelAndView);
        //super.postHandle(request,response,handler,modelAndView);
        System.out.println("PostHandle start..");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Inside PreHandler");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception) throws Exception {
        System.out.println("Inside after completion");
    }
}*/
