package com.example.playas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.playas.model.Playa;
import com.example.playas.service.PlayaService;

@Controller
public class PlayaController {

    @Autowired
    private PlayaService playaService;

    // Método para mostrar la vista HTML con la lista de playas
    @GetMapping("/playas")
    public String mostrarPlayas(Model model) {
        List<Playa> playas = playaService.getAllPlayas();
        model.addAttribute("playas", playas);
        return "playas"; // Devuelve el nombre de la vista (playas.html)
    }

    // Método para obtener todas las playas en formato JSON
    @GetMapping("/json")
    public ResponseEntity<List<Playa>> getAllPlayas() {
        List<Playa> playas = playaService.getAllPlayas();
        return new ResponseEntity<>(playas, HttpStatus.OK);
    }

    // Método para agregar una nueva playa
    @PostMapping
    public ResponseEntity<Playa> addPlaya(@RequestBody Playa playa) {
        Playa createdPlaya = playaService.addPlaya(playa);
        return new ResponseEntity<>(createdPlaya, HttpStatus.CREATED);
    }


    @PostMapping("/agregarPlaya")
    public String agregarPlaya(@RequestParam("nombre") String nombre,
                            @RequestParam("ubicacion") String ubicacion,
                            @RequestParam("descripcion") String descripcion) {
    Playa nuevaPlaya = new Playa();
    nuevaPlaya.setNombre(nombre);
    nuevaPlaya.setUbicacion(ubicacion);
    nuevaPlaya.setDescripcion(descripcion);
    
    playaService.addPlaya(nuevaPlaya);
    
    return "redirect:/playas"; // Redirigir a la página de listado de playas
        }

    @DeleteMapping("/eliminarPlaya/{id}")
    public String eliminarPlaya(@PathVariable String id) {
        playaService.eliminarPlaya(id);
        return "redirect:/playas"; // Redirige a la página de listado de playas
    }



}
