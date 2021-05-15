/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpayroll;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public abstract class EmloyeePaySlip {

    public EmloyeePaySlip() {
    }

    public EmloyeePaySlip(Employee employee, double totalHoursWorked) {
        this.employee = employee;
        this.totalHrsWork = totalHoursWorked;
    }
    private Employee employee;
    protected double totalHrsWork;
    protected static final double FULLTIME_HOURS = 160;
    protected static final double TAX_FREE_ALLOWANCE = 2500;

    public Employee getEmployee() {
        return employee;
    }

    public double getSurcharge() {
        if (getGrossSalary() > 3000) {
            return 33;
        } else {
            return 19.20;
        }
    }

    public double getTax() {
        if (getGrossSalary() < TAX_FREE_ALLOWANCE) {
            return 0;
        }
        return (getGrossSalary() - TAX_FREE_ALLOWANCE) * 0.25;

    }

    public double getDeductions() {
        return getTax() + getSurcharge();
    }

    public double getNetSalary() {
        return getGrossSalary() - getDeductions();
    }

    public abstract double getHurRate();

    public abstract double getGrossSalary();

    @Override
    public String toString() {
        return ("hourly pay=> " + getHurRate() + " \n" + "hrs worked=> " + totalHrsWork + " \n"
                + "Gross SAL=> " + getGrossSalary() + " \n" + "DEDUCTION=> " + getTax() + " \n" + " Surcharge => " + getSurcharge() + " \n"
                + "NetSAL=> " + getNetSalary() + " \n");
    }

}
