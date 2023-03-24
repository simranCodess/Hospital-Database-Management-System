package com.example.demo111;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

import static java.lang.String.valueOf;
import static java.sql.Types.NULL;

public class DashboardController implements Initializable {

    @FXML
    private Label winner;

    @FXML
    private Label emp1;

    @FXML
    private Label emp2;

    @FXML
    private Label emp3;

    @FXML
    private Label emp4;

    @FXML
    private Label emp5;

    @FXML
    private Label leader1;

    @FXML
    private Label leader2;

    @FXML
    private Label leader3;

    @FXML
    private Label leader4;

    @FXML
    private Label leader5;



    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Label totalDoctors;

    @FXML
    private Label totalNurses;

    @FXML
    private Label totalPatients;

    @FXML
    private Label totalReceptionist;
    @FXML
    private Button patientDashButton;

    @FXML
    private AnchorPane patientDashboard;
    @FXML
    private AnchorPane PatientDashboard;

    @FXML
    private Button addPatient;


    @FXML
    private TableColumn<Patient, String> addressColP;

    @FXML
    private Button deletePatient;

    @FXML
    private TableColumn<Patient, String> doctorIdColP;


    @FXML
    private TableColumn<Patient, String> facilityNumColP;

    @FXML
    private TableColumn<Patient, String> healthColP;


    @FXML
    private TableColumn<Patient, String> nameColP;

    @FXML
    private TableColumn<Patient, String> nurseIDColP;

    @FXML
    private TextField patientAddressField;

    @FXML
    private PieChart patientPieChart;

    @FXML
    private TextField patientCabinfeild;

    @FXML
    private TextField patientDoctorFeild;

    @FXML
    private TextField patientFacilityNumField;

    @FXML
    private TextField patientHealthNumField;

    @FXML
    private TextField patientNameFeild;

    @FXML
    private TextField patientNurseIdFeild;

    @FXML
    private TextField patientPhoneField;

    @FXML
    private TextField patientReportField;

    @FXML
    private TableView<Patient> patientTable;

    @FXML
    private TableColumn<Patient, String> phoneColP;

    @FXML
    private TableColumn<Patient, String> reportIdColP;

    @FXML
    private Button resetPatient;
    @FXML
    private AnchorPane administrationDashboard;

    @FXML
    private TableColumn<Bill, String> amountC;


    @FXML
    private TableColumn<Benefits, String> benefitIdE;

    @FXML
    private TableView<Benefits> benefitsTable;

    @FXML
    private TableView<Bill> billingTable;

    @FXML
    private TableColumn<Head_Nurse, String> cabinColA;

    @FXML
    private TableView<Cabin> cabinTable;

    @FXML
    private TableColumn<Cabin, String> cabinTypeB;

    @FXML
    private TableColumn<Cabin, String> CabinNumberColB;

    @FXML
    private TableView<NameOnCard> cardDetailsTable;

    @FXML
    private TableColumn<NameOnCard, String> cardNumberD;


    @FXML
    private TableColumn<NameOnCard, String> cvvD;


    @FXML
    private TableColumn<Bill, String> empIdC;

    @FXML
    private TableColumn<Head_Nurse, String> empIdColA;

    @FXML
    private TableColumn<Benefits, String> empIdE;


    @FXML
    private TableColumn<NameOnCard, String> expiryD;


    @FXML
    private TableView<Head_Nurse> headNurseTable;

    @FXML
    private TableColumn<Bill, String> ReceiptNumColC;

    @FXML
    private TableColumn<NameOnCard, String> nameOnCardD;

    @FXML
    private TableColumn<NameOnCard, String> recieptNumD;

    @FXML
    private TableColumn<Bill, String> reportIdC;


    @FXML
    private TableColumn<Location, String> CityCol;


    @FXML
    private TableColumn<Location, String> areaCol;

    @FXML
    private TableColumn<Location, String> countryCol;

    @FXML
    private TableColumn<Location, String> SystemNumberCol;

    @FXML
    private TextField addAreaCode;

    @FXML
    private TextField addCity;

    @FXML
    private TextField addCountry;

    @FXML
    private TextField addHospitalArea;

    @FXML
    private Button admin;
    @FXML
    private Button addHospitalButon;

    @FXML
    private Button addHospitalButton;

    @FXML
    private TextField addHospitalFacility;

    @FXML
    private TextField addHospitalName;

    @FXML
    private TextField addHospitalSystem;

    @FXML
    private Button deleteHospital;

    @FXML
    private Button deleteHospitalButton;

    @FXML
    private TableColumn<Hospital, String> facilityNumberCol;

    @FXML
    private TableColumn<Hospital, String> systemNumberCol;


    @FXML
    private TableColumn<Hospital, String> hospitalNameCol;

    @FXML
    private TableColumn<Patient, String> cabinNumColP;

    @FXML
    private TableView<Hospital> hospitalTable;

    @FXML
    private TableView<Location> locationTable;
    @FXML
    private Button EmployeeDashboard;

    @FXML
    private TextField addDeskNumber;

    @FXML
    private Button hospitalDashboard;
    @FXML
    private AnchorPane hospitalDash;
    @FXML
    private TextField employeeSearch;
    @FXML
    private TextField addDoctorId;

    @FXML
    private ChoiceBox<String> addEmpChoice;

    @FXML
    private TableColumn<Doctor, String> addEmpDoctorIdCol;

    @FXML
    private DatePicker addEmpEndDate;

    @FXML
    private TableColumn<Employee, String> addEmpEndDateCol;

    @FXML
    private TableColumn<Employee, String> addEmpHourCol;

    @FXML
    private TextField addEmpHours;

    @FXML
    private TextField addEmpId;

    @FXML
    private TableColumn<Employee, String> addEmpIdCol;

    @FXML
    private TextField addEmpName;

    @FXML
    private ChoiceBox<String> orderByEmployee;
    @FXML
    private TableColumn<Employee, String> addEmpNameCol;

    @FXML
    private TableColumn<Nurse, String> addEmpNurseIdCol;

    @FXML
    private TableColumn<Nurse, String> addEmpNurseRoomCol;

    @FXML
    private TableColumn<Head_Nurse, String> NurseIdColA;
    @FXML
    private TableColumn<Receptionist, String> addEmpReceptionDeskNumCol;

    @FXML
    private TableColumn<Employee, String> addEmpSpecialityCol;


    @FXML
    private TableColumn<Hospital, String> areaCodeCol;
    @FXML
    private DatePicker addEmpStartDate;

    @FXML
    private TableColumn<Employee, String> addEmpStartDateCol;

    @FXML
    private TableView<Employee> addEmpTable;

    @FXML
    private Button addEmployee;

    @FXML
    private TextField addNurseId;

    @FXML
    private TextField addRoom;

    @FXML
    private TextField addSpeciality;
    @FXML
    private TableColumn<Employee, String> addEmpHospitalId;
    @FXML
    private Button credits;

    @FXML
    private Button dashboardHome;

    @FXML
    private AnchorPane dashboardMain;

    @FXML
    private AnchorPane dashboardMainPage;

    @FXML
    private AnchorPane dashboardMenu;

    @FXML
    private Button deleteEmployee;

    @FXML
    private AnchorPane employeeDashboard;

    @FXML
    private Button resetEmployee;

    @FXML
    private Button signOutButton;

    @FXML
    private Button updateEmployee;

    @FXML
    private Label usernameName;


    @FXML
    private TextField addHospitalToEmployee;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;

    private ResultSet resultSet;
    private ObservableList<Employee> addEmpList = addEmpTable();
    private ObservableList<Hospital> hospitalList = addHospitalTable();
    private ObservableList<Location> locationList = addLocationTable();

    private ObservableList<Bill> billsList = addBills();

    private ObservableList<Head_Nurse> headNurseList = addHeadNurse();

    private ObservableList<Cabin> cabinList = addCabin();

    private ObservableList<NameOnCard> cardList = addNameOnCard();

    private ObservableList<Benefits> benefitsList = addBenefits();

    private ObservableList<Patient> patientList = addPatient();

    private String setUsername = "";
    private String[] choices = {"Doctor", "Nurse", "Receptionist"};
    private String[] orderBy = {"Employee ID", "Employee Name", "Employee Start Date", "Employee End Date", "Employee Productive Hours", "Employee Hospital ID"};

    public ObservableList<Location> addLocationTable() {
        ObservableList<Location> locList = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM location";
        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String areaCode = resultSet.getString("area_code");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                locList.add(new Location(city, country, areaCode));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return locList;
    }

    public void addLocationListView() {
        areaCol.setCellValueFactory(new PropertyValueFactory<>("areaCode"));
        CityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        locationTable.setItems(locationList);
    }

    public ObservableList<Hospital> addHospitalTable() {
        ObservableList<Hospital> hospitalList = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM hospital";
        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String hospitalName = resultSet.getString("hospital_name");
                String hospitalArea = resultSet.getString("location_id");
                String hospitalSystem = resultSet.getString("system_number");

                int hospitalFacility = resultSet.getInt("facility_number");
                hospitalList.add(new Hospital(hospitalFacility, hospitalSystem, hospitalName, hospitalArea));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return hospitalList;
    }

