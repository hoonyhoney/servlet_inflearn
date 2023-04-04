package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name= "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("-------REQUEST-LINE -start----");
        System.out.println(request.getMethod());
        System.out.println(request.getProtocol());
        System.out.println(request.getScheme());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(request.getQueryString());
        System.out.println(request.isSecure());
        System.out.println("--- REQUEST-LINE -end---");

        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    private void printEtc(HttpServletRequest request) {
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemotePort());
        System.out.println(request.getLocalName());
        System.out.println(request.getLocalAddr());
        System.out.println(request.getLocalPort());

    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());
        System.out.println(request.getLocale());
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + cookie.getValue());
            }
        }
    }

    private void printHeaders(HttpServletRequest request){
        System.out.println("-------Headers -start----");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println("headerName = " + headerName);
        }

        System.out.println("--- Headers  -end---");
    }
}
