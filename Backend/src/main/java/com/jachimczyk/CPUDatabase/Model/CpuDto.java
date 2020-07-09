package com.jachimczyk.CPUDatabase.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CpuDto
{
    @JsonProperty("id")
    private Long id;
    private String model;
    private float clockSpeed;
    private int coreNumber;
    private int threadNumber;
    private int tdp;
    private float price;
    private String brand;
    private Long socket;

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

    public Long getSocket()
    {
        return socket;
    }

    public void setSocket(Long socket)
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

    public CpuDto() {}

    public CpuDto(Cpu cpu)
    {
        this.id = cpu.getId();
        this.model = cpu.getModel();
        this.clockSpeed = cpu.getClockSpeed();
        this.coreNumber = cpu.getCoreNumber();
        this.threadNumber = cpu.getThreadNumber();
        this.tdp = cpu.getTdp();
        this.price = cpu.getPrice();
        this.brand = cpu.getBrand();
        this.socket = cpu.getSocket().getId();
    }

    public Cpu toCpu()
    {
        Cpu cpu = new Cpu();
        cpu.setBrand(brand);
        cpu.setClockSpeed(clockSpeed);
        cpu.setCoreNumber(coreNumber);
        cpu.setModel(model);
        cpu.setPrice(price);
        cpu.setTdp(tdp);
        cpu.setThreadNumber(threadNumber);

        return cpu;
    }
}
