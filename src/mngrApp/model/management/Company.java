package mngrApp.model.management;

import mngrApp.model.Benefit;
import mngrApp.model.JobTitle;
import mngrApp.model.employee.Employee;
import mngrApp.model.employee.HourlyEmployee;
import mngrApp.model.employee.SalariedEmployee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company {

    private final List<Employee> employeeList = new ArrayList<>();

    public Company() {
        generateEmployees();
    }

    public void hireNewEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void dismissEmployee(Employee employee) {
        try {
            employeeList.remove(employee);
        } catch (NullPointerException e) {
            System.out.println("Employee \"" + employee + "\" could not be found.");
        }
    }

    public void updateSalary(Employee employee, double salary) {
        employee.setSalary(salary);
    }

    // this method is used to fill the employee list
    private void generateEmployees() {
        SalariedEmployee s1 = new SalariedEmployee("Jack", "Sparrow",
                694506, 100, JobTitle.ASSISTANT_MANAGER,
                new Date(), 65750.90, 100.00,
                List.of(Benefit.HEALTH_INSURANCE, Benefit.DENTAL_INSURANCE));

        HourlyEmployee h2 = new HourlyEmployee("Kevin", "Cooper", 604507,
                101, 12.75, 6.5, JobTitle.ASSOCIATE, new Date(),
                List.of(Benefit.HEALTH_INSURANCE, Benefit.COMPANY_CAR));

        HourlyEmployee h1 = new HourlyEmployee("Alex", "McKinney", 694507,
                101, 10.50, 8.5, JobTitle.INTERN, new Date(), null);

        SalariedEmployee s2 = new SalariedEmployee("Jessica", "Hamilton",
                494506, 100, JobTitle.ASSOCIATE,
                new Date(), 42750.90, 50.00,
                List.of(Benefit.HEALTH_INSURANCE, Benefit.DENTAL_INSURANCE));

        SalariedEmployee s3 = new SalariedEmployee("Sam", "Arrington",
                101, 100, JobTitle.DIRECTOR, new Date(), 78575.45, 550,
                List.of(Benefit.HEALTH_INSURANCE, Benefit.DENTAL_INSURANCE, Benefit.VISION_INSURANCE,
                        Benefit.LIFE_INSURANCE, Benefit.RETIREMENT_BENEFITS));

        employeeList.add(h1);
        employeeList.add(h2);
        employeeList.add(s1);
        employeeList.add(s2);
        employeeList.add(s3);
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }
}
