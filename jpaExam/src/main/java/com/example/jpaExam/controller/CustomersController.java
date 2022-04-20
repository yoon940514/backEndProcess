package com.example.jpaExam.controller;

import com.example.jpaExam.domain.entity.Address;
import com.example.jpaExam.domain.entity.Customers;
import com.example.jpaExam.domain.service.CustomersService;
import com.example.jpaExam.form.CustomersForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping(value = "/customer/new")
    public String createForm(Model model) {
        model.addAttribute("customersForm", new CustomersForm());
        return "customers/createMemberForm";
    }
    @PostMapping(value = "/customer/new")   // 유효성 검사 추가. 빈칸일시 오류 발생하도록 폼객체에 생성
    public String create(@Valid CustomersForm customersForm, BindingResult result) {
        if (result.hasErrors()) {
            return "customers/createMemberForm";
        }
        Address address = new Address(customersForm.getCity(), customersForm.getStreet(), customersForm.getZipcode());
        Customers member = new Customers();
        member.setName(customersForm.getName());
        member.setAddress(address);
        member.setPhoneNumber(customersForm.getPhoneNumber());
        member.setCompany(customersForm.getCompany());
        customersService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/customers")
    public String list(Model model) {
        List<Customers> customers = customersService.findcustomers();
        model.addAttribute("customers", customers);
        return "customers/customersList";
    }
}