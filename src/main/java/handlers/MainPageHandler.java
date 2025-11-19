// /src/main/java/handler/MainPageHandler.java
package handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPageHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        return "main";  // 리다이렉션이므로 뷰 페이지는 null 반환
    }
}
