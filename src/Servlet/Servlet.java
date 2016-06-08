package Servlet;

import DAO.Dao;
import Data.User;
import Data.Distance;
import Data.compet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().isEmpty()) {
            request.getRequestDispatcher("table.jsp").forward(request, response);
        }
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    request.setAttribute("user", new Dao().getUserById(Integer.parseInt(request.getParameter("id"))));
                    request.getRequestDispatcher("edit.jsp").forward(request, response);
                    break;
                case "editDist":
                    request.setAttribute("user", new Dao().getUserById(Integer.parseInt(request.getParameter("id"))));
                    request.getRequestDispatcher("editDist.jsp").forward(request, response);
                    break;
                case "editComp":
                    request.setAttribute("user", new Dao().getUserById(Integer.parseInt(request.getParameter("id"))));
                    request.getRequestDispatcher("editComp.jsp").forward(request, response);
                    break;
                case "addUser":
                    request.getRequestDispatcher("add.jsp").forward(request, response);
                    break;
                case "addDist":
                    request.getRequestDispatcher("addDist.jsp").forward(request, response);
                    break;
                case "addComp":
                    request.getRequestDispatcher("addComp.jsp").forward(request, response);
                    break;
                case "saveUser":
                    User u;
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String email = request.getParameter("email");
                    Integer age = Integer.parseInt(request.getParameter("age"));
                    Integer numb = Integer.parseInt(request.getParameter("number"));
                    Integer series = Integer.parseInt(request.getParameter("series"));
                    if (request.getParameter("id") == null) {
                        u = new User(name, email, surname, age, numb, series);
                        try {
                            new Dao().addUser(u);
                        } catch (Exception e) {
                        }

                    } else {
                        Integer id1 = Integer.parseInt(request.getParameter("id"));
                        u = new User(id1, name, email, surname, age, numb, series);
                        try {
                            new Dao().updateUser(u);
                        } catch (Exception e) {
                        }
                    }
                    response.sendRedirect("/");
                    break;
                case "saveDist":
                    Distance d;
                    String style = request.getParameter("style");
                    Integer distance = Integer.parseInt(request.getParameter("dist"));
                    Integer distwater = Integer.parseInt(request.getParameter("distwater"));
                    if (request.getParameter("id") == null) {
                        d = new Distance(style, distance, distwater);
                        try {
                            new Dao().addDistance(d);
                        } catch (Exception e) {
                        }
                    } else {
                        Integer id1 = Integer.parseInt(request.getParameter("id"));
                        d = new Distance(id1, style, distance, distwater);
                        try {
                            new Dao().updateDistance(d);
                        } catch (Exception e) {
                        }
                    }
                    break;
                case "saveComp":
                    compet c;
                    String name1 = request.getParameter("name");
                    String city = request.getParameter("city");
                    String ref = request.getParameter("ref");
                    if (request.getParameter("id") == null) {
                        c = new compet(name1, city, ref);
                        try {
                            new Dao().addCompetition(c);
                        } catch (Exception e) {}
                    } else {
                        Integer id1 = Integer.parseInt(request.getParameter("id"));
                        c = new compet(id1, name1, city, ref);
                        try {
                            new Dao().updateCompetition(c);
                        } catch (Exception e) {
                        }
                        break;
                    }
                case "delete":
                            if (request.getParameter("id").length() > 1) {
                                String id = request.getParameter("id");
                                String chunks[] = id.trim().split(" ");
                                for (int i = 0; i < chunks.length; i++) {
                                    new Dao().deleteUser(Integer.parseInt(chunks[i]));
                                }
                            } else {
                                new Dao().deleteUser(Integer.parseInt(request.getParameter("id")));
                            }
                            if (request.getParameter("id") == null) {
                                response.sendRedirect("/");
                            }
                            response.sendRedirect("/");
                            break;
                case "deleteDist":
                    if (request.getParameter("id").length() > 1) {
                        String id = request.getParameter("id");
                        String chunks[] = id.trim().split(" ");
                        for (int i = 0; i < chunks.length; i++) {
                            new Dao().deleteDistance(Integer.parseInt(chunks[i]));
                        }
                    } else {
                        new Dao().deleteDistance(Integer.parseInt(request.getParameter("id")));
                    }
                    if (request.getParameter("id") == null) {
                        response.sendRedirect("/");
                    }
                    response.sendRedirect("/");
                    break;
                case "deleteComp":
                    if (request.getParameter("id").length() > 1) {
                        String id = request.getParameter("id");
                        String chunks[] = id.trim().split(" ");
                        for (int i = 0; i < chunks.length; i++) {
                            new Dao().deleteCompetition(Integer.parseInt(chunks[i]));
                        }
                    } else {
                        new Dao().deleteCompetition(Integer.parseInt(request.getParameter("id")));
                    }
                    if (request.getParameter("id") == null) {
                        response.sendRedirect("/");
                    }
                    response.sendRedirect("/");
                    break;
                case "showUser":
                    request.getRequestDispatcher("showUser.jsp").forward(request,response);
                    break;
                case "showDist":
                    request.getRequestDispatcher("showDist.jsp").forward(request,response);
                    break;
                case "showComp":
                    request.getRequestDispatcher("showComp.jsp").forward(request,response);
                    break;
                }
            }
        }
    }

