package com.jachimczyk.CPUDatabase.Model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "CPUs")
public class Cpu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private float clockSpeed;
    private int coreNumber;
    private int threadNumber;
    private int tdp;
    private float price;
    private String brand;

    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne
    private Socket socket;

    //<editor-fold desc="Getters & Setters">
    public Long getId()
    {
        return id;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
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

    @Override
    public String toString()
    {
        return "Cpu{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", clockSpeed=" + clockSpeed +
                ", coreNumber=" + coreNumber +
                ", threadNumber=" + threadNumber +
                ", tdp=" + tdp +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", socket=" + socket.toString() +
                '}';
    }
}
