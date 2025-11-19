// /src/main/java/controller/ControllerServlet.java
package controller;

import handlers.CommandHandler;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@WebServlet(urlPatterns = "*.do", initParams = {@WebInitParam(name = "initParam", value = "/WEB-INF/commandHandler.properties")})
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

    // 초기화 시 properties 파일을 읽어 핸들러 매핑
    public void init(ServletConfig config) throws ServletException {
        String configFile = config.getInitParameter("initParam");
        String configFilePath = config.getServletContext().getRealPath(configFile);

        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            prop.load(fis);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        // properties 파일을 읽어서 요청과 핸들러를 매핑
        Iterator<Object> keyIter = prop.keySet().iterator();
        while (keyIter.hasNext()) {
            String command = (String) keyIter.next();
            String handlerClassName = prop.getProperty(command);

            try {
                Class<?> handlerClass = Class.forName(handlerClassName);
                CommandHandler handlerInstance = (CommandHandler) handlerClass.getDeclaredConstructor().newInstance();
                commandHandlerMap.put(command, handlerInstance);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }

    // GET 요청 처리
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // POST 요청 처리
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 요청에 맞는 핸들러를 찾아 처리하는 메소드
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 URI에서 명령어 추출
        String command = request.getRequestURI();
        command = command.substring(request.getContextPath().length() + 1);

        // 핸들러 찾기
        CommandHandler handler = commandHandlerMap.get(command);

        // 핸들러가 있으면 요청 처리 후 뷰 페이지로 이동
        if (handler != null) {
            String viewPage = null;
			try {
				viewPage = handler.process(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/" + viewPage + ".jsp");
            rd.forward(request, response);
        } else {
            // 핸들러가 없으면 에러 페이지로 이동
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

