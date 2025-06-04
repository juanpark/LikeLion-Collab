package com.lab01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp") // ✅ Base path added back
public class EmpController {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private DeptRepository deptRepository;

    // 1. Redirect root of /emp to /emp/list
    @GetMapping("/")
    public String redirectToList() {
        return "redirect:/emp/list";
    }

    // 2. /emp/list - 전체 사원 목록 및 부서 목록
    @GetMapping("/list")
    public String getAll(Model model) {
        List<Emp> emps = empRepository.findAll();
        List<Dept> depts = deptRepository.findAll();
        model.addAttribute("emps", emps);
        model.addAttribute("depts", depts);
        return "emp/list"; // templates/emp/list.html
    }

    // 3. /emp/new - 사원 등록 폼
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("emp", new Emp());
        model.addAttribute("depts", deptRepository.findAll());
        return "emp/new"; // templates/emp/new.html
    }

    // 4. /emp [POST] - 사원 등록 처리
    @PostMapping
    public String create(@ModelAttribute Emp emp) {
        empRepository.save(emp);
        return "redirect:/emp/list";
    }

    // 5. /emp/{empno} - 사원 상세 조회
    @GetMapping("/{empno}")
    public String getById(@PathVariable int empno, Model model) {
        Emp emp = empRepository.findById(empno).orElse(null);
        model.addAttribute("emp", emp);
        return "emp/detail"; // templates/emp/detail.html
    }

    // 6. /emp/{empno}/edit - 사원 수정 화면
    @GetMapping("/{empno}/edit")
    public String editForm(@PathVariable int empno, Model model) {
        Emp emp = empRepository.findById(empno).orElse(null);
        model.addAttribute("emp", emp);
        model.addAttribute("deptList", deptRepository.findAll());
        return "emp/edit"; // templates/emp/edit.html
    }

    // 7. /emp/{empno}/edit [POST] - 사원 수정 처리
    @PostMapping("/{empno}/edit")
    public String update(@PathVariable int empno, @ModelAttribute Emp empDetails) {
        Emp emp = empRepository.findById(empno).orElse(null);
        if (emp != null) {
            emp.setEname(empDetails.getEname());
            emp.setJob(empDetails.getJob());
            emp.setSal(empDetails.getSal());
            emp.setDept(empDetails.getDept());
            empRepository.save(emp);
        }
        return "redirect:/emp/list";
    }

    // 8. /emp/{empno}/delete [POST] - 사원 삭제 처리
    @PostMapping("/{empno}/delete")
    public String delete(@PathVariable int empno) {
        empRepository.deleteById(empno);
        return "redirect:/emp/list";
    }
}