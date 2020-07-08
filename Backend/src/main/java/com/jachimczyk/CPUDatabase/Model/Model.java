package com.jachimczyk.CPUDatabase.Model;

import javax.persistence.*;

@Entity
@Table(name = "Models")
public class Model
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float clockSpeed;
    private int coreNumber;
    private int threadNumber;
    private int tdp;
    private float price;

    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Socket socket;

    //<editor-fold desc="Getters & Setters">
    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public void setBrand(Brand brand)
    {
        this.brand = brand;
    }

    public Socket getSocket()
    {
        return socket;
    }

    public void setSocket(Socket socket)
    {
        this.socket = socket;
    }

    public float getClockSpeed()
    {
        return clockSpeed;
    }

    public void setClockSpeed(float clockSpeed)
    {
        this.clockSpeed = clockSpeed;
    }

    public int getCoreNumber()
    {
        return coreNumber;
    }

    public void setCoreNumber(int coreNumber)
    {
        this.coreNumber = coreNumber;
    }

    public int getThreadNumber()
    {
        return threadNumber;
    }

    public void setThreadNumber(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }

    public int getTdp()
    {
        return tdp;
    }

    public void setTdp(int tdp)
    {
        this.tdp = tdp;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }
    //</editor-fold>
}
