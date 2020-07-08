package com.jachimczyk.CPUDatabase.Controllers;

import com.jachimczyk.CPUDatabase.Model.Socket;
import com.jachimczyk.CPUDatabase.Model.SocketRepository;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/socket")
@RestController
public class SocketController
{
    @Autowired
    SocketRepository socketRepository;

    @PostMapping(path = "/add")
    public HttpStatus Add(@ModelAttribute Socket socket)
    {
        try
        {
            socketRepository.save(socket);
            System.out.println(Time.now() + "Received data: " + socket.toString());

            return HttpStatus.OK;
        }
        catch (Exception e)
        {
            System.out.println(e);

            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @GetMapping(path = "/all")
    public Iterable<Socket> GetAll()
    {
        return socketRepository.findAll();
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Socket Get(@RequestParam Long id)
    {
        return socketRepository.findById(id).get();
    }
}
