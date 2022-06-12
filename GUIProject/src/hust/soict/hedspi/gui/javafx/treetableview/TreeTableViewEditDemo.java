package hust.soict.hedspi.gui.javafx.treetableview;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
 
public class TreeTableViewEditDemo extends Application {
 
    @Override
    public void start(Stage stage) {
 
        TreeTableView<Employee> treeTableView = new TreeTableView<Employee>();
        treeTableView.setEditable(true);
 
        // Create column EmpNo (Data type of String).
        TreeTableColumn<Employee, String> empNoCol //
                = new TreeTableColumn<Employee, String>("Emp No");
 
        // Create column FullName (Data type of String).
        TreeTableColumn<Employee, String> fullNameCol//
                = new TreeTableColumn<Employee, String>("Full Name");
 
        // Create 2 sub column for FullName.
        TreeTableColumn<Employee, String> firstNameCol //
                = new TreeTableColumn<Employee, String>("First Name");
 
        TreeTableColumn<Employee, String> lastNameCol //
                = new TreeTableColumn<Employee, String>("Last Name");
 
        // Add sub columns to the FullName
        fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);
 
        // Gender Column
        TreeTableColumn<Employee, Gender> genderCol //
                = new TreeTableColumn<Employee, Gender>("Gender");
        genderCol.setMinWidth(90);
 
        // Position Column
        TreeTableColumn<Employee, String> positionCol //
                = new TreeTableColumn<Employee, String>("Position");
 
        // Single? Column
        TreeTableColumn<Employee, Boolean> singleCol//
                = new TreeTableColumn<Employee, Boolean>("Single?");
 
        // Add columns to TreeTable.
        treeTableView.getColumns().addAll(empNoCol, fullNameCol, positionCol, genderCol, singleCol);
 
        // Data
        Employee empBoss = new Employee("E00", "Abc@gmail.com", //
                "Boss", "Boss", "Manager", "M", false);
 
        Employee empSmith = new Employee("E01", "Smith@gmail.com", //
                "Susan", "Smith", "Salesman", "F", true);
 
        Employee empMcNeil = new Employee("E02", "McNeil@gmail.com", //
                "Anne", "McNeil", "Cleck", "M", false);
 
        // Root Item
        TreeItem<Employee> itemRoot = new TreeItem<Employee>(empBoss);
        TreeItem<Employee> itemSmith = new TreeItem<Employee>(empSmith);
        TreeItem<Employee> itemMcNeil = new TreeItem<Employee>(empMcNeil);
 
        itemRoot.getChildren().addAll(itemSmith, itemMcNeil);
        treeTableView.setRoot(itemRoot);
 
        // Defines how to fill data for each cell.
        // Get value from property of Employee.
        empNoCol.setCellValueFactory(new TreeItemPropertyValueFactory<Employee, String>("empNo"));
        firstNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<Employee, String>("firstName"));
        lastNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<Employee, String>("lastName"));
        positionCol.setCellValueFactory(new TreeItemPropertyValueFactory<Employee, String>("position"));
 
        // GENDER (COMBO BOX).
        genderCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, Gender>, //
        ObservableValue<Gender>>() {
 
            @Override
            public ObservableValue<Gender> call(TreeTableColumn.CellDataFeatures<Employee, Gender> param) {
                TreeItem<Employee> treeItem = param.getValue();
                Employee emp = treeItem.getValue();
                // F,M
                String genderCode = emp.getGender();
                Gender gender = Gender.getByCode(genderCode);
                return new SimpleObjectProperty<Gender>(gender);
            }
        });
        ObservableList<Gender> genderList = FXCollections.observableArrayList(//
                Gender.values());
        genderCol.setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(genderList));
 
        // After user edit on cell, update to Model.
        genderCol.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Employee, Gender>>() {
 
            @Override
            public void handle(TreeTableColumn.CellEditEvent<Employee, Gender> event) {
                TreeItem<Employee> item = event.getRowValue();
                Employee emp = item.getValue();
                Gender newGender = event.getNewValue();
                emp.setGender(newGender.getCode());
                System.out.println("Single column commit. new gender:" +newGender);
                System.out.println("EMP:"+emp.isSingle());
            }
        });
 
        // ==== SINGLE? (CHECH BOX) ===
        singleCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, Boolean>, //
        ObservableValue<Boolean>>() {
 
            @Override
            public ObservableValue<Boolean> call(TreeTableColumn.CellDataFeatures<Employee, Boolean> param) {
                TreeItem<Employee> treeItem = param.getValue();
                Employee emp = treeItem.getValue();
                SimpleBooleanProperty booleanProp= new SimpleBooleanProperty(emp.isSingle());
                
                // Note: singleCol.setOnEditCommit(): Not work for
                // CheckBoxTreeTableCell.
                // When "Single?" column change.
                booleanProp.addListener(new ChangeListener<Boolean>() {
 
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                            Boolean newValue) {
                        emp.setSingle(newValue);
                    }                     
                });
                return booleanProp;
            }
        });
  
        
         singleCol.setCellFactory(new Callback<TreeTableColumn<Employee,Boolean>,TreeTableCell<Employee,Boolean>>() {
            @Override
            public TreeTableCell<Employee,Boolean> call( TreeTableColumn<Employee,Boolean> p ) {
                CheckBoxTreeTableCell<Employee,Boolean> cell = new CheckBoxTreeTableCell<Employee,Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
 
        //
        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(treeTableView);
 
        stage.setTitle("TreeTableView (o7planning.org)");
 
        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}