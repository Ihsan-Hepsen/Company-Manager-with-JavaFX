package mngrApp.view.editingScreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mngrApp.model.Benefit;
import mngrApp.model.JobTitle;

public class EditingScreenView extends VBox {

    private Label heading;
    private Label employeeName;
    private Label employeeType;
    private Label managerIDLabel;
    private TextField managerIDField;
    private Label titleLabel;
    private ComboBox<JobTitle> jobTitleComboBox;
    private Label benefitLabel;
    private HBox benefitContainer;
    private VBox benefitList1;
    private VBox benefitList2;
    private Label salaryLabel;
    private TextField salaryField;
    private Label yearlyBonusLabel;
    private TextField yearlyBonusField;
    private Label dailyHoursLabel;
    private TextField dailyHoursField;
    private Button confirmButton;
    private Button cancelButton;

    private final CheckBox cb1 = new CheckBox(Benefit.HEALTH_INSURANCE.toString());
    private final CheckBox cb2 = new CheckBox(Benefit.LIFE_INSURANCE.toString());
    private final CheckBox cb3 = new CheckBox(Benefit.DENTAL_INSURANCE.toString());
    private final CheckBox cb4 = new CheckBox(Benefit.VISION_INSURANCE.toString());
    private final CheckBox cb5 = new CheckBox(Benefit.RETIREMENT_BENEFITS.toString());
    private final CheckBox cb6 = new CheckBox(Benefit.COMPANY_CAR.toString());

    public EditingScreenView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        heading = new Label("EDIT EMPLOYEE");
        employeeName = new Label();
        employeeType = new Label();
        managerIDLabel = new Label("New Manager ID");
        managerIDField = new TextField();
        titleLabel = new Label("New Job Title");
        jobTitleComboBox = new ComboBox<>();
        benefitLabel = new Label("Benefits");
        salaryLabel = new Label("New Salary");
        salaryField = new TextField();
        yearlyBonusLabel = new Label("Yearly Bonus");
        yearlyBonusField = new TextField();
        dailyHoursLabel = new Label("Daily Working Hours");
        dailyHoursField = new TextField();
        confirmButton = new Button("Apply Changes");
        cancelButton = new Button("Cancel");
        benefitContainer = new HBox();
        benefitList1 = new VBox();
        benefitList2 = new VBox();
    }

    private void layoutNodes() {
        fillDropdownTitleMenu();
        benefitList1.getChildren().addAll(cb1, cb2, cb3);
        benefitList2.getChildren().addAll(cb4, cb5, cb6);
        benefitContainer.getChildren().addAll(benefitList1, benefitList2);

        jobTitleComboBox.setMaxWidth(200.0);
        cancelButton.setMaxWidth(200.0);
        confirmButton.setMaxWidth(200.0);
        salaryField.setMaxWidth(200.0);
        dailyHoursField.setMaxWidth(200.0);
        managerIDField.setMaxWidth(200.0);
        yearlyBonusField.setMaxWidth(200.0);
        benefitContainer.setMaxWidth(450.0);

        benefitList1.setSpacing(6.3);
        benefitList2.setSpacing(6.3);
        benefitContainer.setSpacing(5.0);
        benefitContainer.setAlignment(Pos.CENTER);

        setMargin(employeeType, new Insets(0 , 0, 35.0, 0));
        setMargin(confirmButton, new Insets(25.0 , 0, 0, 0));
        this.setAlignment(Pos.CENTER);
        this.setSpacing(8.0);

        // some styling code
        heading.setStyle("-fx-font-size: 35; -fx-font-family: 'Verdana'");
        employeeName.setStyle("-fx-font-size: 25; -fx-font-family: 'Verdana'; -fx-text-fill: #17057d");
        employeeType.setStyle("-fx-font-size: 15; -fx-font-family: 'Verdana'; -fx-text-fill: #8b0579");
        confirmButton.setStyle("-fx-font-size: 15; -fx-background-color: #1b467b; -fx-border-color: none; " +
                "-fx-text-fill: white; -fx-font-family: 'Verdana'");
        cancelButton.setStyle("-fx-font-size: 15; -fx-background-color: #ce2547; -fx-border-color: none; " +
                "-fx-text-fill: white; -fx-font-family: 'Verdana'");
    }

    // package private
    void layoutForSalariedEmployee() {
        employeeType.setText("- Salaried Employee -");
        this.getChildren().addAll(heading, employeeName, employeeType, managerIDLabel, managerIDField,
                titleLabel, jobTitleComboBox, salaryLabel, salaryField,
                yearlyBonusLabel, yearlyBonusField, benefitLabel, benefitContainer, confirmButton, cancelButton);
    }

    void layoutForHourlyEmployee() {
        employeeType.setText("- Hourly Employee -");
        this.getChildren().addAll(heading, employeeName, employeeType, managerIDLabel, managerIDField,
                titleLabel, jobTitleComboBox, salaryLabel, salaryField, dailyHoursLabel, dailyHoursField,
                benefitLabel, benefitContainer, confirmButton, cancelButton);
    }

    Label getEmployeeName() {
        return employeeName;
    }

    TextField getManagerIDField() {
        return managerIDField;
    }

    TextField getSalaryField() {
        return salaryField;
    }

    ComboBox<JobTitle> getJobTitleComboBox() {
        return jobTitleComboBox;
    }

    TextField getYearlyBonusField() {
        return yearlyBonusField;
    }

    TextField getDailyHoursField() {
        return dailyHoursField;
    }

    CheckBox[] getBenefitCheckBoxes() {
        return new CheckBox[] {cb1, cb2, cb3, cb4, cb5, cb6};
    }

    Button getConfirmButton() {
        return confirmButton;
    }

    Button getCancelButton() {
        return cancelButton;
    }

    private void fillDropdownTitleMenu() {
        jobTitleComboBox.getItems().add(JobTitle.INTERN);
        jobTitleComboBox.getItems().add(JobTitle.ASSOCIATE);
        jobTitleComboBox.getItems().add(JobTitle.ASSISTANT_MANAGER);
        jobTitleComboBox.getItems().add(JobTitle.MANAGER);
        jobTitleComboBox.getItems().add(JobTitle.DIRECTOR);
        jobTitleComboBox.getItems().add(JobTitle.GENERAL_PRESIDENT);
        jobTitleComboBox.getItems().add(JobTitle.SUPERVISOR);
        jobTitleComboBox.getItems().add(JobTitle.VICE_PRESIDENT);
        jobTitleComboBox.getItems().add(JobTitle.CEO);
    }
}
