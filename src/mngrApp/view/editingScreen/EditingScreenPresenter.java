package mngrApp.view.editingScreen;

import javafx.scene.control.CheckBox;
import mngrApp.model.Benefit;
import mngrApp.model.employee.Employee;
import mngrApp.model.employee.HourlyEmployee;
import mngrApp.model.employee.SalariedEmployee;
import mngrApp.model.management.Company;
import mngrApp.view.mainScreenView.CompanyAppPresenter;
import mngrApp.view.mainScreenView.CompanyAppView;

public class EditingScreenPresenter {

    private final EditingScreenView view;
    private final Company model;
    private final Employee employee;

    public EditingScreenPresenter(Company model, EditingScreenView view, Employee employee) {
        this.model = model;
        this.view = view;
        this.employee = employee;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getConfirmButton().setOnAction(clicked -> validateForm());
        view.getCancelButton().setOnAction(clicked -> switchBackToMainScreen());
    }

    private void updateView() {
        if (employee instanceof SalariedEmployee) {
            view.layoutForSalariedEmployee();
        } else {
            view.layoutForHourlyEmployee();
        }
        for (Benefit b : employee.getBenefitList()) {
            for (int i = 0; i < view.getBenefitCheckBoxes().length; i++) {
                if (b.getValue().equals(view.getBenefitCheckBoxes()[i].getText())) {
                    view.getBenefitCheckBoxes()[i].setSelected(true);
                }
            }
        }
        view.getEmployeeName().setText(employee.getName() + " " + employee.getLastName());
    }

    private void validateForm() {
        final String fieldHighlight = "-fx-border-color: red";
        if (!view.getManagerIDField().getText().equals("")) {
            try {
                employee.setManagerID(Long.parseLong(view.getManagerIDField().getText()));
            } catch (NumberFormatException e) {
                view.getManagerIDField().setStyle(fieldHighlight);
            }
        }

        if (!view.getSalaryField().getText().equals("")) {
            try {
                model.updateSalary(employee, Double.parseDouble(view.getSalaryField().getText()));
            } catch (NumberFormatException e) {
                view.getSalaryField().setStyle(fieldHighlight);
            }
        }

        if (view.getJobTitleComboBox().getValue() != null) {
            employee.setJobTitle(view.getJobTitleComboBox().getValue());
        }

        if (!view.getDailyHoursField().getText().equals("")) {
            HourlyEmployee emp = (HourlyEmployee) employee;
            try {
                emp.setDailyWorkedHours(Double.parseDouble(view.getDailyHoursField().getText()));
            } catch (NumberFormatException e) {
                view.getDailyHoursField().setStyle(fieldHighlight);
            }
        }

        if (!view.getYearlyBonusField().getText().equals("")) {
            SalariedEmployee emp = (SalariedEmployee) employee;
            emp.setYearlyBonus(Double.parseDouble(view.getYearlyBonusField().getText()));
        }

        for (CheckBox cb : view.getBenefitCheckBoxes()) {
            if (cb.isSelected()) {
                employee.addBenefit(Benefit.getEnum(cb.getText()));
            } else {
                employee.removeBenefit(Benefit.getEnum(cb.getText()));
            }
        }
        switchBackToMainScreen();
    }

    private void switchBackToMainScreen() {
        CompanyAppView mainView = new CompanyAppView();
        new CompanyAppPresenter(model, mainView);
        view.getScene().setRoot(mainView);
        mainView.getScene().getWindow();
    }
}
