/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BridgeLogicController.BridgeLocal;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import cricketdto.RankDTO;
import cricketdto.UserDTO;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import utils.Utils;

/**
 *
 * @author bruno
 */
@Named("rankBean")
@SessionScoped
public class RankBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    
    private String nome;
    private String descript;
    private String minPoints;
    private String birthTmp;
    private int gender;
    UserDTO user;

    @EJB
    private BridgeLocal bridge;
    
    private RankDTO rankDTOTemp;

    @Inject
    GoalBean gg;
    
    @Inject
    SessionBean s;

    public RankBean() {
        // do nothing
    }

    public String processFindRank(){
        String str="";
        
        try{
            str= bridge.getCricket().findRankUser(this.s.getEmail());
            return str;
        
        }catch(Exception ex){
            Utils.throwMessage("Error");
            return "error";
        }
        
    }
}