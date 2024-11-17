package com.ExamenParcialSanchez.ExamenParcial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ExamenParcialSanchez.ExamenParcial.model.AlumnoModel;
import com.ExamenParcialSanchez.ExamenParcial.services.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    
    @Autowired
    AlumnoService alumnoService;
    
    @GetMapping("/index")
    public ModelAndView FindAll()
    {
        ModelAndView lista = new ModelAndView("index");
        lista.addObject("alumnos", alumnoService.findAll());
        lista.addObject("alumno", new AlumnoModel ());
        lista.addObject("action","/alumno/create");
        return lista;
    }
    
     @PostMapping("/create")
    public String create(@ModelAttribute("alumno") AlumnoModel model) {
        alumnoService.add(model);
        return "redirect:/alumno/index";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView editView = new ModelAndView("index");
        AlumnoModel alumno = alumnoService.findById(id);
        editView.addObject("alumno", alumno);
        editView.addObject("alumnos", alumnoService.findAll());
        editView.addObject("action", "/alumno/update/" + id); // Cambia el action del formulario
        return editView;
    }

    // update
    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute("alumno") AlumnoModel model) {
        model.setIdAlumno(id);
        alumnoService.update(model);
        return "redirect:/alumno/index";
    }

    // delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        alumnoService.delete(id);
        return "redirect:/alumno/index";
    }



}
