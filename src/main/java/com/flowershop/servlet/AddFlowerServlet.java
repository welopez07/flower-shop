package com.flowershop.servlet;

import com.flowershop.model.Flower;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addFlower")
public class AddFlowerServlet extends HttpServlet {

    private static SessionFactory factory;

    @Override
    public void init() throws ServletException {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Flower flower = new Flower();
        flower.setName(name);
        flower.setDescription(description);
        flower.setPrice(price);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(flower);
        session.getTransaction().commit();

        List<Flower> flowers = session.createQuery("from Flower", Flower.class).list();
        session.close();

        request.setAttribute("flowers", flowers);

        request.getRequestDispatcher("flowers.jsp").forward(request,response);
    }

    @Override
    public void destroy() {
        factory.close();
    }

}
