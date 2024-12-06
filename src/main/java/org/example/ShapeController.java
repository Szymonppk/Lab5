package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shapes")
public class ShapeController {

    private final ShapeService shapeService;


    @Autowired
    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }


    @GetMapping
    public List<Shape> getAllShapes() {
        return shapeService.getAllShapes();
    }


    @PostMapping
    public Shape createShape(@RequestBody Shape shape) {
        return shapeService.saveShape(shape);
    }
}
