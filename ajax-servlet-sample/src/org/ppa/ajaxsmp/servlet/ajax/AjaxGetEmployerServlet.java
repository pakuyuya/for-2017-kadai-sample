package org.ppa.ajaxsmp.servlet.ajax;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ppa.ajaxsmp.entity.Employer;
import org.ppa.ajaxsmp.service.EmployerService;
import org.ppa.ajaxsmp.service.mock.EmployerServiceMock;

import com.google.gson.Gson;

/**
 * idで指定した従業員データを返却します。<br>
 * <br>
 * [method] GET<br>
 * <br>
 * @param id  必須。従業員ID。
 *
 * @return <pre>JSON形式のレスポンス。
 * {
 *   id          : string 従業員ID
 *   family_name : string 苗字
 *   first_name  : string 名前
 *   since       : string 勤務開始日。yyyy-mm-dd
 * }
 *
 * idに紐づく従業員情報が見つからなかった場合はnull
 * </pre>
 *
 */
@WebServlet(name="AjaxGetEmployerServlet", urlPatterns={"/ajax/getEmployer"})
public class AjaxGetEmployerServlet extends HttpServlet {

    private EmployerService employerService = null;

    @Override
    public void init() {
        employerService = new EmployerServiceMock();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // common

        String id = req.getParameter("id");

        // validation

        List<String> errors = new ArrayList<>();
        if (id == null) {
            errors.add("parameter `id` required.");
        }

        if (!errors.isEmpty()) {
            // bad request
            res.sendError(400);
            return;
        }

        // get emploayer
        Employer employer = employerService.findById(id);
        if (employer == null) {
            // not found
            res.sendError(404);
            return;
        }

        // response entiy
        String json = buildJson(employer);
        res.setHeader("Content-type", "application/json; charset=utf-8");
        res.getWriter().write(json);
    }

    private String buildJson(Employer employer) {
        Map<String, Object> jsonMap = new HashMap<>();

        if (employer.getId() != null) {
            jsonMap.put("id", employer.getId());
        }
        if (employer.getFamilyName() != null) {
            jsonMap.put("family_name", employer.getFamilyName());
        }
        if (employer.getFirstName() != null) {
            jsonMap.put("first_name", employer.getFirstName());
        }
        if (employer.getSince() != null) {
            SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
            jsonMap.put("since", sfd.format(employer.getSince()));
        }

        return new Gson().toJson(jsonMap);
    }
}
