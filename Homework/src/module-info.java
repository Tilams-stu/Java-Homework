/**
 * 
 */
/**
 * 
 */
module Homework {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
		
	opens cn.edu.nankai.Tilams.Testspace to javafx.fxml;
	exports cn.edu.nankai.Tilams.Testspace;
		
}