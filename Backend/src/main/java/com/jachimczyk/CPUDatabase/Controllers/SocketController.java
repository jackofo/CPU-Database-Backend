package com.jachimczyk.CPUDatabase.Controllers;

import com.jachimczyk.CPUDatabase.Model.Socket;
import org.apache.tomcat.jni.Time;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/socket")
@RestController
public class SocketController
{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path = "/add")
    public HttpStatus Add(@ModelAttribute Socket socket)
    {
        try
        {
            entityManager.persist(socket);
            System.out.println(Time.now() + "Received data: " + socket.toString());

            return HttpStatus.OK;
        }
        catch (Exception e)
        {
            System.out.println(e);

            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Transactional
    @GetMapping(path = "/all")
    public List<Socket> GetAll()
    {
        return entityManager.createQuery("SELECT s FROM Sockets s").getResultList();
    }

    @Transactional
    @CrossOrigin("http://localhost:4200")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Socket Get(@RequestParam Long id)
    {
        return entityManager.find(Socket.class, id);
    }
}
