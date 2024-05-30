package com.example.playas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.playas.model.Playa;
import com.example.playas.repository.PlayaRepository;

@Service
public class PlayaService {

    @Autowired
    private PlayaRepository playaRepository;

    public List<Playa> getAllPlayas() {
        return playaRepository.findAll();
    }

    public void eliminarPlaya(String id) {
        playaRepository.deleteById(id);
    }
    
    public Playa addPlaya(Playa playa) {
        return playaRepository.save(playa);
    }
    
}
