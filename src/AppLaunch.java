import mngrApp.model.management.Company;
import mngrApp.view.mainScreenView.CompanyAppPresenter;
import mngrApp.view.mainScreenView.CompanyAppView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLaunch extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Company model = new Company();
        CompanyAppView view = new CompanyAppView();
        new CompanyAppPresenter(model, view);
        stage.setTitle("Company Manager");
        stage.setHeight(720.00);
        stage.setWidth(600.00);
        stage.setResizable(false);
        stage.setScene(new Scene(view));
        stage.show();
    }
}
