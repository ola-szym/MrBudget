//package com.project.subcategory;
//
//import com.project.services.BudgetService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = {"/api/*"})
//public class BudgetServlet extends HttpServlet {
//
//    private static final String BUDGET_NAME_PARAM = "name";
//
//    private final Logger logger = LoggerFactory.getLogger(BudgetServlet.class);
//
//    private BudgetService service;
//
//    /**
//     * Server container needs it
//     */
//    @SuppressWarnings("unused")
//    public BudgetServlet(){
//        this(new BudgetService());
//    }
//
//    BudgetServlet(BudgetService service){
//        this.service = service;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.info("Got request with:" + req.getParameterMap());
//        resp.getWriter().write(service.getBudgetName(BUDGET_NAME_PARAM));
//    }
//}
//
