package com.tcs.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.food.model.Pantry;
import com.tcs.food.repository.PantryRepository;

@Service
public class PantryService  {

    @Autowired
    private PantryRepository pantryRepository;

    public Pantry addPantry(Pantry pantry) {
        pantry.setCreatedAt(java.time.LocalDateTime.now());
        return pantryRepository.save(pantry);
    }

    public List<Pantry> getAllPantries() {
        return pantryRepository.findAll();
    }

    public Pantry getPantryById(Long pantryId) {
        Optional<Pantry> optional = pantryRepository.findById(pantryId);
        return optional.orElse(null);
    }
} 