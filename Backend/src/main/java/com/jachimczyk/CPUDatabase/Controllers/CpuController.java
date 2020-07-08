package com.jachimczyk.CPUDatabase.Controllers;

import com.jachimczyk.CPUDatabase.Model.Cpu;
import com.jachimczyk.CPUDatabase.Model.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/cpu")
@RestController
public class CpuController
{
    @Autowired
    CpuRepository cpuRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpStatus Add(@RequestBody Cpu cpu)
    {
        try
        {
            cpuRepository.save(cpu);
            System.out.println("Received data: " + cpu.toString());

            return HttpStatus.OK;
        }
        catch (Exception e)
        {
            System.out.println(e);

            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @GetMapping(path = "/all")
    public Iterable<Cpu> GetAll()
    {
        Iterable<Cpu> cpus = cpuRepository.findAll();
//        for (Cpu c:cpus)
//        {
//            System.out.println(c.toString());
//        }

        return cpus;
    }
}

