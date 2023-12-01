package model.entities;

import model.entities.enums.WorkerLevel;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> hourContractList = new ArrayList<>();

    public Worker(){}
    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getHourContractList() {
        return hourContractList;
    }

    public void addContract(HourContract contract){
        hourContractList.add(contract);
    }

    public void removeContract(HourContract contract){
        hourContractList.remove(contract);
    }

    public Double income(Integer year, Integer month){
        Double sum = 0.0;
       for (HourContract contract : hourContractList){
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           String dateString = contract.getDate().format(dtf);
           String[] dateVect = dateString.split("/");
           int yearDate = Integer.parseInt(dateVect[2]);
           int monthDate = Integer.parseInt(dateVect[1]);
           if (year == yearDate && month == monthDate){
               sum += contract.totalValue();
           }
       }
       return sum;
    }



}
