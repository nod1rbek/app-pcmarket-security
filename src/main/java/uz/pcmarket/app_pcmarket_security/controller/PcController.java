package uz.pcmarket.app_pcmarket_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pcmarket.app_pcmarket_security.entity.Pc;
import uz.pcmarket.app_pcmarket_security.repository.PcRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/pc")
public class PcController {

    @Autowired
    PcRepository pcRepository;

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Pc pc) {
        return ResponseEntity.ok(pcRepository.save(pc));
    }

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR','OPERATOR ')")
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(pcRepository.findAll());
    }

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR','OPERATOR ')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Optional<Pc> optionalPc = pcRepository.findById(id);
        Pc pc = null;
        if (optionalPc.isPresent()) {
            pc = optionalPc.get();
            return ResponseEntity.ok(pc);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(pc);
    }

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody Pc pc) {
        Optional<Pc> optionalPc = pcRepository.findById(id);
        Pc save = null;
        if (optionalPc.isPresent()) {
            Pc editing = optionalPc.get();
            editing.setModel(pc.getModel());
            editing.setName(pc.getName());
            editing.setPrice(pc.getPrice());
            editing.setScreenSize(pc.getScreenSize());
            editing.setHdd(pc.getHdd());
            editing.setRam(pc.getRam());

            save = pcRepository.save(editing);
            return ResponseEntity.ok(save);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(save);
    }

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        pcRepository.deleteById(id);
        return ResponseEntity.ok(200);
    }
}
