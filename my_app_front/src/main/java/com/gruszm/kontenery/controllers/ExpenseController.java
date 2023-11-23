package com.gruszm.kontenery.controllers;

import com.gruszm.kontenery.entities.Expense;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController
{
    @Value("${my.app.rest.api.host}")
    private String host;

    @Value("${my.app.rest.api.port}")
    private String port;

    @GetMapping
    public String getAllExpenses(Model model)
    {
        String url = "http://" + host + ":" + port + "/api/expenses";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Expense[]> expensesResponse = restTemplate.getForEntity(url, Expense[].class);
        List<Expense> expenses = Arrays.asList(expensesResponse.getBody());
        model.addAttribute("expenses", expenses);
        return "expenses/show-expenses";
    }
}
