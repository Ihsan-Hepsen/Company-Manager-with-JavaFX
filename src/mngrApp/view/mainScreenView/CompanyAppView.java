package mngrApp.view.mainScreenView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mngrApp.model.employee.Employee;

public class CompanyAppView extends BorderPane {

    private HBox mainSection;
    private VBox leftSide;
    private VBox rightSide;
    private TableView<Employee> employeeTable;
    private Button hireButton;
    private Button dismissButton;
    private Button editButton;
    private Label heading;
    private final Label versionLabel = new Label("v1.1.6");
    private Text infoField;


    public CompanyAppView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        mainSection = new HBox();
        leftSide = new VBox();
        rightSide = new VBox();
        employeeTable = new TableView<>();
        infoField = new Text("Click on an employee\nto display details here");
        hireButton = new Button("Hire New Employee");
        dismissButton = new Button("Dismiss Employee");
        editButton = new Button("Edit Employee");
        heading = new Label("Company Name");
    }

    private void layoutNodes() {
        // positioning the Heading Label
        setAlignment(heading, Pos.CENTER);
        setTop(heading);

       setAlignment(versionLabel, Pos.BOTTOM_CENTER);
        setBottom(versionLabel);

        // aligning the main section >> main section is a container that contains left_side & right_side VBoxes
        setCenter(mainSection);
        mainSection.setAlignment(Pos.CENTER);
        mainSection.getChildren().addAll(leftSide, rightSide);

        // appending Employee List to the left_side
        leftSide.getChildren().add(employeeTable);
        employeeTable.setPrefHeight(465.0);
        employeeTable.setPrefWidth(235.0);
        mainSection.setSpacing(10.0);

        // adding buttons to the right_side
        hireButton.setAlignment(Pos.BOTTOM_CENTER);
        dismissButton.setAlignment(Pos.BOTTOM_CENTER);
        editButton.setAlignment(Pos.BOTTOM_CENTER);
        rightSide.setSpacing(15.0); // gives elements(Nodes) padding
        rightSide.getChildren().addAll(infoField, hireButton, editButton, dismissButton);

        setPadding(new Insets(30.0));
        setMargin(mainSection, new Insets(20.0));

        // giving the buttons a preferred width
        hireButton.setPrefWidth(200.0);
        editButton.setPrefWidth(200.0);
        dismissButton.setPrefWidth(200.0);

        // styling elements(Nodes)
        infoField.setLineSpacing(2.5);
        infoField.setFont(new Font("Avenir Next LT Pro", 15));
        final String buttonStyling = "-fx-font-size: 15; -fx-background-color: #1b467b; -fx-border-color: none; " +
                "-fx-text-fill: white; -fx-font-family: 'Verdana'";
        hireButton.setStyle(buttonStyling);
        dismissButton.setStyle("-fx-font-size: 15; -fx-background-color: #ce2547; " +
                "-fx-border-color: none; -fx-text-fill: white; -fx-font-family: 'Verdana'");
        editButton.setStyle(buttonStyling);
        heading.setStyle("-fx-font-family: 'Microsoft New Tai Lue'; -fx-font-size: 40;");
    }

    // package private getters
    TableView<Employee> getTableView() {
        return employeeTable;
    }

    Text getInfoField() {
        return infoField;
    }

    Button getHireButton() {
        return hireButton;
    }

    Button getEditButton() {
        return editButton;
    }

    Button getDismissButton() {
        return dismissButton;
    }
}
