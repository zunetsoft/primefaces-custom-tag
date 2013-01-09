package pack.controllers;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class CategoryController implements Serializable {
    
    public CategoryController() {
        
    }
    
    @PostConstruct
    public void init() {
        System.out.println("$$$ init");
    }
    
    public void test(ActionEvent event) {
        System.out.println("$$$ test");
    }
    
    public String login() {
        System.out.println("-- login");
        return "";
    }
       
    public String login(ActionEvent event) {
        System.out.println("-- login event");
        return "";
    }
    
}
