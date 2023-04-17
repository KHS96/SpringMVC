package hellop.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="RequestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] -start");
        req.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] -end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터]");
        String[] names = req.getParameterValues("name");
        for (String s : names) {
            System.out.println(s);
        }

        resp.getWriter().write("ok");
    }
}
