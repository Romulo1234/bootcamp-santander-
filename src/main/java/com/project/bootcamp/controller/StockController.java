package com.project.bootcamp.controller;

        import com.project.bootcamp.mode.dto.StockDTO;
        import com.project.bootcamp.service.stockservice;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.ArrayList;
        import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private stockservice service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){

        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO >> findall( ){
        List<StockDTO> list= new ArrayList<>();
                return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(service.findById(id));
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< StockDTO>delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(service.findByToday());
    }

}