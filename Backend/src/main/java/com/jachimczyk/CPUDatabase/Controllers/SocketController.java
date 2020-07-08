package com.jachimczyk.CPUDatabase.Controllers;

import com.jachimczyk.CPUDatabase.Model.Socket;
import com.jachimczyk.CPUDatabase.Model.SocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

            return HttpStatus.OK;
        }
        catch (Exception e)
        {
            System.out.println(e);

            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
