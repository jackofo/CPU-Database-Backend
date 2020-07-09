package com.jachimczyk.CPUDatabase.Model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Sockets")
@Table(name="Sockets")
public class Socket
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "socket")
    private Set<Cpu> cpu;

    //<editor-fold desc="Getters & Setters">
    public Long getId()
    {
        return id;
    }

    public void setId(int id)
    {
        id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    //</editor-fold>


    @Override
    public String toString()
    {
        return "Socket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
