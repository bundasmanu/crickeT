/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.time.LocalDate;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Local;

/**
 *
 * @author gustavo
 */
@Local
public interface userManagementLocal {
    
    boolean signUp(String username, String pass, String email, String gender, Date birth);
    boolean validateLogin(String email, String pass);
    
}
