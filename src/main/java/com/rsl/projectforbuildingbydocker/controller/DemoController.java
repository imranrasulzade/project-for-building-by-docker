package com.rsl.projectforbuildingbydocker.controller;

import com.rsl.projectforbuildingbydocker.entity.Demo;
import com.rsl.projectforbuildingbydocker.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DemoController {
    private final DemoRepository demoRepository;

    @GetMapping("demos")
    public List<Demo> getAllDemos() {
        return demoRepository.findAll();
    }

    @GetMapping("/api/demos/{id}")
    public Demo getDemoById(@PathVariable Integer id) {
        return demoRepository.findById(id).orElseThrow(()-> new RuntimeException("NO DATA FOUND"));
    }

    @PostMapping("/api/demos")
    @ResponseStatus(HttpStatus.CREATED)
    public Demo createDemo(@RequestBody Demo demo) {
        return demoRepository.save(demo);
    }

    @DeleteMapping("/api/demos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDemo(@PathVariable Integer id) {
        demoRepository.deleteById(id);
    }

    @PutMapping("/api/demos/{id}")
    public Demo updateDemo(@PathVariable Integer id, @RequestBody Demo demoDetails) {
        demoDetails.setId(id);
        return demoRepository.save(demoDetails);
    }

}

