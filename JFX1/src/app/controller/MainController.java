package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class MainController{

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;
    
    @FXML
    private Button btn4;
    
    @FXML
    private Button btn5;

    @FXML
    private Button btn6;
    
    @FXML
    private Button btn7;
    
    @FXML
    private TextArea ta1;
    
    
    @FXML
    private MenuItem cut;

    @FXML
    private MenuItem paste;

    ObservableList<String> opcje= FXCollections.observableArrayList("opcja1","opcja2","opcja3");
    
    @FXML
    private ComboBox<String> cb1;

	protected String from_cut;
   
    public void initialize(){
    	cb1.setItems(opcje);
    	clear.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ta1.setText(null);
			}
		});
    	
    	
    	exit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
    	
    	author.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ta1.setText("Author");
			}
		});
    	cut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				from_cut= ta1.getText();
				ta1.setText("");
			}
		});
    	
    	paste.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String from_paste= ta1.getText() + from_cut;
				ta1.setText(from_paste);
			}
		});
    }
    
    @FXML
    private CheckBox chb1;

    @FXML
    private CheckBox chb2;

    @FXML
    private CheckBox chb3;
    
    
    @FXML
    private RadioButton rb1;

    @FXML
    private ToggleGroup rbg;

    @FXML
    private RadioButton rb2;

    @FXML
    private RadioButton rb3;
    
    @FXML
    private MenuBar mb1;

    @FXML
    private Menu mbf;

    @FXML
    private MenuItem exit;

    @FXML
    private Menu mbe;

    @FXML
    private MenuItem clear;

    @FXML
    private Menu mbh;

    @FXML
    private MenuItem author;
    
    
    
    
    
    
    @FXML
    void btn1clicked(MouseEvent event) {

    	String txt=ta1.getText();
    	ta1.setText("Hello");
    }
    
    @FXML
    void toUpperCase(MouseEvent event) {
    	String txt1= ta1.getText();
    	ta1.setText(txt1.toUpperCase());
    }

    
    @FXML
    void toLower(MouseEvent event) {
    	String txt1= ta1.getText();
    	ta1.setText(txt1.toLowerCase());
    }
    
    
    @FXML
    void clear(MouseEvent event) {
    	ta1.setText("");
    }
    
    
    @FXML
    String changeText(MouseEvent event) {
    	String text=ta1.getText();
    	if(lbl1.isHover()){
    	String text1=lbl1.getText();
    	ta1.setText(text1);
    	}if(lbl2.isHover()){
        	String text1=lbl2.getText();
        	ta1.setText(text1);
    	}if(lbl3.isHover()){
        	String text1=lbl3.getText();
        	ta1.setText(text1);
    	}
    	return text;
    }
    
    @FXML
    void rechangeText(MouseEvent event) {
    	ta1.setText("");
    }
    
    
    @FXML
    void show(MouseEvent event) {
    	
    	String text="";
    	if(chb1.isSelected()){
    		text+=chb1.getText()+"\n";
    		ta1.setText(text);
    	}
    	if(chb2.isSelected()){
    		text+=chb2.getText()+"\n";
    		ta1.setText(text);
    	}
    	if(chb3.isSelected()){
    		text+=chb3.getText()+"\n";
    		ta1.setText(text);
    	}
    	
    }
    
    
    @FXML
    void click(MouseEvent event) {
    	String text="";
    	if(rb1.isSelected()){
    		text=rb1.getText();
    		ta1.setText(text);
    	}
    	if(rb2.isSelected()){
    		text=rb2.getText();
    		ta1.setText(text);
    	}
    	if(rb3.isSelected()){
    		text=rb3.getText();
    		ta1.setText(text);
    	}
    	
    }
    
    
    @FXML
    void showCombo(MouseEvent event) {

    	ta1.setText(cb1.getValue());
    }
}