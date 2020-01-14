package pl.krysinski.motoapp.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krysinski.motoapp.dao.entity.Motorbike;
import pl.krysinski.motoapp.manager.MotorbikeManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/motorbikes")
public class MotorbikeApi {

    private MotorbikeManager motorbikes;
//    private List<Motorbike> motorbikes;
//
//    public MotorbikeApi(){
//        motorbikes = new ArrayList<>();
//        motorbikes.add(new Motorbike(1L, "Suzuki GS500", LocalDate.of(2005, 1, 1)));
//        motorbikes.add(new Motorbike(2L, "Ducati Pannigale V4", LocalDate.of(2019, 4, 3)));
//        motorbikes.add(new Motorbike(3L, "Suzuki GSXR 750", LocalDate.of(2018, 2, 23)));
//    }

    @Autowired
    public MotorbikeApi(MotorbikeManager motorbikes) {
        this.motorbikes = motorbikes;
    }

//    @GetMapping("/all")
//    public List<Motorbike> getAll() {
//        return motorbikes;
//    }

    @GetMapping("/all")
    public Iterable<Motorbike> getAll() {
        return motorbikes.findAll();
    }


//    @GetMapping
//    public Motorbike getById(@RequestParam int index) {
//        Optional<Motorbike> first = motorbikes.stream().
//                filter(element -> element.getId() == index).findFirst();
//        return first.get();
//    }

    @GetMapping
    public Optional<Motorbike> getById(@RequestParam Long index) {
        return motorbikes.findById(index);
    }

    @PostMapping
    public Motorbike addMotorbike(@RequestBody Motorbike motorbike) {
        return motorbikes.save(motorbike);
    }

    @PutMapping
    public Motorbike updateMotorbike(@RequestBody Motorbike motorbike) {
        return motorbikes.save(motorbike);
    }

    @DeleteMapping
    public void deleteMotorbike(@RequestParam Long index) {
        motorbikes.deleteById(index);
    }
}
