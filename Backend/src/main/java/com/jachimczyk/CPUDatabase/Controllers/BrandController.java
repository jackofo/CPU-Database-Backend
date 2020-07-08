package com.jachimczyk.CPUDatabase.Controllers;

import com.jachimczyk.CPUDatabase.Model.Brand;
import com.jachimczyk.CPUDatabase.Model.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/brand")
@RestController
public class BrandController
{
    @Autowired
    BrandRepository brandRepository;

    @PostMapping(path = "/add")
    public HttpStatus Add(@ModelAttribute Brand brand)
    {
        try
        {
            brandRepository.save(brand);

            return HttpStatus.OK;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
