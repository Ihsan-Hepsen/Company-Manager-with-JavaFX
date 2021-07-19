package mngrApp.view.mainScreenView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import mngrApp.model.employee.Employee;
import mngrApp.model.management.Company;
import mngrApp.view.editingScreen.EditingScreenPresenter;
import mngrApp.view.editingScreen.EditingScreenView;
import mngrApp.view.hiringScreenView.HiringScreenPresenter;
import mngrApp.view.hiringScreenView.HiringScreenView;

public class CompanyAppPresenter {

    private final Company model;
    private final CompanyAppView view;

    public CompanyAppPresenter(Company model, CompanyAppView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getTableView().setRowFactory(tv -> {
            TableRow<Employee> row = new TableRow<>();
            row.setOnMouseClicked(clicked -> {
                // if a row is double clicked it will be selected.
                if (!row.isEmpty() && clicked.getButton() == MouseButton.PRIMARY // MouseButton.PRIMARY == left click
                        && clicked.getClickCount() == 2) {
                    Employee clickedRow = row.getItem();
                    view.getInfoField().setText(clickedRow.toString());

                    view.getDismissButton().setOnAction(dismissAction -> {
                        dismissSelectedEmployee(row.getItem());
                        updateView();
                    });

                    view.getEditButton().setOnAction(editAction -> switchToEditingScreen(row.getItem()));
                }
            });
            return row;
        });
        view.getHireButton().setOnAction(clicked -> switchToHiringScreen());
    }

    private void updateView() {
        fillEmployeeTable();
        defaultInfoFieldView();
    }

    private void generateTableColumns() {
        TableColumn<Employee, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Employee, Long> employeeIDCol = new TableColumn<>("Employee ID");
        employeeIDCol.setCellValueFactory(new PropertyValueFactory<>("employeeID"));

        view.getTableView().getColumns().addAll(nameCol, lastNameCol, employeeIDCol);
    }

    private void fillEmployeeTable() {
        view.getTableView().getItems().clear();
        view.getTableView().getColumns().clear();
        ObservableList<Employee> employees = FXCollections.observableArrayList(model.getEmployees());
        view.getTableView().setItems(employees);
        generateTableColumns();
    }

    // by default view's info field will display the 1st employee on the list
    private void defaultInfoFieldView() {
        view.getInfoField().setText(view.getTableView().getItems().get(0).toString());
    }

    private void switchToEditingScreen(Employee employee) {
        EditingScreenView editView = new EditingScreenView();
        new EditingScreenPresenter(model, editView, employee);
        view.getScene().setRoot(editView);
        editView.getScene().getWindow();
    }

    private void switchToHiringScreen() {
        HiringScreenView hiringView = new HiringScreenView();
        new HiringScreenPresenter(model, hiringView);
        view.getScene().setRoot(hiringView);
        hiringView.getScene().getWindow();
    }

    private void dismissSelectedEmployee(Employee employee) {
        Alert warning = new Alert(Alert.AlertType.CONFIRMATION);
        warning.setTitle("Confirmation Required");
        warning.setHeaderText("Do you really wish to dismiss \"" 
                + employee.getName() + " " + employee.getLastName() + "\"?");
        warning.showAndWait();
        if (!(warning.getResult().getButtonData().isCancelButton())) {
            model.dismissEmployee(employee);
            Alert confirmation = new Alert(Alert.AlertType.WARNING);
            confirmation.setHeaderText(employee.getName() + " " + employee.getLastName()
                    + " has successfully dismissed.");
            confirmation.showAndWait();
        }
    }
}
