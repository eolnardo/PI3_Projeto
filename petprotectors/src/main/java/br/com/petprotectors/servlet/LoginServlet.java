package br.com.petprotectors.servlet;

import br.com.petprotectors.dao.ClienteDao;
import br.com.petprotectors.model.Cliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Cliente cliente = new Cliente(email, senha);

        boolean isValidUser = new ClienteDao().verifyCredentials(cliente);

        if (isValidUser) {

            req.getSession().setAttribute("loggedUser", email);

            resp.sendRedirect("show-cliente");

        } else {

            req.setAttribute("message", "E-mail ou senha inválidos!");

            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }

    }
}
