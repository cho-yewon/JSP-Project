package handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommuniationListHandler implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        return "communication_post_list";  // 리다이렉션이므로 뷰 페이지는 null 반환
    }
}