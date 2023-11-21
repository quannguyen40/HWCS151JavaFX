package quannguyen;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Simple validation
        if (username.isEmpty() || password.isEmpty()) {
            showError("Please enter both username and password.");
            shakeForm(); // Animate the form on error
        } else {
            showInfo("Login successful! Welcome, " + username + "!");
        }
    }

    private void showError(String message) {
        showAlert(Alert.AlertType.ERROR, "Error", message);
    }

    private void showInfo(String message) {
        showAlert(Alert.AlertType.INFORMATION, "Information", message);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void shakeForm() {
        // Add a simple shake animation to the form
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.1), new KeyValue(usernameField.translateXProperty(), 5)),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(usernameField.translateXProperty(), -5)),
                new KeyFrame(Duration.seconds(0.3), new KeyValue(usernameField.translateXProperty(), 5)),
                new KeyFrame(Duration.seconds(0.4), new KeyValue(usernameField.translateXProperty(), -5)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(usernameField.translateXProperty(), 0))
        );
        timeline.play();
    }
}
