package mngrApp.view.hiringScreenView;

import javafx.scene.control.Alert;
import mngrApp.model.employee.HourlyEmployee;
import mngrApp.model.employee.SalariedEmployee;
import mngrApp.model.management.Company;
import mngrApp.view.mainScreenView.CompanyAppPresenter;
import mngrApp.view.mainScreenView.CompanyAppView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class HiringScreenPresenter {

    private final Company model;
    private final HiringScreenView view;

    public HiringScreenPresenter(Company model, HiringScreenView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getConfirmButton().setOnAction(clicked -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Registration Error");
            if (isFormOK()) {
                finalizeHiringProcess();
                switchBackToMainScreen();
            } else {
                alert.setHeaderText("Invalid form. Please review the form then submit again.");
                alert.showAndWait();
            }
        });
        view.getCancelButton().setOnAction(clicked -> switchBackToMainScreen());
    }

    private void updateView() {

    }

    private boolean isFormOK() {
        return ((checkNameFields() && checkIDFields()) && (employeeDetails() && checkDate()));
    }

    private void finalizeHiringProcess() {
        if (view.getSalariedEmpButton().isSelected()) {
            model.hireNewEmployee(new SalariedEmployee(view.getNameField().getText(),
                    view.getLastNameField().getText(), Integer.parseInt(view.getEmpIDField().getText()),
                    Integer.parseInt(view.getManagerIDField().getText()),
                    view.getDropdownTitleMenu().getValue(),
                    Date.from(view.getDatePicker().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    Double.parseDouble(view.getSalaryField().getText()), 0,
                    new ArrayList<>()));

        } else if (view.getHourlyEmpButton().isSelected()) {
            model.hireNewEmployee(new HourlyEmployee(view.getNameField().getText(),
                    view.getLastNameField().getText(), Integer.parseInt(view.getEmpIDField().getText()),
                    Integer.parseInt(view.getManagerIDField().getText()), Double.parseDouble(view.getSalaryField().getText()),
                    8, view.getDropdownTitleMenu().getValue(),
                    Date.from(view.getDatePicker().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    new ArrayList<>()));
        }
    }

    private void switchBackToMainScreen() {
        CompanyAppView mainView = new CompanyAppView();
        new CompanyAppPresenter(model, mainView);
        view.getScene().setRoot(mainView);
        mainView.getScene().getWindow();
    }

    private boolean checkNameFields() {
        if (view.getNameField().getText().equals("")) {
            view.getNameField().setStyle("-fx-border-color: red");
            return false;
        } else if (view.getLastNameField().getText().equals("")) {
            view.getLastNameField().setStyle("-fx-border-color: red");
            return false;
        }
        return true;
    }

    private boolean checkIDFields() {
        try {
            Long.parseLong(view.getEmpIDField().getText());
        } catch (NumberFormatException e) {
            view.getEmpIDField().setStyle("-fx-border-color: red");
            return false;
        }

        try {
            Long.parseLong(view.getManagerIDField().getText());
        } catch (NumberFormatException e) {
            view.getManagerIDField().setStyle("-fx-border-color: red");
            return false;
        }
        return true;
    }

    private boolean employeeDetails() {
        if (view.getDropdownTitleMenu().getValue() == null) {
            view.getDropdownTitleMenu().setStyle("-fx-border-color: red");
            return false;
        } else if (!view.getSalariedEmpButton().isSelected() && !view.getHourlyEmpButton().isSelected()) {
            view.getSalariedEmpButton().setStyle("-fx-border-color: red");
            view.getHourlyEmpButton().setStyle("-fx-border-color: red");
            return false;
        } else {
            try {
                Double.parseDouble(view.getSalaryField().getText());
            } catch (NumberFormatException e) {
                view.getSalaryField().setStyle("-fx-border-color: red");
                return false;
            }
        }
        return true;
    }

    private boolean checkDate() {
        LocalDate now = LocalDate.now();
        if (view.getDatePicker().getValue().isBefore(now)) {
            Alert dateAlert = new Alert(Alert.AlertType.WARNING);
            dateAlert.setTitle("Invalid Date");
            dateAlert.setHeaderText("Start date cannot be in the past.");
            dateAlert.showAndWait();
            view.getDatePicker().setStyle("-fx-border-color: red");
            return false;
        }
        return true;
    }
}
