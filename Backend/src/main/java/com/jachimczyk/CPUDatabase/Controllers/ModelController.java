package com.jachimczyk.CPUDatabase.Controllers;

import com.jachimczyk.CPUDatabase.Model.Model;
import com.jachimczyk.CPUDatabase.Model.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/model")
@RestController
public class ModelController
{
    @Autowired
    ModelRepository modelRepository;

    @PostMapping(path = "/add")
    public HttpStatus Add(@ModelAttribute Model model)
    {
        try
        {
            modelRepository.save(model);

            return HttpStatus.OK;
        }
        catch (Exception e)
        {
            System.out.println(e);

            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @GetMapping(path = "/all")
    public Iterable<Model> Models()
    {
        return modelRepository.findAll();
    }
}

