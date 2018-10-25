/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author charp
 */
public class CustomerList {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int newCustomerIndex;
        ArrayList<Customer> customers = new ArrayList();
        ArrayList<String> customerFile = new ArrayList();
        customerFile = (ArrayList<String>) Files.readAllLines(Paths.get("customerList.txt"));
        
        for(int i = 0; i < customerFile.size() / 5; i++)
        {
            customers.add(new Customer(customerFile.get(i), customerFile.get(i + 1), customerFile.get(i + 2), customerFile.get(i + 3), customerFile.get(i + 4)));
            System.out.println(customers.get(i).toString() + "\n"
                    + "----------------------------------");
        }
        newCustomerIndex = customers.size();
        
        customers.add(new Customer(
        JOptionPane.showInputDialog("Enter customer name: "), 
        JOptionPane.showInputDialog("Enter customer address: "), 
        JOptionPane.showInputDialog("Enter customer city: "), 
        JOptionPane.showInputDialog("Enter customer province: "), 
        JOptionPane.showInputDialog("Enter customer postal code (L#L #L#): ")));
        
        while (!customers.get(newCustomerIndex).testValidPostalCode())
            customers.get(newCustomerIndex).postalCode = JOptionPane.showInputDialog("Enter postal code in correct format (L#L #L#): ");
        
        BufferedWriter saveToList = new BufferedWriter( 
               new FileWriter("customerList.txt", true));
        saveToList.write("\n" + customers.get(newCustomerIndex).toString());
        saveToList.close();

        System.out.println(customers.get(newCustomerIndex).toString() + "\n"
                + "----------------------------------");
    }
    
}
