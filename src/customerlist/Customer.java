/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerlist;

/**
 *
 * @author charp
 */
public class Customer {
    String name, address, city, province, postalCode;
    
    Customer(String name, String address, String city, String province, String postalCode)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }
    
    public boolean testValidPostalCode()
    {
        String tempPostalCode = postalCode.replace(" ", "");
        for (int i = 0; i < 6; i += 2)
        {
            try
            {
                //If It can be converted to int, next line executes and returns false
                Integer.parseInt( tempPostalCode.substring(i, i + 1));
                return false;
            }
            catch(NumberFormatException NFE){}
            
            try
            {
                //If not an int throws error and returns false
                Integer.parseInt( tempPostalCode.substring(i + 1, i + 2));
            }
            catch(NumberFormatException NFE)
            {
                return false;
            }
        }
        return true;
    }
    
    public String toString()
    {
        return name + "\n" + address + "\n" + city + "\n" + province + "\n" + postalCode;
    }
}
