package mngrApp.model.employee;

import mngrApp.model.Benefit;
import mngrApp.model.JobTitle;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

public class SalariedEmployee extends Employee {

    private double yearlyBonus;

    public SalariedEmployee(String name, String lastName, long employeeID, long managerID,
                            JobTitle title, Date startDate, double salary, double yearlyBonus, List<Benefit> benefitList) {
        super(name, lastName, employeeID, managerID, title, startDate, benefitList);
        this.setSalary(salary);
        this.yearlyBonus = yearlyBonus;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nYearly Bonus: " + NumberFormat.getCurrencyInstance().format(yearlyBonus) +
                "\nSalary      : " + NumberFormat.getCurrencyInstance().format(this.getSalary()) +
                "\nPayroll     : Salaried Employee\n";
    }

    public void setYearlyBonus(double bonus) {
        this.yearlyBonus = bonus;
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

}
