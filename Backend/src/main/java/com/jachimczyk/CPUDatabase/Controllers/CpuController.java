package com.jachimczyk.CPUDatabase.Controllers;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.jachimczyk.CPUDatabase.Model.Cpu;
import com.jachimczyk.CPUDatabase.Model.CpuRepository;
import com.jachimczyk.CPUDatabase.Model.CpuShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
    public Iterable<CpuShort> GetAll()
    {
        Collection<Cpu> cpus = (Collection) cpuRepository.findAll();
        ArrayList<CpuShort> cpusShort = new ArrayList<CpuShort>();
        for (Cpu c : cpus)
        {
            cpusShort.add(new CpuShort(c));
        }

        return cpusShort;
    }
}

