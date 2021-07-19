package mngrApp.model.employee;

import mngrApp.model.Benefit;
import mngrApp.model.JobTitle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Employee {

    private final String name;
    private final String lastName;
    private final long employeeID;
    private long managerID;
    private JobTitle title;
    private double salary;
    private final Date startDate;
    private final List<Benefit> benefitList;

    public Employee(String name, String lastName, long employeeID, long managerID,
                    JobTitle title, Date startDate, List<Benefit> benefitList) {
        this.name = name;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.managerID = managerID;
        this.title = title;
        this.startDate = startDate;
        this.benefitList = benefitList == null? new ArrayList<>() : new ArrayList<>(benefitList);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public long getManagerID() {
        return managerID;
    }

    public void setManagerID(long managerID) {
        this.managerID = managerID;
    }

    public void setJobTitle(JobTitle title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Benefit> getBenefitList() {
        return benefitList;
    }

    public void addBenefit(Benefit benefit) {
        if (!benefitList.contains(benefit)) {
            benefitList.add(benefit);
        }
    }

    public void removeBenefit(Benefit benefit) {
        benefitList.remove(benefit);
    }

    private String printBenefitList() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Benefit b : benefitList) {
            sb.append("\n").append(i).append("- ").append(b.toString());
            ++i;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return "Employee Information\n" +
                "-------------------" +
                "\nName        : " + name +
                "\nLast Name   : " + lastName +
                "\nEmployee ID : " + employeeID +
                "\nManager ID  : " + managerID +
                "\nJob Title   : " + title +
                "\nStart Date  : " + dateFormat.format(startDate) +
                "\nBenefits    : " + (benefitList.size() > 0 ? printBenefitList() : "NO BENEFITS");
    }
}
