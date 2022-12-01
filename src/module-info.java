module CustomerManagmentProgram {
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	requires java.mail;
	requires java.base;

	opens application to javafx.graphics, javafx.fxml;
	opens controllers to javafx.graphics, javafx.fxml;
	exports application;
	exports controllers;
	exports manager.models;
}
