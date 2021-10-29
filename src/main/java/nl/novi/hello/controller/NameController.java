package nl.novi.hello.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class NameController {

    private List<String> names = new ArrayList<String>();
    public NameController() {
        names.add("Dave");
        names.add("Tanja");
        names.add("Emrys");
    }

    @GetMapping(value = "/names")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getNames() {
        return names;
    }

    @GetMapping(value = "/names/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getName(@PathVariable int id) {
        return names.get(id);
    }

    @DeleteMapping(value = "/names/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteName(@PathVariable int id) {
        names.remove(id);
        return "Name was deleted from the list";
    }

    @PostMapping(value = "/names")
    @ResponseStatus(HttpStatus.CREATED)
    public String addName(@RequestBody String name){
        names.add(name);
        return name + " was added to the list";
    }

}