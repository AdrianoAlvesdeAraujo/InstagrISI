package com.ServerSpring.Instagrao.controller;


import com.ServerSpring.Instagrao.models.Instagrao;
import com.ServerSpring.Instagrao.repository.InstagraoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class InstagraoController {

    @Autowired
    private InstagraoRepository _instagraoRepository;

    @RequestMapping(value= "/lista", method= RequestMethod.GET)
    public List<Instagrao> Get(){

        return _instagraoRepository.findAll();
    }

    @RequestMapping(value= "/lista/{id}", method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<Instagrao>GetById(@PathVariable(value = "id")long id)
    {
        Optional<Instagrao> instagrao = _instagraoRepository.findById(id);
        if(instagrao.isPresent())
            return new ResponseEntity<Instagrao>(instagrao.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/lista", method=RequestMethod.POST, produces="application/json", consumes="application/json")
    public Instagrao Post(@Valid @RequestBody Instagrao instagrao)
    {
        return _instagraoRepository.save(instagrao);
    }


   @RequestMapping(value = "/likes/{id}", method =RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<Instagrao> Put(@PathVariable(value = "id") long id)
    {
        Optional<Instagrao> oldInstagrao = _instagraoRepository.findById(id);
        if(oldInstagrao.isPresent()){

            Instagrao instagraoz = oldInstagrao.get();
           instagraoz.setLikes(instagraoz.getLikes()+1);
            _instagraoRepository.save(instagraoz);
            return new ResponseEntity<Instagrao>(instagraoz, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}


