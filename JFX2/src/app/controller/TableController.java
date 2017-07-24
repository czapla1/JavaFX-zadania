package app.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.model.TableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import database.DBConnector;


public class TableController  {

    @FXML
    private TableView<TableModel> tb1;
    @FXML
    private TableColumn<TableModel, Integer> tbId;
    @FXML
    private TableColumn<TableModel, String> tbImie;
    @FXML
    private TableColumn<TableModel, String> tbNazwisko;
    @FXML
    private TableColumn<TableModel, Integer> tbPensja;
    @FXML
    private Button btnShow;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnExit;
    @FXML
    private TextField tfImie;
    @FXML
    private TextField tfNazwisko;
    @FXML
    private TextField tfPensja;
    @FXML
    private Label lblImie;
    @FXML
    private Label lblNazwisko;
    @FXML
    private Label lblPensja;
    @FXML
    private Button btnUpIns;
    @FXML
    private Label lblInfo;
    @FXML
    private Button btnUpdate2;
    
    
    public DBConnector db;
    
    public ObservableList<TableModel>data=FXCollections.observableArrayList();
    
    @FXML
    void showTable(MouseEvent event) throws ClassNotFoundException {
    	try{
    		
    		Connection conn= db.connection();
    		data= FXCollections.observableArrayList();
    		ResultSet rs= conn.createStatement().executeQuery("select * from employee");
    		
    		while(rs.next()){
    			data.add(new TableModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
    		}
    		
    	}catch(SQLException e){
    		System.out.println("Error"+ e);
    		
    	}
    	tbId.setCellValueFactory(new PropertyValueFactory<TableModel,Integer>("id"));
    	tbImie.setCellValueFactory(new PropertyValueFactory<TableModel,String>("firstName"));
    	tbNazwisko.setCellValueFactory(new PropertyValueFactory<TableModel,String>("lastName"));
    	tbPensja.setCellValueFactory(new PropertyValueFactory<TableModel,Integer>("salary"));
    	
    	tb1.setItems(null);
    	tb1.setItems(data);
    	
    }
    
    
    @FXML
    void deleteTable(MouseEvent event) throws ClassNotFoundException {
    	int id_del=tb1.getSelectionModel().getSelectedItem().getId();
    	try{
   		java.sql.PreparedStatement prepareStatement= null;
    	String sql = "delete from employee where id_employee="+id_del+";"; 
    	Connection conn= db.connection();
    	prepareStatement=conn.prepareStatement(sql);
    	prepareStatement.executeUpdate();
    	
    	
    	data= FXCollections.observableArrayList();
		ResultSet rs= conn.createStatement().executeQuery("select * from employee");
    	
    	}catch(SQLException e){
    	System.err.print("Error "+ e);
    	}
    }

    @FXML
    void exit(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void insertTable(MouseEvent event) throws ClassNotFoundException {
    	lblImie.setDisable(false);
    	lblNazwisko.setDisable(false);
    	lblPensja.setDisable(false);
    	tfImie.setDisable(false);
    	tfNazwisko.setDisable(false);
    	tfPensja.setDisable(false);
    	btnUpIns.setDisable(false);
    	lblInfo.setDisable(false);
    	
    	
    	
    }

   

    @FXML
    void updateInsert(MouseEvent event) throws ClassNotFoundException, SQLException {
    	if(tfImie.getText().equals("")){
			lblInfo.setText("Wpisz brakujace imie!");
		}
    	else if(tfNazwisko.getText().equals("")){
			lblInfo.setText("Wpisz brakujace nazwisko!");
		}else if (tfPensja.getText().equals("")){
			lblInfo.setText("Wpisz brakuj¹c¹ pensjê!");
		}else{
    	
    		java.sql.PreparedStatement prepareStatement= null;
    		Connection conn= db.connection();
        	String sql = "insert into employee (firstName_employee,lastName_employee, gross_salary) values (?,?,?);"; 
        	prepareStatement=conn.prepareStatement(sql);
        	prepareStatement.setString(1, tfImie.getText());
        	prepareStatement.setString(2, tfNazwisko.getText());
        	prepareStatement.setInt(3, Integer.parseInt(tfPensja.getText()));
        	prepareStatement.executeUpdate();
        	
        	data= FXCollections.observableArrayList();
    		ResultSet rs= conn.createStatement().executeQuery("select * from employee");
    		
    		tfImie.setText("");
    		tfNazwisko.setText("");
    		tfPensja.setText("");
    		lblImie.setDisable(true);
        	lblNazwisko.setDisable(true);
        	lblPensja.setDisable(true);
        	tfImie.setDisable(true);
        	tfNazwisko.setDisable(true);
        	tfPensja.setDisable(true);
        	btnUpIns.setDisable(true);
        	lblInfo.setDisable(true);
        	
        	
		}
    	}
    

    @FXML
    void updateTable(MouseEvent event) throws ClassNotFoundException, SQLException {
    	lblImie.setDisable(false);
    	lblNazwisko.setDisable(false);
    	lblPensja.setDisable(false);
    	tfImie.setDisable(false);
    	tfNazwisko.setDisable(false);
    	tfPensja.setDisable(false);
    	//btnUpIns.setDisable(false);
    	lblInfo.setDisable(false);
    	btnUpdate2.setDisable(false);
    	
    	
    	tfImie.setText(tb1.getSelectionModel().getSelectedItem().getFirstName());
    	tfNazwisko.setText(tb1.getSelectionModel().getSelectedItem().getLastName());
    	tfPensja.setText(tb1.getSelectionModel().getSelectedItem().getSalary()+"");
    	
    }
    @FXML
    void update2(MouseEvent event) throws ClassNotFoundException, SQLException {
    	java.sql.PreparedStatement prepareStatement= null;
    	int id_update=tb1.getSelectionModel().getSelectedItem().getId();
    	String sql = "update employee set firstName_employee=?, lastName_employee=?, gross_salary=? where id_employee=?;"; 
    	Connection conn= db.connection();
    	
    	prepareStatement=conn.prepareStatement(sql);
    	prepareStatement.setString(1, tfImie.getText());
    	prepareStatement.setString(2, tfNazwisko.getText());
    	prepareStatement.setInt(3, Integer.parseInt(tfPensja.getText()));
    	prepareStatement.setInt(4, id_update);
    	prepareStatement.executeUpdate();
    	
    	tfImie.setText("");
		tfNazwisko.setText("");
		tfPensja.setText("");
		lblImie.setDisable(true);
    	lblNazwisko.setDisable(true);
    	lblPensja.setDisable(true);
    	tfImie.setDisable(true);
    	tfNazwisko.setDisable(true);
    	tfPensja.setDisable(true);
    	btnUpIns.setDisable(true);
    	lblInfo.setDisable(true);
    	btnUpdate2.setDisable(true);
		
    }
    
    public void initialize(){
    	
    	db= new DBConnector();
    }

}
