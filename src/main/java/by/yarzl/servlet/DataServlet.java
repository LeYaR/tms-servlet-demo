package by.yarzl.servlet;

import by.yarzl.service.DataService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/data")
// Сервлет не отвечает за валидацию данных, только запрос-ответ/код ошибки
public class DataServlet extends HttpServlet {

    private final static Logger LOG = Logger.getLogger(DataServlet.class.getName());
    private final DataService dataService;

    public DataServlet() {
        dataService = new DataService();
    }

    // Запрос вида GET http://localhost:8080/servlet_demo_war/data
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(dataService.getAllEntitiesForResponse());
        writer.close();
    }

    /* Запрос вида POST http://localhost:8080/servlet_demo_war/data
    Body:
    {
        "name": "test"
    }
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        try {
            dataService.addEntity(body);
        } catch (IOException e) {
            LOG.warning(e.getMessage());
            resp.setStatus(400);
        }
    }

    // Запрос вида DELETE http://localhost:8080/servlet_demo_war/data?id=3
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            dataService.deleteEntity(id);
        } catch (Exception e) {
            LOG.warning(e.getMessage());
            resp.setStatus(400);
        }
    }
}
