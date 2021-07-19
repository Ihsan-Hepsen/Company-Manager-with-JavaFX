package mngrApp.model.employee;

import mngrApp.model.Benefit;
import mngrApp.model.JobTitle;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

public class HourlyEmployee extends Employee {

    private double dailyWorkedHours;

    public HourlyEmployee(String name, String lastName, long employeeID, long managerID, double hourlyRate,
                          double dailyWorkedHours, JobTitle title, Date startDate, List<Benefit> benefitList) {
        super(name, lastName, employeeID, managerID, title, startDate, benefitList);
        super.setSalary(hourlyRate);
        this.dailyWorkedHours = dailyWorkedHours;
    }

    public double getDailyWorkedHours() {
        return dailyWorkedHours;
    }

    public void setDailyWorkedHours(double hours) {
        this.dailyWorkedHours = hours;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDaily Hours : " + dailyWorkedHours + " hours" +
                "\nSalary      : " + NumberFormat.getCurrencyInstance().format(getSalary()) + "/hour " +
                "\nPayroll     : Hourly Rate\n";
    }
}
