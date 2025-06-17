package com.tcs.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.food.dto.FoodInventoryDTO;
import com.tcs.food.model.Pantry;
import com.tcs.food.service.FoodInventoryService;
import com.tcs.food.service.PantryService;

@RestController
@RequestMapping("/api/admin")
public class AdminFoodController {

    @Autowired
    private PantryService pantryService;

    @Autowired
    private FoodInventoryService foodInventoryService;

    @PostMapping("/pantry")
    public ResponseEntity<Pantry> addPantry(@RequestBody Pantry pantry) {
        Pantry created = pantryService.addPantry(pantry);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/pantries")
    public ResponseEntity<List<Pantry>> getAllPantries() {
        List<Pantry> pantries = pantryService.getAllPantries();
        return ResponseEntity.ok(pantries);
    }

    @GetMapping("/pantry/{id}")
    public ResponseEntity<Pantry> getPantryById(@PathVariable Long id) {
        Pantry pantry = pantryService.getPantryById(id);
        if (pantry != null) {
            return ResponseEntity.ok(pantry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/inventory")
    public ResponseEntity<FoodInventoryDTO> updateInventory(@RequestBody FoodInventoryDTO inventoryDTO) {
        FoodInventoryDTO updated = foodInventoryService.updateInventory(inventoryDTO);
        return ResponseEntity.ok(updated);
    }
}
