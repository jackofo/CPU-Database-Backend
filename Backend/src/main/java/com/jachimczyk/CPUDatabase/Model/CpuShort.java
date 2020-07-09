package com.jachimczyk.CPUDatabase.Model;

import javax.persistence.Column;

public class CpuShort
{
    private Long id;
    private String model;
    private String brand;
    private Long socket;

    public CpuShort(){}
    public CpuShort(Cpu cpu)
    {
        this.brand = cpu.getBrand();
        this.model = cpu.getModel();
        this.socket = cpu.getSocket().getId();
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

    public Long getSocket()
    {
        return socket;
    }

    public void setSocket(Long socket)
    {
        this.socket = socket;
    }
    //</editor-fold>
}
