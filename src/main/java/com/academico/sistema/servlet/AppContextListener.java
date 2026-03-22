package com.academico.sistema.servlet;

import com.academico.sistema.service.GerenciadorAlunos;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos(0);
        sce.getServletContext().setAttribute("gerenciador", gerenciador);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}