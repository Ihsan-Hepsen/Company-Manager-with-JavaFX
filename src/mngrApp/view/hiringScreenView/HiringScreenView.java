package mngrApp.view.hiringScreenView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mngrApp.model.JobTitle;

public class HiringScreenView extends VBox {

    private Label nameLabel;
    private TextField nameField;
    private Label lastNameLabel;
    private TextField lastNameField;
    private Label empIDLabel;
    private TextField empIDField;
    private Label managerIDLabel;
    private TextField managerIDField;
    private Label titleLabel;
    private ComboBox<JobTitle> dropdownTitleMenu;
    private RadioButton salariedEmpButton;
    private RadioButton hourlyEmpButton;
    private HBox radioContainer;
    private Label salaryLabel;
    private TextField salaryField;
    private Label startDateLabel;
    private DatePicker datePicker;
    private Button confirmButton;
    private Button cancelButton;


    public HiringScreenView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        nameLabel = new Label("Name");
        nameField = new TextField();
        lastNameLabel = new Label("Last Name");
        lastNameField = new TextField();
        empIDLabel = new Label("Employee ID");
        empIDField = new TextField();
        managerIDLabel = new Label("Manager ID");
        managerIDField = new TextField();
        titleLabel = new Label("Job Title");
        dropdownTitleMenu = new ComboBox<>();
        salariedEmpButton = new RadioButton("Salaried Employee");
        hourlyEmpButton = new RadioButton("Hourly Employee");
        ToggleGroup tg = new ToggleGroup();
        salariedEmpButton.setToggleGroup(tg);
        hourlyEmpButton.setToggleGroup(tg);
        radioContainer = new HBox();
        salaryLabel = new Label("Salary");
        salaryField = new TextField();
        startDateLabel = new Label("Start Date");
        datePicker = new DatePicker();
        confirmButton = new Button("Confirm");
        cancelButton = new Button("Cancel");
    }

    private void layoutNodes() {
        fillDropdownTitleMenu();
        radioContainer.getChildren().addAll(salariedEmpButton, hourlyEmpButton);
        radioContainer.setAlignment(Pos.CENTER);
        radioContainer.setSpacing(5.0);
        this.getChildren().addAll(nameLabel, nameField, lastNameLabel, lastNameField,
                empIDLabel, empIDField, managerIDLabel, managerIDField, titleLabel,
                dropdownTitleMenu, radioContainer, salaryLabel, salaryField, startDateLabel,
                datePicker, confirmButton, cancelButton);

        // setting some size properties for the Nodes
        nameField.setMaxWidth(200.0);
        lastNameField.setMaxWidth(200.0);
        empIDField.setMaxWidth(200.0);
        managerIDField.setMaxWidth(200.0);
        dropdownTitleMenu.setMaxWidth(200.0);
        salaryField.setMaxWidth(200.0);
        datePicker.setMaxWidth(200.0);
        confirmButton.setMaxWidth(200.0);
        cancelButton.setMaxWidth(200.0);

        setMargin(confirmButton, new Insets(50.0 , 0, 0, 0));
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40.0));
        this.setSpacing(10.0);

        // button styling
        confirmButton.setStyle("-fx-font-size: 15; -fx-background-color: #1b467b; -fx-border-color: none; " +
                "-fx-text-fill: white; -fx-font-family: 'Verdana'");
        cancelButton.setStyle("-fx-font-size: 15; -fx-background-color: #ce2547; -fx-border-color: none; " +
                "-fx-text-fill: white; -fx-font-family: 'Verdana'");

    }

    private void fillDropdownTitleMenu() {
        dropdownTitleMenu.getItems().add(JobTitle.INTERN);
        dropdownTitleMenu.getItems().add(JobTitle.ASSOCIATE);
        dropdownTitleMenu.getItems().add(JobTitle.ASSISTANT_MANAGER);
        dropdownTitleMenu.getItems().add(JobTitle.DIRECTOR);
        dropdownTitleMenu.getItems().add(JobTitle.MANAGER);
        dropdownTitleMenu.getItems().add(JobTitle.GENERAL_PRESIDENT);
        dropdownTitleMenu.getItems().add(JobTitle.SUPERVISOR);
        dropdownTitleMenu.getItems().add(JobTitle.VICE_PRESIDENT);
        dropdownTitleMenu.getItems().add(JobTitle.CEO);
    }

    TextField getNameField() {
        return nameField;
    }

    TextField getLastNameField() {
        return lastNameField;
    }

    TextField getEmpIDField() {
        return empIDField;
    }

    TextField getManagerIDField() {
        return managerIDField;
    }

    ComboBox<JobTitle> getDropdownTitleMenu() {
        return dropdownTitleMenu;
    }

    RadioButton getSalariedEmpButton() {
        return salariedEmpButton;
    }

    RadioButton getHourlyEmpButton() {
        return hourlyEmpButton;
    }

    TextField getSalaryField() {
        return salaryField;
    }

    DatePicker getDatePicker() {
        return datePicker;
    }

    Button getConfirmButton() {
        return confirmButton;
    }

    Button getCancelButton() {
        return cancelButton;
    }
}
