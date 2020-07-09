package com.jachimczyk.CPUDatabase.Controllers;

import com.jachimczyk.CPUDatabase.Model.Cpu;
import com.jachimczyk.CPUDatabase.Model.CpuDto;
import com.jachimczyk.CPUDatabase.Model.CpuShort;
import com.jachimczyk.CPUDatabase.Model.Socket;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/cpu")
@RestController
public class CpuController
{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpStatus Add(@RequestBody CpuDto cpuDto)
    {
        try
        {
            Cpu cpu = cpuDto.toCpu();
            if (cpuDto.getId() != null)
            {
                cpu.setId(cpuDto.getId());
            }
            cpu.setSocket(entityManager.find(Socket.class, cpuDto.getSocket()));
            entityManager.merge(cpu);
            entityManager.flush();
            System.out.println("Received data: " + cpu.toString());

            return HttpStatus.OK;
        }
        catch (Exception e)
        {
            System.out.println(e);

            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Transactional
    @GetMapping(path = "/delete")
    public HttpStatus Delete(@RequestParam Long id)
    {
        try
        {
            Cpu cpu = entityManager.find(Cpu.class, id);
            entityManager.remove(cpu);
            System.out.println("Removed: " + cpu.toString());

            return HttpStatus.OK;
        }
        catch (Exception e)
        {
            System.out.println(e);

            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Transactional
    @GetMapping(path = "/get")
    public CpuDto Get(@RequestParam Long id)
    {
        return new CpuDto(entityManager.find(Cpu.class, id));
    }

    @Transactional
    @GetMapping(path = "/all")
    public List<CpuShort> GetAll()
    {
        List<Cpu> cpus = entityManager.createQuery("SELECT c FROM CPUs c").getResultList();
        ArrayList<CpuShort> cpusShort = new ArrayList<>();
        for (Cpu c : cpus)
        {
            cpusShort.add(new CpuShort(c));
        }

        return cpusShort;
    }
}

