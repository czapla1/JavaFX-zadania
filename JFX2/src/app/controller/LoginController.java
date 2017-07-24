package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;
import javax.swing.JOptionPane;

import app.model.LoginModel;
import app.model.TableModel;
import database.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {
	
    @FXML
    private Label lbl1;

    @FXML
    private TextField tf1;

    @FXML
    private PasswordField pf1;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;
    
    @FXML
    private CheckBox chb1;

    @FXML
    private TextField txt2;
    
    String txt;
    @FXML
    void showPass(MouseEvent event) {
    	if(chb1.isSelected()){
    		pf1.setDisable(true);
    		txt2.setVisible(true);
    		txt2.setText(pf1.getText());
    	}else if(chb1.isSelected() ==false){
    		pf1.setDisable(false);
    		txt2.setVisible(false);
    		pf1.setText(txt2.getText());
    		
    	}
    }
    
    DBConnector db;
	public ObservableList<LoginModel>data=FXCollections.observableArrayList();
    @FXML
    void login(MouseEvent event) throws IOException, ClassNotFoundException, SQLException {
    	
    	Connection conn= db.connection();
    	data= FXCollections.observableArrayList();
    	java.sql.PreparedStatement preparedStatement=null;
    	String sql="select * from users where login=? and pass=?";
    	preparedStatement=conn.prepareStatement(sql);
    	preparedStatement.setString(1, tf1.getText());
    	preparedStatement.setString(2, pf1.getText());
    	preparedStatement.executeQuery();
    	
    	
		ResultSet rs= conn.createStatement().executeQuery("select * from users");
    	
//    	if((tf1.getText().equals("admin") && pf1.getText().equals("admin")) || (tf1.getText().equals("admin") && txt2.getText().equals("admin")) ){
    	rs.next();
		if(!rs.equals(null)){
    		System.out.println("poprawne");
    		Stage stageTable = new Stage();
    		Parent root= (Parent)FXMLLoader.load(getClass().getResource("/app/view/TableView.fxml"));
			Scene sceneTable= new Scene(root);
			stageTable.setScene(sceneTable);
			stageTable.setTitle("Table page");
			stageTable.show();
			
    	
    	
    	
    	}else{
    		JOptionPane.showMessageDialog(null, "Incorrect, try again!");
    		tf1.setText("");
    		pf1.setText("");
    		txt2.setText("");
    	}
    }
    
    
    
public void initialize(){
    	
    	db= new DBConnector();
    }
}
