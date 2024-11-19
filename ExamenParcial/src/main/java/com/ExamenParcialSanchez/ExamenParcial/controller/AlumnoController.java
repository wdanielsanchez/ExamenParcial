package com.ExamenParcialSanchez.ExamenParcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ExamenParcialSanchez.ExamenParcial.model.AlumnoModel;
import com.ExamenParcialSanchez.ExamenParcial.services.AlumnoService;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    // Método para listar alumnos
    @GetMapping("/index")
    public ModelAndView FindAll() {
        ModelAndView lista = new ModelAndView("index");
        try {
            lista.addObject("alumnos", alumnoService.findAll());
            lista.addObject("alumno", new AlumnoModel());
            lista.addObject("action", "/alumno/create");
        } catch (Exception e) {
            lista.addObject("error", "Error al obtener la lista de alumnos: " + e.getMessage());
        }
        return lista;
    }

    // Método para crear un alumno
    @PostMapping("/create")
    public String create(@ModelAttribute("alumno") AlumnoModel model) {
        try {
            alumnoService.add(model);
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación al crear: " + e.getMessage());
            return "redirect:/alumno/index?error=DatosInvalidos";
        } catch (Exception e) {
            System.err.println("Error inesperado al crear: " + e.getMessage());
            return "redirect:/alumno/index?error=ErrorCreacion";
        }
        return "redirect:/alumno/index";
    }

    // Método para editar un alumno
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView editView = new ModelAndView("index");
        try {
            AlumnoModel alumno = alumnoService.findById(id);
            editView.addObject("alumno", alumno);
            editView.addObject("alumnos", alumnoService.findAll());
            editView.addObject("action", "/alumno/update/" + id); // Cambia el action del formulario
        } catch (Exception e) {
            editView.addObject("error", "Error al buscar el alumno: " + e.getMessage());
        }
        return editView;
    }

    // Método para actualizar un alumno
    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute("alumno") AlumnoModel model) {
        try {
            model.setIdAlumno(id);
            alumnoService.update(model);
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación al actualizar: " + e.getMessage());
            return "redirect:/alumno/index?error=DatosInvalidos";
        } catch (Exception e) {
            System.err.println("Error inesperado al actualizar: " + e.getMessage());
            return "redirect:/alumno/index?error=ErrorActualizacion";
        }
        return "redirect:/alumno/index";
    }

    // Método para eliminar un alumno
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        try {
            alumnoService.delete(id);
        } catch (IllegalArgumentException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return "redirect:/alumno/index?error=AlumnoInexistente";
        } catch (Exception e) {
            System.err.println("Error inesperado al eliminar: " + e.getMessage());
            return "redirect:/alumno/index?error=ErrorEliminacion";
        }
        return "redirect:/alumno/index";
    }
}
