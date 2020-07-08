package com.jachimczyk.CPUDatabase.Model;

import org.hibernate.annotations.Cascade;

import javax.persistence.ManyToOne;

public class CpuShort
{
    private Long id;
    private String model;
    private String brand;
    private Socket socket;

    public CpuShort(){}
    public CpuShort(Cpu cpu)
    {
        this.brand = cpu.getBrand();
        this.model = cpu.getModel();
        this.socket = cpu.getSocket();
        this.id = cpu.getId();
    }

    //<editor-fold desc="Getters & Setters">
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
    //</editor-fold>
}
