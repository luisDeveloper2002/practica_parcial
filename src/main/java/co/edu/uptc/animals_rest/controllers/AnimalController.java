package co.edu.uptc.animals_rest.controllers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.edu.uptc.animals_rest.models.Animal;
import co.edu.uptc.animals_rest.services.AnimalService;




@RestController
@RequestMapping("/animal")
public class AnimalController {

 private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);

   @Autowired
    private AnimalService animalService;


    @GetMapping("/all")
    public List<Animal> getAnimalAll() throws IOException {
        logger.info("getAnimalAll called");
        return animalService.getAnimalAll();
    }

    @GetMapping("/range")
    public List<Animal> getAnimal(@RequestParam int from, @RequestParam int to) throws IOException {
        logger.info("getAnimal called with parameters: from = {}, to = {}", from, to);
        return animalService.getAnimalInRange(from, to);
    }
    @GetMapping("/category/{category}")
    public List<Animal> getAnimalByCategory(@PathVariable String category) throws IOException {
        logger.info("getAnimalByCategory called with category: {}", category);
        return animalService.getAnimalByCategory(category);
    }

    @GetMapping("/name-length/{length}")
    public List<Animal> getAnimalByNameLength(@PathVariable int length) throws IOException {
        logger.info("getAnimalByNameLength called with length: {}", length);
        return animalService.getAnimalByNameLength(length);
    }


}