    public void addHospitalListView() {
        hospitalNameCol.setCellValueFactory(new PropertyValueFactory<>("hospitalName"));
        SystemNumberCol.setCellValueFactory(new PropertyValueFactory<>("SystemNumber"));
        facilityNumberCol.setCellValueFactory(new PropertyValueFactory<>("facilityNumber"));
        areaCodeCol.setCellValueFactory(new PropertyValueFactory<>("locationId"));
        hospitalTable.setItems(hospitalList);
    }

    public ObservableList<Employee> addEmpTable() {
        ObservableList<Employee> empList = FXCollections.observableArrayList();
        empList.clear();
        String sqlQuery = "SELECT EMPLOYEE.*, NURSE.nurse_id, NURSE.assigned_room, DOCTOR.doctor_id, DOCTOR.speciality, RECEPTIONIST.desk_number FROM EMPLOYEE" +
                " LEFT JOIN NURSE ON EMPLOYEE.emp_id = NURSE.employee_id" +
                " LEFT JOIN DOCTOR ON EMPLOYEE.emp_id = DOCTOR.employee_id" +
                " LEFT JOIN RECEPTIONIST ON EMPLOYEE.emp_id = RECEPTIONIST.employee_id";

        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int empId = resultSet.getInt("emp_id");
                int hospitalId = resultSet.getInt("hospital_id");
                String name = resultSet.getString("emp_name");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                int hours = resultSet.getInt("Productive_hours");
                int nurseId = resultSet.getInt("nurse_id");
                int room = resultSet.getInt("assigned_room");
                int doctorId = resultSet.getInt("doctor_id");
                String speciality = resultSet.getString("speciality");
                int deskNumber = resultSet.getInt("desk_number");
                if (nurseId != 0) {
                    empList.add(new Nurse(startDate, endDate, hours, name, empId, hospitalId, nurseId, room));
                } else if (doctorId != 0) {
                    empList.add(new Doctor(startDate, endDate, hours, name, empId, hospitalId, speciality, doctorId));
                } else if (deskNumber != 0) {
                    empList.add(new Receptionist(startDate, endDate, hours, name, empId, hospitalId, deskNumber));
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;
    }

    public void addEmpListView() {
        addEmpStartDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        addEmpEndDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        addEmpHourCol.setCellValueFactory(new PropertyValueFactory<>("hours"));
        addEmpNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addEmpIdCol.setCellValueFactory(new PropertyValueFactory<>("empId"));
        addEmpHospitalId.setCellValueFactory(new PropertyValueFactory<>("hospitalID"));
        addEmpNurseIdCol.setCellValueFactory(new PropertyValueFactory<>("nurseID"));
        addEmpNurseRoomCol.setCellValueFactory(new PropertyValueFactory<>("AssignedRoom"));
        addEmpDoctorIdCol.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        addEmpSpecialityCol.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        addEmpReceptionDeskNumCol.setCellValueFactory(new PropertyValueFactory<>("deskNumber"));
        addEmpTable.setItems(addEmpList);
    }

    public ObservableList<Head_Nurse> addHeadNurse() {
        ObservableList<Head_Nurse> headNurseList = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM HEAD_NURSE";
        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int headNurseId = resultSet.getInt("nurse_id");
                int empId = resultSet.getInt("employee_id");
                int cabinNumber = resultSet.getInt("cabin_number");
                headNurseList.add(new Head_Nurse(headNurseId, empId, cabinNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return headNurseList;
    }

    public void addHeadNurseListView() {
        NurseIdColA.setCellValueFactory(new PropertyValueFactory<>("nurseID"));
        empIdColA.setCellValueFactory(new PropertyValueFactory<>("empID"));
        cabinColA.setCellValueFactory(new PropertyValueFactory<>("cabinNumber"));
        headNurseTable.setItems(headNurseList);
    }

    public ObservableList<Cabin> addCabin() {
        ObservableList<Cabin> cabinList = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM CABIN";
        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int cabinNumber = resultSet.getInt("cabin_number");
                String cabinType = resultSet.getString("cabin_type");
                cabinList.add(new Cabin(cabinNumber, cabinType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cabinList;
    }

    public void addCabinListView() {
        CabinNumberColB.setCellValueFactory(new PropertyValueFactory<>("cabinNumber"));
        cabinTypeB.setCellValueFactory(new PropertyValueFactory<>("cabinType"));
        cabinTable.setItems(cabinList);
    }

    public ObservableList<Bill> addBills() {
        ObservableList<Bill> billList = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM BILL";
        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int recieptNumber = resultSet.getInt("reciept_number");
                int empId = resultSet.getInt("employee_id");
                int amount = resultSet.getInt("amount");
                int reportId = resultSet.getInt("report_id");
                billList.add(new Bill(recieptNumber, empId, amount, reportId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    public void addBillsListView() {
        ReceiptNumColC.setCellValueFactory(new PropertyValueFactory<>("recieptNumber"));
        empIdC.setCellValueFactory(new PropertyValueFactory<>("empID"));
        amountC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        reportIdC.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        billingTable.setItems(billsList);
    }

    public ObservableList<NameOnCard> addNameOnCard() {
        ObservableList<NameOnCard> nameOnCardList = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM CARD_PAYMENT";
        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name_on_card");
                int cardNumber = resultSet.getInt("card_number");
                Date expiry = resultSet.getDate("exp_date");
                int cvv = resultSet.getInt("cvv");
                int recieptNumber = resultSet.getInt("reciept_num");
                nameOnCardList.add(new NameOnCard(name, cardNumber, expiry, cvv, recieptNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameOnCardList;
    }

    public void addNameOnCardListView() {
        nameOnCardD.setCellValueFactory(new PropertyValueFactory<>("name_on_card"));
        cardNumberD.setCellValueFactory(new PropertyValueFactory<>("card_number"));
        expiryD.setCellValueFactory(new PropertyValueFactory<>("exp_date"));
        cvvD.setCellValueFactory(new PropertyValueFactory<>("cvv"));
        recieptNumD.setCellValueFactory(new PropertyValueFactory<>("reciept_number"));
        cardDetailsTable.setItems(cardList);
    }

    public ObservableList<Benefits> addBenefits() {
        ObservableList<Benefits> benefitsList = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM Benefits";
        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int benefitId = resultSet.getInt("benefit_id");
                int emp_id = resultSet.getInt("employee_id");
                benefitsList.add(new Benefits(benefitId, emp_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benefitsList;
    }

    public void addBenefitsListView() {
        benefitIdE.setCellValueFactory(new PropertyValueFactory<>("benefit_id"));
        empIdE.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        benefitsTable.setItems(benefitsList);
    }

    public ObservableList<Patient> addPatient() {
        ObservableList<Patient> patientList = FXCollections.observableArrayList();
        String sqlQuery = "SELECT * FROM PATIENT";
        try {
            connection = DatabaseController.connection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int report_id = resultSet.getInt("report_id");
                int phone = resultSet.getInt("phone");
                String address = resultSet.getString("address");
                String name = resultSet.getString("patient_name");
                int health_care_num = resultSet.getInt("health_care_num");
                int facility_num = resultSet.getInt("facility_num");
                int cabin_number = resultSet.getInt("cabin_number");
                int doctor_id = resultSet.getInt("doctor_id");
                int nurse_id = resultSet.getInt("nurse_id");
                patientList.add(new Patient(report_id, phone, address, name, health_care_num, facility_num, cabin_number, doctor_id, nurse_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;
    }

    public void addPatientListView() {
        reportIdColP.setCellValueFactory(new PropertyValueFactory<>("report_id"));
        phoneColP.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColP.setCellValueFactory(new PropertyValueFactory<>("address"));
        nameColP.setCellValueFactory(new PropertyValueFactory<>("patient_name"));
        healthColP.setCellValueFactory(new PropertyValueFactory<>("health_care_num"));
        facilityNumColP.setCellValueFactory(new PropertyValueFactory<>("facility_num"));
        cabinNumColP.setCellValueFactory(new PropertyValueFactory<>("cabin_number"));
        doctorIdColP.setCellValueFactory(new PropertyValueFactory<>("doctor_id"));
        nurseIDColP.setCellValueFactory(new PropertyValueFactory<>("nurse_id"));
        patientTable.setItems(patientList);
    }


    public void signOut() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sign Out");
            alert.setHeaderText("Are you sure you want to sign out?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                Stage stage = (Stage) dashboardMain.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Stage homePage = new Stage();
                Scene scene = new Scene(root);
                homePage.setScene(scene);
                homePage.show();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void swithDashboards(ActionEvent e) {
        if (e.getSource() == dashboardHome) {
            dashboardMainPage.setVisible(true);
            employeeDashboard.setVisible(false);
            hospitalDash.setVisible(false);
            patientDashboard.setVisible(false);
            administrationDashboard.setVisible(false);
        }
        if (e.getSource() == EmployeeDashboard) {
            dashboardMainPage.setVisible(false);
            employeeDashboard.setVisible(true);
            hospitalDash.setVisible(false);
            addEmpTable.setVisible(true);
            administrationDashboard.setVisible(false);
            patientDashboard.setVisible(false);
            addEmpListView();
            addEmpTable();


        } else if (e.getSource() == hospitalDashboard) {
            dashboardMainPage.setVisible(false);
            employeeDashboard.setVisible(false);
            hospitalDash.setVisible(true);
            patientDashboard.setVisible(false);
            administrationDashboard.setVisible(false);
        } else if (e.getSource() == admin) {
            dashboardMainPage.setVisible(false);
            employeeDashboard.setVisible(false);
            hospitalDash.setVisible(false);
            administrationDashboard.setVisible(true);
            patientDashboard.setVisible(false);
        } else if (e.getSource() == patientDashButton) {
            dashboardMainPage.setVisible(false);
            employeeDashboard.setVisible(false);
            hospitalDash.setVisible(false);
            administrationDashboard.setVisible(false);
            patientDashboard.setVisible(true);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addEmpListView();
        addLocationListView();
        addHospitalListView();
        addHeadNurseListView();
        addCabinListView();
        addBillsListView();
        addNameOnCardListView();
        addBenefitsListView();
        addPatientListView();
        patientaveragestayChart();
        chart();
       leadershipBoard();
        String totalDoctor = String.valueOf(totalDoctors());
        String totalNurse = String.valueOf(totalNurses());
        String totalPatient = String.valueOf(totalPatients());
        String totalReceptionist1 = String.valueOf(totalReceptionist());
        totalDoctors.setText(totalDoctor);
        totalNurses.setText(totalNurse);
        totalPatients.setText(totalPatient);
        totalReceptionist.setText(totalReceptionist1);
        addEmpChoice.setOnAction(this::userSelectedChoice);
        addEmpChoice.getItems().addAll(choices);
        employeeSearch.setOnKeyReleased(event -> {
            employeeSearch(employeeSearch.getText());
        });

    }

    //close method/sign out method
    public void close() {
        System.exit(0);
    }

    //  minimize method
    public void minimization() {
        Stage stage = (Stage) dashboardMain.getScene().getWindow();
        stage.setIconified(true);
    }

    public void addLocationByItself() {
        String sqlQuery = "INSERT INTO LOCATION (city,country,area_code)" +
                "VALUES (?,?,?)";
        connection = DatabaseController.connection();
        boolean flag = false;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (addCity.getText().isEmpty() || addCountry.getText().isEmpty() ||
                    addAreaCode.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the fields");
                alert.showAndWait();
                flag=true;
            } else if (addCity.getText().matches("[0-9]+") || addCountry.getText().matches("[0-9]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter a valid city or country");
                alert.showAndWait();
                flag=true;
            } else if (addAreaCode.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter a valid area code");
                alert.showAndWait();
                flag=true;
            }
            //checking if the primary key already exists
            if (!flag) {
                String sqlQuery2 = "SELECT * FROM LOCATION WHERE city = ? AND country = ? AND area_code = ?";
                preparedStatement = connection.prepareStatement(sqlQuery2);
                preparedStatement.setString(1, addCity.getText());
                preparedStatement.setString(2, addCountry.getText());
                preparedStatement.setString(3, addAreaCode.getText());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Location already exists");
                    alert.showAndWait();
                } else {
                    preparedStatement = connection.prepareStatement(sqlQuery);
                    preparedStatement.setString(1, addCity.getText());
                    preparedStatement.setString(2, addCountry.getText());
                    preparedStatement.setString(3, addAreaCode.getText());
                    preparedStatement.executeUpdate();
                    alert.setTitle("Success");
                    alert.setHeaderText("Location added successfully");
                    alert.showAndWait();
                    locationList = addLocationTable();
                    addLocationListView();

                    addCity.clear();
                    addCountry.clear();
                    addAreaCode.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void addHospitalByItself() {
        String sql = "INSERT INTO HOSPITAL (facility_number,system_number,hospital_name,location_id)" +
                "VALUES (?,?,?,?)";
        connection = DatabaseController.connection();
        boolean flag = false;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (addHospitalFacility.getText().isEmpty() || addHospitalSystem.getText().isEmpty() ||
                    addHospitalName.getText().isEmpty() || addHospitalArea.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the fields");
                alert.showAndWait();
                flag=true;
            } else if (addHospitalFacility.getText().matches("[a-zA-Z]+") || addHospitalSystem.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter a valid facility number or system number");
                alert.showAndWait();
                flag=true;
            } else if (addHospitalName.getText().matches("[0-9]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter a valid hospital name");
                alert.showAndWait();
                flag=true;
            } else if (addHospitalArea.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter a valid area code");
                alert.showAndWait();
                flag=true;
            }
            //checking if the primary key already exists
            String sqlQuery2 = "SELECT * FROM HOSPITAL WHERE facility_number = ?";
            preparedStatement = connection.prepareStatement(sqlQuery2);
            preparedStatement.setString(1, addHospitalFacility.getText());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                alert.setTitle("Error");
                alert.setHeaderText("Hospital already exists");
                alert.showAndWait();
                flag=true;
            }

            //checking if the foreign key exists
            String sql3 = "SELECT * FROM LOCATION WHERE area_code = ?";
            preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setString(1, addHospitalArea.getText());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter a valid area code");
                alert.showAndWait();
                flag=true;
            } else if(!flag){
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, addHospitalFacility.getText());
                preparedStatement.setString(2, addHospitalSystem.getText());
                preparedStatement.setString(3, addHospitalName.getText());
                preparedStatement.setString(4, addHospitalArea.getText());
                preparedStatement.executeUpdate();
                alert.setTitle("Success");
                alert.setHeaderText("Hospital added successfully");
                alert.showAndWait();
                hospitalList = addHospitalTable();
                addHospitalListView();

                addHospitalFacility.clear();
                addHospitalSystem.clear();
                addHospitalName.clear();
                addHospitalArea.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeByItself() {
        String sqlQuery = "INSERT INTO EMPLOYEE (emp_id,emp_name,start_date,end_date,Productive_hours,hospital_id)" +
                "VALUES (?,?,?,?,?,?)";
        connection = DatabaseController.connection();
        boolean flag = false;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (addEmpId.getText().isEmpty() || addEmpName.getText().isEmpty() ||
                    addEmpStartDate.getValue().toString().isEmpty() || addEmpEndDate.getValue().toString().isEmpty() ||
                    addEmpHours.getText().isEmpty() || addHospitalToEmployee.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the fields");
                alert.showAndWait();
                flag=true;
            } else if (addEmpId.getText().matches("[a-zA-Z]+") || addEmpName.getText().matches("[0-9]+") ||
                    addEmpStartDate.getValue().toString().matches("[a-zA-Z]+") || addEmpEndDate.getValue().toString().matches("[a-zA-Z]+") ||
                    addEmpHours.getText().matches("[a-zA-Z]+") || addHospitalToEmployee.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (addEmpId.getText().length() > 10 || addEmpName.getText().length() > 20 ||
                    addEmpStartDate.getValue().toString().length() > 10 || addEmpEndDate.getValue().toString().length() > 10 ||
                    addEmpHours.getText().length() > 10 || addHospitalToEmployee.getText().length() > 10) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (Integer.parseInt(addEmpId.getText()) < 0 || Integer.parseInt(addEmpHours.getText()) < 0 || Integer.parseInt(addHospitalToEmployee.getText()) < 0) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (Integer.parseInt(addEmpId.getText()) > 999999999 || Integer.parseInt(addEmpHours.getText()) > 999999999 || Integer.parseInt(addHospitalToEmployee.getText()) > 999999999) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            }

            //checking if the foreign key exists
            else {
                String sqlQuery1 = "SELECT COUNT(*) FROM HOSPITAL WHERE facility_number=?";
                PreparedStatement statement1 = connection.prepareStatement(sqlQuery1);
                int hospitalId = Integer.parseInt(addHospitalToEmployee.getText());
                statement1.setInt(1, hospitalId);
                ResultSet resultSet1 = statement1.executeQuery();
                resultSet1.next();
                int count = resultSet1.getInt(1);

                if (count == 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("This Hospital does not exist");
                    alert.showAndWait();
                    flag=true;
                }
            }
            //checking if the primary key entered already exists
            String primaryKey = addEmpId.getText();
            String sql = "SELECT * FROM EMPLOYEE WHERE emp_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, primaryKey);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // A record with the same primary key already exists
                alert.setTitle("Duplicate Primary Key");
                alert.setHeaderText("A record with the same empID already exists.");
                alert.setContentText("Please enter a unique Empid.");
                alert.showAndWait();
                flag=true;

            }

            if(!flag) {
                preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setInt(1, Integer.parseInt(addEmpId.getText()));
                preparedStatement.setString(2, addEmpName.getText());
                preparedStatement.setDate(3, Date.valueOf(addEmpStartDate.getValue()));
                preparedStatement.setDate(4, Date.valueOf(addEmpEndDate.getValue()));
                preparedStatement.setInt(5, Integer.parseInt(addEmpHours.getText()));
                preparedStatement.setInt(6, Integer.parseInt(addHospitalToEmployee.getText()));


                preparedStatement.executeUpdate();
                addEmpList = addEmpTable();
                addEmpListView();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeAdd() {
        //this first choice is just to check if the user wants to add an employee alone without specializations
        String specialization = addEmpChoice.getValue();


        //adding doctor
        if (specialization == "Doctor") {
            boolean flag= false;
            addEmployeeByItself();
            String sqlQueryDoc = "INSERT INTO DOCTOR (employee_id,doctor_id,speciality)" +
                    "VALUES (?,?,?)";

            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty() || addDoctorId.getText().isEmpty() ||
                        addSpeciality.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().matches("[a-zA-Z]+") || addDoctorId.getText().matches("[a-zA-Z]+") ||
                        addSpeciality.getText().matches("[0-9]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().length() > 10 || addDoctorId.getText().length() > 10 ||
                        addSpeciality.getText().length() > 20) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) < 0 || Integer.parseInt(addDoctorId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999 || Integer.parseInt(addDoctorId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                }

                //checking if the primary key Doctor id already exists

                String primaryKey = addDoctorId.getText();
                String sql = "SELECT * FROM DOCTOR WHERE doctor_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    // A record with the same primary key already exists
                    alert.setTitle("Duplicate Primary Key");
                    alert.setHeaderText("A record with the same doctorID already exists.");
                    alert.setContentText("Please enter a unique doctorID.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }
                if(!flag) {
                    preparedStatement = connection.prepareStatement(sqlQueryDoc);
                    preparedStatement.setInt(1, Integer.parseInt(addEmpId.getText()));
                    preparedStatement.setInt(2, Integer.parseInt(addDoctorId.getText()));
                    preparedStatement.setString(3, addSpeciality.getText());
                    preparedStatement.executeUpdate();
                    alert.setTitle("Success");
                    alert.setHeaderText("Doctor added successfully");
                    alert.showAndWait();
                    addEmpList = addEmpTable();
                    addEmpListView();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (specialization == "Nurse") {
            boolean flag= false;
            addEmployeeByItself();
            String sqlQueryNurse = "INSERT INTO NURSE (employee_id,nurse_id,assigned_room)" +
                    "VALUES (?,?,?)";
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty() || addNurseId.getText().isEmpty() ||
                        addRoom.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().matches("[a-zA-Z]+") || addNurseId.getText().matches("[a-zA-Z]+") ||
                        addRoom.getText().matches("[a-zA-Z]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().length() > 10 || addNurseId.getText().length() > 10 ||
                        addRoom.getText().length() > 10) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) < 0 || Integer.parseInt(addNurseId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999 || Integer.parseInt(addNurseId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                }

                //checking if the primary key Nurse id already exists

                String primaryKey = addNurseId.getText();
                String sql = "SELECT * FROM NURSE WHERE nurse_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    // A record with the same primary key already exists
                    alert.setTitle("Duplicate Primary Key");
                    alert.setHeaderText("A record with the same nurseID already exists.");
                    alert.setContentText("Please enter a unique nurseID.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }
                if(!flag) {
                    preparedStatement = connection.prepareStatement(sqlQueryNurse);
                    preparedStatement.setInt(1, Integer.parseInt(addEmpId.getText()));
                    preparedStatement.setInt(2, Integer.parseInt(addNurseId.getText()));
                    preparedStatement.setInt(3, Integer.parseInt(addRoom.getText()));
                    preparedStatement.executeUpdate();
                    alert.setTitle("Success");
                    alert.setHeaderText("Nurse added successfully");
                    alert.showAndWait();
                    addEmpList = addEmpTable();
                    addEmpListView();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (specialization == "Receptionist") {
            addEmployeeByItself();
            boolean flag= false;
            String sqlQueryReceptionist = "INSERT INTO RECEPTIONIST (employee_id,desk_number)" +
                    "VALUES (?,?)";
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty() || addDeskNumber.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().matches("[a-zA-Z]+") || addDeskNumber.getText().matches("[a-zA-Z]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().length() > 10 || addDeskNumber.getText().length() > 10) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                }

                //checking if the primary key Receptionist id already exists

                String primaryKey = addDeskNumber.getText();
                String sql = "SELECT * FROM RECEPTIONIST WHERE desk_number = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    // A record with the same primary key already exists
                    alert.setTitle("Duplicate Primary Key");
                    alert.setHeaderText("A record with the same desk number already exists.");
                    alert.setContentText("Please enter a unique desk number.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }
                if(!flag) {
                    preparedStatement = connection.prepareStatement(sqlQueryReceptionist);
                    preparedStatement.setInt(1, Integer.parseInt(addEmpId.getText()));
                    preparedStatement.setInt(2, Integer.parseInt(addDeskNumber.getText()));
                    preparedStatement.executeUpdate();
                    alert.setTitle("Success");
                    alert.setHeaderText("Receptionist added successfully");
                    addEmpList = addEmpTable();
                    addEmpListView();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public void addPatientAdd() {
        String sqlQuery = "INSERT INTO PATIENT (report_id,phone,address,patient_name,health_care_num,facility_num," +
                "cabin_number,doctor_id,nurse_id)" +
                "VALUES (?,?,?,?,?,?)";
        connection = DatabaseController.connection();
        boolean flag= false;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (patientReportField.getText().isEmpty() || patientPhoneField.getText().isEmpty() || patientAddressField.getText().isEmpty() ||
                    patientNameFeild.getText().isEmpty() || patientHealthNumField.getText().isEmpty() || patientFacilityNumField.getText().isEmpty() ||
                    patientCabinfeild.getText().isEmpty() || patientDoctorFeild.getText().isEmpty() || patientNurseIdFeild.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the fields");
                alert.showAndWait();
                flag=true;
            } else if (patientReportField.getText().matches("[a-zA-Z]+") || patientPhoneField.getText().matches("[a-zA-Z]+") ||
                    patientHealthNumField.getText().matches("[a-zA-Z]+") || patientFacilityNumField.getText().matches("[a-zA-Z]+") ||
                    patientCabinfeild.getText().matches("[a-zA-Z]+") || patientDoctorFeild.getText().matches("[a-zA-Z]+") ||
                    patientNurseIdFeild.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter letters only in name field and address field");
                alert.showAndWait();
                flag=true;
            } else if (patientPhoneField.getText().length() > 11 || patientReportField.getText().length() > 10 ||
                    patientHealthNumField.getText().length() > 10 || patientFacilityNumField.getText().length() > 10 ||
                    patientCabinfeild.getText().length() > 10 || patientDoctorFeild.getText().length() > 10 ||
                    patientNurseIdFeild.getText().length() > 10) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid phone number");
                alert.showAndWait();
                flag=true;
            } else if (Integer.parseInt(patientReportField.getText()) < 0 || Integer.parseInt(patientPhoneField.getText()) < 0 ||
                    Integer.parseInt(patientHealthNumField.getText()) < 0 || Integer.parseInt(patientFacilityNumField.getText()) < 0 ||
                    Integer.parseInt(patientCabinfeild.getText()) < 0 || Integer.parseInt(patientDoctorFeild.getText()) < 0 ||
                    Integer.parseInt(patientNurseIdFeild.getText()) < 0) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid numbers");
                alert.showAndWait();
                flag=true;
            } else if (Integer.parseInt(patientReportField.getText()) > 999999999 ||
                    Integer.parseInt(patientHealthNumField.getText()) > 999999999 || Integer.parseInt(patientFacilityNumField.getText()) > 999999999 ||
                    Integer.parseInt(patientCabinfeild.getText()) > 999999999 || Integer.parseInt(patientDoctorFeild.getText()) > 999999999 ||
                    Integer.parseInt(patientNurseIdFeild.getText()) > 999999999) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid numbers in integer range");
                alert.showAndWait();
                flag=true;
            } else if (patientNameFeild.getText().matches("[0-9]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data in the name field");
                alert.showAndWait();
                flag=true;
            } else {
                //checking if patient with this health num already exists
                String primaryKey = patientHealthNumField.getText();
                String sql = "SELECT * FROM Patient WHERE health_care_num = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    // A record with the same primary key already exists
                    alert.setTitle("Duplicate Primary Key");
                    alert.setHeaderText("A Patient with the same health care number already exists.");
                    alert.setContentText("Please enter a unique health care number.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }
                //checking if foreign keys exists
                String sql1 = "SELECT * FROM DOCTOR WHERE doctor_id = ?";
                PreparedStatement pstmt1 = connection.prepareStatement(sql1);
                pstmt1.setString(1, patientDoctorFeild.getText());
                ResultSet rs1 = pstmt1.executeQuery();
                if (!rs1.next()) {
                    alert.setTitle("Invalid Foreign Key");
                    alert.setHeaderText("A Doctor with the same doctor id does not exist.");
                    alert.setContentText("Please enter a valid doctor id.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }

                String sql2 = "SELECT * FROM NURSE WHERE nurse_id = ?";
                PreparedStatement pstmt2 = connection.prepareStatement(sql2);
                pstmt2.setString(1, patientNurseIdFeild.getText());
                ResultSet rs2 = pstmt2.executeQuery();
                if (!rs2.next()) {
                    alert.setTitle("Invalid Foreign Key");
                    alert.setHeaderText("A Nurse with the same nurse id does not exist.");
                    alert.setContentText("Please enter a valid nurse id.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }

                String sql3 = "SELECT * FROM CABIN WHERE cabin_number = ?";
                PreparedStatement pstmt3 = connection.prepareStatement(sql3);
                pstmt3.setString(1, patientCabinfeild.getText());
                ResultSet rs3 = pstmt3.executeQuery();
                if (!rs3.next()) {
                    alert.setTitle("Invalid Foreign Key");
                    alert.setHeaderText("A Cabin with the same cabin number does not exist.");
                    alert.setContentText("Please enter a valid cabin number.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }

                String sql4 = "SELECT * FROM MEDICAL_REPORT WHERE report_id = ?";
                PreparedStatement pstmt4 = connection.prepareStatement(sql4);
                pstmt4.setString(1, patientReportField.getText());
                ResultSet rs4 = pstmt4.executeQuery();
                if (!rs4.next()) {
                    alert.setTitle("Invalid Foreign Key");
                    alert.setHeaderText("A Medical Report with the same report id does not exist.");
                    alert.setContentText("Please enter a valid report id.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }

                String sql5 = "SELECT * FROM HOSPITAL WHERE facility_number = ?";
                PreparedStatement pstmt5 = connection.prepareStatement(sql5);
                pstmt5.setString(1, patientFacilityNumField.getText());
                ResultSet rs5 = pstmt5.executeQuery();
                if (!rs5.next()) {
                    alert.setTitle("Invalid Foreign Key");
                    alert.setHeaderText("A Hospital with the same facility number does not exist.");
                    alert.setContentText("Please enter a valid facility number.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }

                //checking to make sure the report id is unique
                String sql7 = "SELECT * FROM PATIENT WHERE report_id = ?";
                PreparedStatement pstmt7 = connection.prepareStatement(sql7);
                pstmt7.setString(1, patientReportField.getText());
                ResultSet rs7 = pstmt7.executeQuery();
                if (rs7.next()) {
                    alert.setTitle("Duplicate Report id");
                    alert.setHeaderText("A Patient with the same report id already exists.");
                    alert.setContentText("Please enter a unique report id.");
                    alert.showAndWait();
                    flag=true;
                    return;
                }

                if(!flag) {

                    //inserting data into database
                    String sql6 = "INSERT INTO PATIENT VALUES(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pstmt6 = connection.prepareStatement(sql6);
                    pstmt6.setString(4, patientNameFeild.getText());
                    pstmt6.setString(3, patientAddressField.getText());
                    pstmt6.setString(2, patientPhoneField.getText());
                    pstmt6.setString(5, patientHealthNumField.getText());
                    pstmt6.setString(6, patientFacilityNumField.getText());
                    pstmt6.setString(1, patientReportField.getText());
                    pstmt6.setString(8, patientDoctorFeild.getText());
                    pstmt6.setString(9, patientNurseIdFeild.getText());
                    pstmt6.setString(7, patientCabinfeild.getText());
                    pstmt6.executeUpdate();
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText("Patient added successfully");
                    alert1.showAndWait();
                    patientNameFeild.clear();
                    patientAddressField.clear();
                    patientPhoneField.clear();
                    patientHealthNumField.clear();
                    patientFacilityNumField.clear();
                    patientReportField.clear();
                    patientDoctorFeild.clear();
                    patientNurseIdFeild.clear();
                    patientCabinfeild.clear();
                    patientList = addPatient();
                    addPatientListView();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //this method takes care of users choice and is responsible for making text fields visible
    public void userSelectedChoice(ActionEvent e) {
        String specialization = addEmpChoice.getValue();
        if (specialization.equals("Doctor")) {
            addNurseId.setVisible(false);
            addDeskNumber.setVisible(false);
            addRoom.setVisible(false);
            addDoctorId.setVisible(true);
            addSpeciality.setVisible(true);
        } else if (specialization.equals("Receptionist")) {
            addDoctorId.setVisible(false);
            addSpeciality.setVisible(false);
            addRoom.setVisible(false);
            addNurseId.setVisible(false);
            addDeskNumber.setVisible(true);
        } else if (specialization.equals("Nurse")) {
            addDoctorId.setVisible(false);
            addSpeciality.setVisible(false);
            addDeskNumber.setVisible(false);
            addRoom.setVisible(true);
            addNurseId.setVisible(true);
        }
    }

    //this method reset the feilds in add employee
    public void resetAddEmp() {
        addEmpId.clear();
        addRoom.clear();
        addEmpStartDate.setValue(null);
        addEmpChoice.setValue("");
        addEmpEndDate.setValue(null);
        addEmpHours.clear();
        addEmpName.clear();
        addDeskNumber.clear();
        addNurseId.clear();
        addDoctorId.clear();
        addSpeciality.clear();
        addHospitalToEmployee.clear();
        addNurseId.setVisible(true);
        addDeskNumber.setVisible(true);
        addRoom.setVisible(true);
        addDoctorId.setVisible(true);
        addSpeciality.setVisible(true);
        addDoctorId.setVisible(true);
        addSpeciality.setVisible(true);
        addRoom.setVisible(true);
        addNurseId.setVisible(true);
        addDeskNumber.setVisible(true);
        addDoctorId.setVisible(true);
        addSpeciality.setVisible(true);
        addDeskNumber.setVisible(true);
        addRoom.setVisible(true);
        addNurseId.setVisible(true);
    }

    public void resetAddPatient() {
        patientNameFeild.clear();
        patientAddressField.clear();
        patientPhoneField.clear();
        patientHealthNumField.clear();
        patientFacilityNumField.clear();
        patientReportField.clear();
        patientDoctorFeild.clear();
        patientNurseIdFeild.clear();
        patientCabinfeild.clear();
    }

    //this method is responsible for deleting an employee
    public void deleteEmployeeByItself() {
        String sqlEmp = "DELETE FROM EMPLOYEE WHERE emp_id = ?";
        boolean flag= false;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (addEmpId.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the fields");
                alert.showAndWait();
                flag=true;
            } else if (addEmpId.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (addEmpId.getText().length() > 10) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (Integer.parseInt(addEmpId.getText()) < 0) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (Integer.parseInt(addEmpId.getText()) > 999999999) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            }
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Confirmation");
            alert1.setHeaderText("Are you sure you want to delete this employee?");
            Optional<ButtonType> result = alert1.showAndWait();

            if (result.get() == ButtonType.OK) {
                {
                    if(flag==false) {
                        preparedStatement = connection.prepareStatement(sqlEmp);
                        preparedStatement.setInt(1, Integer.parseInt(addEmpId.getText()));
                        preparedStatement.executeUpdate();
                        addEmpList = addEmpTable();
                        addEmpListView();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //deletes an employe
    public void deleteEmp(ActionEvent e) {
        String sqlEmp = "DELETE FROM EMPLOYEE WHERE emp_id = ?";

        if (addEmpChoice.getValue() == null || addEmpChoice.getValue().equals("")) {
            deleteEmployeeByItself();
        }
        //deleting a doctor
        else if (addEmpChoice.getValue().equals("Doctor")) {
            String sqlDoctor = "DELETE FROM DOCTOR WHERE doctor_id = ?";
            boolean flag= false;
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty() || addDoctorId.getText().isEmpty() ||
                        addSpeciality.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().matches("[a-zA-Z]+") || addDoctorId.getText().matches("[a-zA-Z]+") ||
                        addSpeciality.getText().matches("[0-9]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().length() > 10 || addDoctorId.getText().length() > 10 ||
                        addSpeciality.getText().length() > 20) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) < 0 || Integer.parseInt(addDoctorId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999 || Integer.parseInt(addDoctorId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                }


                    //checking if the primary key Doctor id exists
                    String primaryKey = addDoctorId.getText();
                    String sql = "SELECT * FROM DOCTOR WHERE doctor_id = ?";
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, primaryKey);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()&&flag==false) {
                        // A record with the same primary key exists
                        //delete the doctor
                        String SQL = "DELETE FROM DOCTOR WHERE doctor_id = ?";
                        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                        alert1.setTitle("Confirmation");
                        alert1.setHeaderText("Are you sure you want to delete this doctor?");
                        Optional<ButtonType> result = alert1.showAndWait();

                        if (result.get() == ButtonType.OK) {
                            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                            preparedStatement.setInt(1, Integer.parseInt(addDoctorId.getText()));
                            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlEmp);
                            preparedStatement2.setInt(1, Integer.parseInt(addEmpId.getText()));
                            preparedStatement.executeUpdate();
                            preparedStatement2.executeUpdate();
                            addEmpList = addEmpTable();
                            addEmpListView();
                        }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //deleting a nurse
        else if (addEmpChoice.getValue().equals("Nurse")) {
            boolean flag= false;
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                String sqlNurse = "DELETE FROM NURSE WHERE nurse_id = ?";

                if (addEmpId.getText().isEmpty() || addNurseId.getText().isEmpty() ||
                        addRoom.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().matches("[a-zA-Z]+") || addNurseId.getText().matches("[a-zA-Z]+") ||
                        addRoom.getText().matches("[a-zA-Z]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().length() > 10 || addNurseId.getText().length() > 10 ||
                        addRoom.getText().length() > 10) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) < 0 || Integer.parseInt(addNurseId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999 || Integer.parseInt(addNurseId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                }

                //checking if the primary key Nurse id exists
                String primaryKey = addNurseId.getText();
                String sql = "SELECT * FROM NURSE WHERE nurse_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()&&!flag) {
                    // A record with the same primary key exists
                    //delete the nurse
                    String SQL = "DELETE FROM NURSE WHERE nurse_id = ?";
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("Confirmation");
                    alert1.setHeaderText("Are you sure you want to delete this nurse?");
                    Optional<ButtonType> result = alert1.showAndWait();

                    if (result.get() == ButtonType.OK) {
                        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                        preparedStatement.setInt(1, Integer.parseInt(addNurseId.getText()));
                        PreparedStatement preparedStatement2 = connection.prepareStatement(sqlEmp);
                        preparedStatement2.setInt(1, Integer.parseInt(addEmpId.getText()));
                        preparedStatement.executeUpdate();
                        preparedStatement2.executeUpdate();
                        addEmpList = addEmpTable();
                        addEmpListView();
                    }
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (addEmpChoice.getValue().equals("Receptionist")) {
            String sql = "DELETE FROM RECEPTIONIST WHERE desk_number= ?";
            boolean flag= false;
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty() || addDeskNumber.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().matches("[a-zA-Z]+") || addDeskNumber.getText().matches("[a-zA-Z]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (addEmpId.getText().length() > 10 || addDeskNumber.getText().length() > 10) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) < 0 || Integer.parseInt(addDeskNumber.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999 || Integer.parseInt(addDeskNumber.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                    flag=true;
                }

                //checking if the primary key Receptionist id exists
                String primaryKey = addDeskNumber.getText();
                String sql1 = "SELECT * FROM RECEPTIONIST WHERE desk_number = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql1);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()&&!flag) {
                    // A record with the same primary key exists
                    //delete the receptionist
                    String SQL = "DELETE FROM RECEPTIONIST WHERE desk_number = ?";
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("Confirmation");
                    alert1.setHeaderText("Are you sure you want to delete this receptionist?");
                    Optional<ButtonType> result = alert1.showAndWait();

                    if (result.get() == ButtonType.OK) {
                        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                        preparedStatement.setInt(1, Integer.parseInt(addDeskNumber.getText()));
                        PreparedStatement preparedStatement2 = connection.prepareStatement(sqlEmp);
                        preparedStatement2.setInt(1, Integer.parseInt(addEmpId.getText()));
                        preparedStatement.executeUpdate();
                        preparedStatement2.executeUpdate();
                        addEmpList = addEmpTable();
                        addEmpListView();
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }

    public void deleteLocation() {
        String sql = "DELETE FROM LOCATION WHERE area_code= ?";
        boolean flag= false;
        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (addAreaCode.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the fields");
                alert.showAndWait();
                flag=true;
            } else if (addAreaCode.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (addAreaCode.getText().length() > 10) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else {

                //checking if the primary key Location area code exists
                String primaryKey = addAreaCode.getText();
                String sql1 = "SELECT * FROM LOCATION WHERE area_code = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql1);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()&&!flag) {
                    // A record with the same primary key exists
                    //delete the location
                    String SQL = "DELETE FROM LOCATION WHERE area_code = ?";
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("Confirmation");
                    alert1.setHeaderText("Are you sure you want to delete this location? This will delete the hospital that is in" + addAreaCode.getText());
                    Optional<ButtonType> result = alert1.showAndWait();

                    if (result.get() == ButtonType.OK) {
                        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                        preparedStatement.setString(1, addAreaCode.getText());
                        preparedStatement.executeUpdate();
                        locationList = addLocationTable();
                        addLocationListView();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteHospital() {
        String sql = "DELETE FROM HOSPITAL WHERE location_id= ?";
        boolean flag= false;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (addHospitalArea.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the fields");
                alert.showAndWait();
                flag=true;
            } else if (addHospitalArea.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (addHospitalArea.getText().length() > 10) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else {
                //checking to see if it exists in the table
                String primaryKey = addHospitalArea.getText();
                String sql1 = "SELECT * FROM HOSPITAL WHERE location_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql1);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()&&!flag) {
                    // A record with the same primary key exists
                    //delete the hospital
                    String SQL = "DELETE FROM HOSPITAL WHERE location_id = ?";
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("Confirmation");
                    alert1.setHeaderText("Are you sure you want to delete this hospital? This will delete all the employees and patients who belong to " + addHospitalName.getText());
                    Optional<ButtonType> result = alert1.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                        preparedStatement.setString(1, addHospitalArea.getText());
                        preparedStatement.executeUpdate();
                        hospitalList = addHospitalTable();
                        addHospitalListView();
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deletePatient() {
        String deletePatient = "DELETE FROM PATIENT WHERE health_care_num = ?";
        boolean flag= false;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (patientHealthNumField.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the fields");
                alert.showAndWait();
                flag=true;
            } else if (patientHealthNumField.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else if (patientHealthNumField.getText().length() > 10) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag=true;
            } else {
                //checking to see if it exists in the table
                String primaryKey = patientHealthNumField.getText();
                String sql1 = "SELECT * FROM PATIENT WHERE health_care_num = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql1);
                pstmt.setString(1, primaryKey);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()&&!flag) {
                    // A record with the same primary key exists
                    //delete the patient
                    String SQL = "DELETE FROM PATIENT WHERE health_care_num = ?";
                    Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert1.setTitle("Confirmation");
                    alert1.setHeaderText("Are you sure you want to delete this patient " + patientNameFeild.getText());
                    Optional<ButtonType> result = alert1.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                        preparedStatement.setString(1, patientHealthNumField.getText());
                        preparedStatement.executeUpdate();
                        patientList = addPatient();
                        addPatientListView();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //this method fills out the feilds by the selected row of the table
    public void selectRowFill() {
        Integer index = addEmpTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String employeeID = String.valueOf(addEmpIdCol.getCellData(index));
        String firstName = String.valueOf(addEmpNameCol.getCellData(index));
        String startDate = String.valueOf(addEmpStartDateCol.getCellData(index));
        String endDate = String.valueOf(addEmpEndDateCol.getCellData(index));
        String productiveHours = String.valueOf(addEmpHourCol.getCellData(index));
        String doctorID = String.valueOf(addEmpDoctorIdCol.getCellData(index));
        String speciality = String.valueOf(addEmpSpecialityCol.getCellData(index));
        String nurseID = String.valueOf(addEmpNurseIdCol.getCellData(index));
        String room = String.valueOf(addEmpNurseRoomCol.getCellData(index));
        String receptionistID = String.valueOf(addEmpReceptionDeskNumCol.getCellData(index));
        String hospitalID = String.valueOf(addEmpHospitalId.getCellData(index));


        if (employeeID != null) {
            addEmpId.setText(employeeID);
        }
        if (firstName != null) {
            addEmpName.setText(firstName);
        }
        if (startDate != null) {
            addEmpStartDate.setValue(LocalDate.parse(startDate));
        }
        if (endDate != null) {
            addEmpEndDate.setValue(LocalDate.parse(endDate));
        }
        if (productiveHours != null) {
            addEmpHours.setText(productiveHours);
        }
        if (hospitalID != null) {
            addHospitalToEmployee.setText(hospitalID);
        }
        if (doctorID != null) {
            addDoctorId.setText(doctorID);
            // addEmpChoice.setValue("Doctor");
        }
        if (speciality != null) {
            addSpeciality.setText(speciality);
        }
        if (nurseID != null) {
            addNurseId.setText(nurseID);
            // addEmpChoice.setValue("Nurse");
        }
        if (room != null) {
            addRoom.setText(room);
        }
        if (receptionistID != null) {
            addDeskNumber.setText(receptionistID);
            //addEmpChoice.setValue("Receptionist");
        }

// Set empty string for null values
        if (employeeID == null) {
            addEmpId.clear();
        }
        if (firstName == null) {
            addEmpName.clear();
        }
        if (startDate == null) {
            addEmpStartDate.setValue(null);
        }
        if (endDate == null) {
            addEmpEndDate.setValue(null);
        }
        if (productiveHours == null) {
            addEmpHours.clear();
        }
        if (hospitalID == null) {
            addHospitalToEmployee.clear();
        }
        int value = 0;

        if (nurseID == null || nurseID.equals("null") || nurseID.equals("0")) {
            addNurseId.clear();
        } else {
            addEmpChoice.setValue("Nurse");
        }

        if (room == null || room.equals("null") || room.equals("0")) {
            addRoom.clear();
        }

        if (receptionistID == null || receptionistID.equals("null") || receptionistID.equals("0")) {
            addDeskNumber.clear();
        } else {
            addEmpChoice.setValue("Receptionist");
        }

        if (doctorID == null || doctorID.equals("null") || doctorID.equals("0")) {
            addDoctorId.setText("");
        } else {
            addEmpChoice.setValue("Doctor");
        }


        if (speciality == null || speciality.equals("null") || speciality.equals("0")) {
            addSpeciality.clear();
        }
    }

    public void SelectedChoiceForLocation() {
        Integer index = locationTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String country = String.valueOf(countryCol.getCellData(index));
        String city = String.valueOf(CityCol.getCellData(index));
        String areaCode = String.valueOf(areaCol.getCellData(index));

        if (country != null) {
            addCountry.setText(country);
        }
        if (city != null) {
            addCity.setText(city);
        }
        if (areaCode != null) {
            addAreaCode.setText(areaCode);
        }
    }

    public void selectedChoiceForHospital() {
        Integer index = hospitalTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String hospitalName = String.valueOf(hospitalNameCol.getCellData(index));
        String facility = String.valueOf(facilityNumberCol.getCellData(index));
        String system = String.valueOf(SystemNumberCol.getCellData(index));
        String location = String.valueOf(areaCodeCol.getCellData(index));

        if (hospitalName != null) {
            addHospitalName.setText(hospitalName);
        }
        if (facility != null) {
            addHospitalFacility.setText(facility);
        }
        if (system != null) {
            addHospitalSystem.setText(system);
        }
        if (location != null) {
            addHospitalArea.setText(location);
        }

    }

    public void selectedChoiceForPatient() {
        Integer index = patientTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String reportID = String.valueOf(reportIdColP.getCellData(index));
        String phone = String.valueOf(phoneColP.getCellData(index));
        String address = String.valueOf(addressColP.getCellData(index));
        String patient_name = String.valueOf(nameColP.getCellData(index));
        String health_care_num = String.valueOf(healthColP.getCellData(index));
        String facility_num = String.valueOf(facilityNumColP.getCellData(index));
        String cabin_num = String.valueOf(cabinNumColP.getCellData(index));
        String doctor_id = String.valueOf(doctorIdColP.getCellData(index));
        String nurse_id = String.valueOf(nurseIDColP.getCellData(index));

        if (reportID != null) {
            patientReportField.setText(String.valueOf(reportID));
        }
        if (phone != null) {
            patientPhoneField.setText(String.valueOf(phone));
        }
        if (address != null) {
            patientAddressField.setText(address);
        }
        if (patient_name != null) {
            patientNameFeild.setText(patient_name);
        }
        if (health_care_num != null) {
            patientHealthNumField.setText(String.valueOf(health_care_num));
        }
        if (facility_num != null) {
            patientFacilityNumField.setText(String.valueOf(facility_num));
        }
        if (cabin_num != null) {
            patientCabinfeild.setText(String.valueOf(cabin_num));
        }
        if (doctor_id != null) {
            patientDoctorFeild.setText(String.valueOf(doctor_id));
        }
        if (nurse_id != null) {
            patientNurseIdFeild.setText(String.valueOf(nurse_id));
        }

    }


    public void setUpdateEmployee() {
        String sql = "UPDATE EMPLOYEE SET emp_id='" +
                addEmpId.getText() + "', emp_name='" +
                addEmpName.getText() + "', start_date='" +
                addEmpStartDate.getValue() + "', end_date='" +
                addEmpEndDate.getValue() + "', Productive_hours='" +
                addEmpHours.getText() + "', hospital_id='" +
                addHospitalToEmployee.getText() + "' WHERE emp_id=" +
                addEmpId.getText() + "";
        String sqlDoctor = "UPDATE DOCTOR SET employee_id='" +
                addEmpId.getText() + "', doctor_id='" +
                addDoctorId.getText() + "', speciality='" +
                addSpeciality.getText() + "' WHERE employee_id=" +
                addEmpId.getText() + "";
        String sqlNurse = "UPDATE NURSE SET employee_id='" +
                addEmpId.getText() + "', nurse_id='" +
                addNurseId.getText() + "', assigned_room='" +
                addRoom.getText() + "' WHERE employee_id=" +
                addEmpId.getText() + "";
        String sqlReceptionist = "UPDATE RECEPTIONIST SET employee_id='" +
                addEmpId.getText() + "', desk_number='" +
                addDeskNumber.getText() + "' WHERE employee_id=" +
                addEmpId.getText() + "";


            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                } else if (addEmpId.getText().matches("[a-zA-Z]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (addEmpId.getText().length() > 10) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (Integer.parseInt(addEmpId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                }



                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                    addEmpList = addEmpTable();
                    addEmpListView();



            } catch (Exception ex) {
                ex.printStackTrace();
            }
          if (addEmpChoice.getValue().equals("Doctor")) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty() || addSpeciality.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                } else if (addEmpId.getText().matches("[a-zA-Z]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (addEmpId.getText().length() > 10) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (Integer.parseInt(addEmpId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                }
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText("Are you sure you want to update this doctor?");
                Optional<ButtonType> result = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                    preparedStatement = connection.prepareStatement(sqlDoctor);
                    preparedStatement.executeUpdate();
                    alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Information");
                    alert1.setHeaderText("Doctor updated successfully");
                    alert1.showAndWait();
                    resetAddEmp();
                    addEmpList = addEmpTable();
                    addEmpListView();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (addEmpChoice.getValue().equals("Nurse")) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty() || addRoom.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                } else if (addEmpId.getText().matches("[a-zA-Z]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (addEmpId.getText().length() > 10) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (Integer.parseInt(addEmpId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                }
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText("Are you sure you want to update this nurse?");
                Optional<ButtonType> result = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                    preparedStatement = connection.prepareStatement(sqlNurse);
                    preparedStatement.executeUpdate();

                    alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Information");
                    alert1.setHeaderText("Nurse updated successfully");
                    alert1.showAndWait();
                    resetAddEmp();
                    addEmpList = addEmpTable();
                    addEmpListView();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (addEmpChoice.getValue().equals("Receptionist")) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                if (addEmpId.getText().isEmpty() || addDeskNumber.getText().isEmpty()) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please fill all the fields");
                    alert.showAndWait();
                } else if (addEmpId.getText().matches("[a-zA-Z]+")) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (addEmpId.getText().length() > 10) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (Integer.parseInt(addEmpId.getText()) < 0) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                } else if (Integer.parseInt(addEmpId.getText()) > 999999999) {
                    alert.setTitle("Error");
                    alert.setHeaderText("Please enter valid data");
                    alert.showAndWait();
                }
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText("Are you sure you want to update this receptionist?");
                Optional<ButtonType> result = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                    preparedStatement = connection.prepareStatement(sqlReceptionist);
                    preparedStatement.executeUpdate();

                    alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Information");
                    alert1.setHeaderText("Receptionist updated successfully");
                    alert1.showAndWait();
                    resetAddEmp();
                    addEmpList = addEmpTable();
                    addEmpListView();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //this method updates the patient table
    public void setUpdatePatient() {
        String sql = "UPDATE Patient SET report_id=?, phone=?, address=?, patient_name=?, cabin_number=?, nurse_id=?, doctor_id=?, facility_num=? WHERE health_care_num=?";


        try {
            boolean flag = true;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            if (patientHealthNumField.getText().isEmpty()) {
                alert.setTitle("Error");
                alert.setHeaderText("Please fill all the health number field");
                alert.showAndWait();
                flag = false;
            } else if (patientHealthNumField.getText().matches("[a-zA-Z]+")) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag = false;
            } else if (patientHealthNumField.getText().length() > 10) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag = false;
            } else if (Integer.parseInt(patientHealthNumField.getText()) < 0) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag = false;
            } else if (Integer.parseInt(patientHealthNumField.getText()) > 999999999) {
                alert.setTitle("Error");
                alert.setHeaderText("Please enter valid data");
                alert.showAndWait();
                flag = false;
            }
            //checking to make sure the foreign key doctor_id exists in Doctor table
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            String sql1 = "SELECT * FROM DOCTOR WHERE doctor_id = ?";
            PreparedStatement pstmt1 = connection.prepareStatement(sql1);
            pstmt1.setInt(1, Integer.parseInt(patientDoctorFeild.getText()));
            ResultSet rs1 = pstmt1.executeQuery();
            if (!rs1.next()) {
                alert2.setTitle("Error");
                flag = false;
                alert2.setHeaderText("Doctor ID does not exist. Please enter a valid doctor ID");
                alert2.showAndWait();
            }
            //checking to make sure the foreign key nurse_id exists in Nurse table
            Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
            String sql2 = "SELECT * FROM NURSE WHERE nurse_id = ?";
            PreparedStatement pstmt2 = connection.prepareStatement(sql2);
            pstmt2.setInt(1, Integer.parseInt(patientNurseIdFeild.getText()));
            ResultSet rs2 = pstmt2.executeQuery();
            if (!rs2.next()) {
                alert3.setTitle("Error");
                flag = false;
                alert3.setHeaderText("Nurse ID does not exist. Please enter a valid nurse ID");
                alert3.showAndWait();
            }

            //checking to make sure the foreign key report_id exists in MEDICAL_REPORT table
            Alert alert4 = new Alert(Alert.AlertType.CONFIRMATION);
            String sql3 = "SELECT * FROM MEDICAL_REPORT WHERE report_id = ?";
            PreparedStatement pstmt3 = connection.prepareStatement(sql3);
            pstmt3.setInt(1, Integer.parseInt(patientReportField.getText()));
            ResultSet rs3 = pstmt3.executeQuery();
            if (!rs3.next()) {
                alert4.setTitle("Error");
                flag = false;
                alert4.setHeaderText("Report ID does not exist. Please enter a valid report ID");
                alert4.showAndWait();
            }

            //checking to make sure report_id is unique
            Alert alert7 = new Alert(Alert.AlertType.CONFIRMATION);
            String sql6 = "SELECT * FROM PATIENT WHERE report_id = ?";
            PreparedStatement pstmt6 = connection.prepareStatement(sql6);
            pstmt6.setInt(1, Integer.parseInt(patientReportField.getText()));
            ResultSet rs6 = pstmt6.executeQuery();
            if (rs6.next()) {
                alert7.setTitle("Error");
                flag = false;
                alert7.setHeaderText("Report ID already exists. Please enter a unique report ID");
                alert7.showAndWait();
            }

            //checking to make sure the foreign key facility_num exists in HOSPITAL table
            Alert alert5 = new Alert(Alert.AlertType.CONFIRMATION);
            String sql4 = "SELECT * FROM HOSPITAL WHERE facility_number = ?";
            PreparedStatement pstmt4 = connection.prepareStatement(sql4);
            pstmt4.setInt(1, Integer.parseInt(patientFacilityNumField.getText()));
            ResultSet rs4 = pstmt4.executeQuery();
            if (!rs4.next()) {
                alert5.setTitle("Error");
                flag = false;
                alert5.setHeaderText("Facility number does not exist. Please enter a valid facility number");
                alert5.showAndWait();
            }

            //checking to make sure the foreign key cabin_number exists in CABIN table
            Alert alert6 = new Alert(Alert.AlertType.CONFIRMATION);
            String sql5 = "SELECT * FROM CABIN WHERE cabin_number = ?";
            PreparedStatement pstmt5 = connection.prepareStatement(sql5);
            pstmt5.setInt(1, Integer.parseInt(patientCabinfeild.getText()));
            ResultSet rs5 = pstmt5.executeQuery();
            if (!rs5.next()) {
                alert6.setTitle("Error");
                flag = false;
                alert6.setHeaderText("Cabin number does not exist. Please enter a valid cabin number");
                alert6.showAndWait();
            }
            if (flag) {
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Confirmation");
                alert1.setHeaderText("Are you sure you want to update patient ?" + patientNameFeild.getText());
                Optional<ButtonType> result = alert1.showAndWait();
                if (result.get() == ButtonType.OK) {
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setInt(1, Integer.parseInt(patientReportField.getText()));
                    pstmt.setInt(2, Integer.parseInt(patientPhoneField.getText()));
                    pstmt.setString(3, patientAddressField.getText());
                    pstmt.setString(4, patientNameFeild.getText());
                    pstmt.setInt(7, Integer.parseInt(patientCabinfeild.getText()));
                    pstmt.setInt(9, Integer.parseInt(patientNurseIdFeild.getText()));
                    pstmt.setInt(8, Integer.parseInt(patientDoctorFeild.getText()));
                    pstmt.setInt(6, Integer.parseInt(patientFacilityNumField.getText()));
                    pstmt.setInt(5, Integer.parseInt(patientHealthNumField.getText()));
                    pstmt.executeUpdate();
                    alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Information");
                    alert1.setHeaderText("Patient updated successfully");
                    alert1.showAndWait();
                    resetAddPatient();
                    patientList = addPatient();
                    addPatientListView();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void employeeSearch(String newValue) {
        FilteredList<Employee> filteredList = new FilteredList<>(addEmpList, e -> true);
        filteredList.setPredicate(employee -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if (String.valueOf(employee.getEmpId()).toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (String.valueOf(employee.getHospitalID()).toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (employee.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (employee.getStartDate().toString().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (employee.getEndDate().toString().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (String.valueOf(employee.getHours()).toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            return false;
        });

        SortedList<Employee> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(addEmpTable.comparatorProperty());
        addEmpTable.setItems(sortedList);
    }

    //find total doctors
    public int totalDoctors() {
        int total = 0;
        try {
            String sql = "SELECT COUNT(*) FROM DOCTOR";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }

    //find total nurses

    public int totalNurses() {
        int total = 0;
        try {
            String sql = "SELECT COUNT(*) FROM NURSE";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }

    //find total patients
    public int totalPatients() {
        int total = 0;
        try {
            String sql = "SELECT COUNT(*) FROM PATIENT";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }

    //find total receptionist
    public int totalReceptionist() {
        int total = 0;
        try {
            String sql = "SELECT COUNT(*) FROM RECEPTIONIST";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }

    public void patientaveragestayChart() {
        String averageStayQuery = "SELECT AVG(DATEDIFF(discharge_date, assigned_date)) as average_stay FROM MEDICAL_REPORT";
        double averageStay = 0;

        try {
            PreparedStatement pstmt = connection.prepareStatement(averageStayQuery);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                averageStay = rs.getDouble("average_stay");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        pieChartData.add(new PieChart.Data("Target Average Stay", 5));
        pieChartData.add(new PieChart.Data("Actual Average Stay", averageStay));
        patientPieChart.setData(pieChartData);
    }

    public void chart(){
        String numberOfFullBenefits = "SELECT COUNT(*) FROM FULL_BENEFITS";
        String numberOfPartBenefits = "SELECT COUNT(*) FROM HALF_BENEFITS";
        String numberOfNoBenefits = "SELECT COUNT(*) FROM NO_BENEFITS";
        int fullbenefit=0;
        int partbenefit=0;
        int nobenefit=0;
        try{
            PreparedStatement pstmt = connection.prepareStatement(numberOfFullBenefits);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                fullbenefit = rs.getInt(1);
            }
            pstmt = connection.prepareStatement(numberOfPartBenefits);
            rs = pstmt.executeQuery();
            while(rs.next()){
                partbenefit = rs.getInt(1);
            }
            pstmt = connection.prepareStatement(numberOfNoBenefits);
            rs = pstmt.executeQuery();
            while(rs.next()){
                nobenefit = rs.getInt(1);
            }

            //updating the barchart with data
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data<>("F", fullbenefit));
            series.getData().add(new XYChart.Data<>("H", partbenefit));
            series.getData().add(new XYChart.Data<>("N", nobenefit));
            Platform.runLater(() -> {
                barChart.getData().clear();
                barChart.getData().add(series);


            });

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void leadershipBoard(){
        List<String> top5emp = new ArrayList<>();
        List <Integer> top5hours = new ArrayList<>();
        try {
            String query = "SELECT emp_name, Productive_hours FROM EMPLOYEE ORDER BY Productive_hours DESC LIMIT 5";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                top5emp.add(rs.getString("emp_name"));
                top5hours.add(rs.getInt("Productive_hours"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        //assigning employee names to labels
        leader1.setText(top5emp.get(0));
        leader2.setText(top5emp.get(1));
        leader3.setText(top5emp.get(2));
        leader4.setText(top5emp.get(3));
        leader5.setText(top5emp.get(4));

        //assigning employee hours to labels
        emp1.setText(String.valueOf(top5hours.get(0)));
        emp2.setText(String.valueOf(top5hours.get(1)));
        emp3.setText(String.valueOf(top5hours.get(2)));
        emp4.setText(String.valueOf(top5hours.get(3)));
        emp5.setText(String.valueOf(top5hours.get(4)));

        winner.setText(top5emp.get(0));



    }


}


