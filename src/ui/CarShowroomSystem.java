package ui;


//import dal.IConnection;
import controller.Car;
import controller.CarShowroom;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;






public class CarShowroomSystem extends JFrame {
    private CarShowroom showroom;
    private JButton addCarButton;
    private JButton deleteCarButton;
    private JButton updateCarButton;
    private JButton searchByModelButton;
    private JButton searchByCompanyNameButton;
    private JButton viewCarsButton;
    private JTextArea outputTextArea;

    public CarShowroomSystem() {
        showroom = new CarShowroom();

        setTitle("Car Showroom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 400));

        // Set background color
        getContentPane().setBackground(new Color(135, 206, 250));

        // Create a panel for buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(173, 216, 230));
        buttonsPanel.setLayout(new GridLayout(6, 1, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add Car button
        addCarButton = new JButton("Add Car");
        addCarButton.setBackground(new Color(135, 206, 250));
        addCarButton.setForeground(Color.WHITE);
        addCarButton.setFont(new Font("Arial", Font.BOLD, 16));
        addCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddCarScreen();
            }
        });
        buttonsPanel.add(addCarButton);

        // Delete Car button
        deleteCarButton = new JButton("Delete Car");
        deleteCarButton.setBackground(new Color(135, 206, 250));
        deleteCarButton.setForeground(Color.WHITE);
        deleteCarButton.setFont(new Font("Arial", Font.BOLD, 16));
        deleteCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDeleteCarScreen();
            }
        });
        buttonsPanel.add(deleteCarButton);

        // Update Car button
        updateCarButton = new JButton("Update Car");
        updateCarButton.setBackground(new Color(135, 206, 250));
        updateCarButton.setForeground(Color.WHITE);
        updateCarButton.setFont(new Font("Arial", Font.BOLD, 16));
        updateCarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showUpdateCarScreen();
            }
        });
        buttonsPanel.add(updateCarButton);

        // Search by Model button
        searchByModelButton = new JButton("Search by Model");
        searchByModelButton.setBackground(new Color(125, 206, 200));
        searchByModelButton.setForeground(Color.WHITE);
        searchByModelButton.setFont(new Font("Arial", Font.BOLD, 16));
        searchByModelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSearchByModelScreen();
            }
        });
        buttonsPanel.add(searchByModelButton);

        // Search by Company Name button
        searchByCompanyNameButton = new JButton("Search by Company Name");
        searchByCompanyNameButton.setBackground(new Color(135, 206, 250));
        searchByCompanyNameButton.setForeground(Color.WHITE);
        searchByCompanyNameButton.setFont(new Font("Arial", Font.BOLD, 16));
        searchByCompanyNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSearchByCompanyNameScreen();
            }
        });
        buttonsPanel.add(searchByCompanyNameButton);

        // View Cars button
        viewCarsButton = new JButton("View Cars");
        viewCarsButton.setBackground(new Color(135, 206, 250));
        viewCarsButton.setForeground(Color.WHITE);
        viewCarsButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewCarsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showViewCarsScreen();
            }
        });
        buttonsPanel.add(viewCarsButton);

        // Create the output panel
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        // Create the heading label
        JLabel headingLabel = new JLabel("Car Showroom");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Add components to the JFrame
        add(headingLabel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showAddCarScreen() {
        JFrame addCarFrame = new JFrame("Add Car");
        addCarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addCarFrame.setLayout(new GridLayout(8, 2, 10, 10));
        addCarFrame.setPreferredSize(new Dimension(400, 300));

        addCarFrame.add(new JLabel("Car Model:"));
        JTextField modelTextField = new JTextField();
        addCarFrame.add(modelTextField);

        addCarFrame.add(new JLabel("Color:"));
        JTextField colorTextField = new JTextField();
        addCarFrame.add(colorTextField);

        addCarFrame.add(new JLabel("Engine Type:"));
        JTextField engineTextField = new JTextField();
        addCarFrame.add(engineTextField);

        addCarFrame.add(new JLabel("Number of Seats:"));
        JTextField seatsTextField = new JTextField();
        addCarFrame.add(seatsTextField);

        addCarFrame.add(new JLabel("Air Conditioning:"));
        JTextField acTextField = new JTextField();
        addCarFrame.add(acTextField);

        addCarFrame.add(new JLabel("Price:"));
        JTextField priceTextField = new JTextField();
        addCarFrame.add(priceTextField);

        addCarFrame.add(new JLabel("Company Name:"));
        JTextField companyTextField = new JTextField();
        addCarFrame.add(companyTextField);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(173, 216, 230));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String model = modelTextField.getText();
                String color = colorTextField.getText();
                String engineType = engineTextField.getText();
                int numberOfSeats = Integer.parseInt(seatsTextField.getText());
                String airConditioning = acTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                String companyName = companyTextField.getText();

                Car newCar = new Car(model, color, engineType, numberOfSeats, airConditioning, price, companyName);
                showroom.addCar(newCar);

                outputTextArea.append("Car added successfully!\n");
                addCarFrame.dispose();
            }
        });
        addCarFrame.add(saveButton);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(173, 216, 230));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCarFrame.dispose();
            }
        });
        addCarFrame.add(backButton);

        addCarFrame.pack();
        addCarFrame.setLocationRelativeTo(null);
        addCarFrame.setVisible(true);
    }

    private void showDeleteCarScreen() {
        JFrame deleteCarFrame = new JFrame("Delete Car");
        deleteCarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteCarFrame.setLayout(new GridLayout(3, 1, 10, 10));
        deleteCarFrame.setPreferredSize(new Dimension(400, 200));

        deleteCarFrame.add(new JLabel("Car Model:"));
        JTextField modelTextField = new JTextField();
        deleteCarFrame.add(modelTextField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(173, 216, 230));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 16));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String model = modelTextField.getText();
                showroom.deleteCar(model);

                outputTextArea.append("Car deleted successfully!\n");
                deleteCarFrame.dispose();
            }
        });
        deleteCarFrame.add(deleteButton);

        deleteCarFrame.pack();
        deleteCarFrame.setLocationRelativeTo(null);
        deleteCarFrame.setVisible(true);
    }

    private void showUpdateCarScreen() {
        JFrame updateCarFrame = new JFrame("Update Car");
        updateCarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateCarFrame.setLayout(new GridLayout(9, 2, 10, 10));
        updateCarFrame.setPreferredSize(new Dimension(400, 350));

        updateCarFrame.add(new JLabel("Car Model:"));
        JTextField modelTextField = new JTextField();
        updateCarFrame.add(modelTextField);

        updateCarFrame.add(new JLabel("New Color:"));
        JTextField colorTextField = new JTextField();
        updateCarFrame.add(colorTextField);

        updateCarFrame.add(new JLabel("New Engine Type:"));
        JTextField engineTextField = new JTextField();
        updateCarFrame.add(engineTextField);

        updateCarFrame.add(new JLabel("New Number of Seats:"));
        JTextField seatsTextField = new JTextField();
        updateCarFrame.add(seatsTextField);

        updateCarFrame.add(new JLabel("New Air Conditioning:"));
        JTextField acTextField = new JTextField();
        updateCarFrame.add(acTextField);

        updateCarFrame.add(new JLabel("New Price:"));
        JTextField priceTextField = new JTextField();
        updateCarFrame.add(priceTextField);

        updateCarFrame.add(new JLabel("New Company Name:"));
        JTextField companyTextField = new JTextField();
        updateCarFrame.add(companyTextField);

        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(173, 216, 230));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Arial", Font.BOLD, 16));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String model = modelTextField.getText();
                String color = colorTextField.getText();
                String engineType = engineTextField.getText();
                int numberOfSeats = Integer.parseInt(seatsTextField.getText());
                String airConditioning = acTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                String companyName = companyTextField.getText();

                showroom.updateCar(model, color, engineType, numberOfSeats, airConditioning, price, companyName);

                outputTextArea.append("Car updated successfully!\n");
                updateCarFrame.dispose();
            }
        });
        updateCarFrame.add(updateButton);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(173, 216, 230));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCarFrame.dispose();
            }
        });
        updateCarFrame.add(backButton);

        updateCarFrame.pack();
        updateCarFrame.setLocationRelativeTo(null);
        updateCarFrame.setVisible(true);
    }

    private void showSearchByModelScreen() {
        JFrame searchByModelFrame = new JFrame("Search by Model");
        searchByModelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchByModelFrame.setLayout(new GridLayout(3, 1, 10, 10));
        searchByModelFrame.setPreferredSize(new Dimension(400, 200));

        searchByModelFrame.add(new JLabel("Car Model:"));
        JTextField modelTextField = new JTextField();
        searchByModelFrame.add(modelTextField);

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(173, 216, 230));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String model = modelTextField.getText();
                Car car = showroom.searchCarByModel(model);

                if (car != null) {
                    outputTextArea.append(car.toString() + "\n");
                } else {
                    outputTextArea.append("Car not found.\n");
                }
                searchByModelFrame.dispose();
            }
        });
        searchByModelFrame.add(searchButton);

        searchByModelFrame.pack();
        searchByModelFrame.setLocationRelativeTo(null);
        searchByModelFrame.setVisible(true);
    }

    private void showSearchByCompanyNameScreen() {
        JFrame searchByCompanyNameFrame = new JFrame("Search by Company Name");
        searchByCompanyNameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchByCompanyNameFrame.setLayout(new GridLayout(3, 1, 10, 10));
        searchByCompanyNameFrame.setPreferredSize(new Dimension(400, 200));

        searchByCompanyNameFrame.add(new JLabel("Company Name:"));
        JTextField companyNameTextField = new JTextField();
        searchByCompanyNameFrame.add(companyNameTextField);

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(173, 216, 230));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String companyName = companyNameTextField.getText();
                Car car = showroom.searchCarByCompanyName(companyName);

                if (car != null) {
                    outputTextArea.append(car.toString() + "\n");
                } else {
                    outputTextArea.append("Car not found.\n");
                }
                searchByCompanyNameFrame.dispose();
            }
        });
        searchByCompanyNameFrame.add(searchButton);

        searchByCompanyNameFrame.pack();
        searchByCompanyNameFrame.setLocationRelativeTo(null);
        searchByCompanyNameFrame.setVisible(true);
    }

    private void showViewCarsScreen() {
        Car[] cars = showroom.getAllCars();

        JFrame viewCarsFrame = new JFrame("View Cars");
        viewCarsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewCarsFrame.setPreferredSize(new Dimension(800, 400));

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] columnNames = {"Model", "Color", "Engine Type", "Number of Seats", "Air Conditioning", "Price",
                "Company Name"};

        Object[][] data = new Object[cars.length][columnNames.length];
        for (int i = 0; i < cars.length; i++) {
            data[i][0] = cars[i].getModel();
            data[i][1] = cars[i].getColor();
            data[i][2] = cars[i].getEngineType();
            data[i][3] = cars[i].getNumberOfSeats();
            data[i][4] = cars[i].getAirConditioning();
            data[i][5] = cars[i].getPrice();
            data[i][6] = cars[i].getCompanyName();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        viewCarsFrame.getContentPane().add(panel);
        viewCarsFrame.pack();
        viewCarsFrame.setLocationRelativeTo(null);
        viewCarsFrame.setVisible(true);
    }
    
}