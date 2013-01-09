package pack.component;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.*;
import org.primefaces.util.Constants;


public class CategoriesTag extends HtmlPanelGrid {        
    
    public static final String COMPONENT_TYPE = "pack.component.CategoriesTag";
    public static final String COMPONENT_FAMILY = "pack.component";
    
    public enum STATES {
        panel,
        test
    }
    
    public void CategoriesTag() {
        System.out.println("@@@ constructor");
        setRendererType("pack.component.CategoriesTagRenderer"); 
        setTest("1");
    }
    
    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }        
    
    public String getTest() {
        System.out.println("@@@ test: " + (String)getStateHelper().eval(STATES.test));
        return (String)getStateHelper().eval(STATES.test);
    }
    
    public void setTest(String test) {        
        System.out.println("@@@ set test: " + test);
        getStateHelper().put(STATES.test, test);
    } 
    
    public HtmlForm getPanel() {
        System.out.println("@@@ get");
        return (HtmlForm)getStateHelper().eval(STATES.panel);
    }

    public void setPanel(HtmlForm panel) {
        System.out.println("@@@ set");
        getStateHelper().put(STATES.panel, panel);
    }
    
    @Override
    public boolean getRendersChildren() {
        return true;
    }
    
    @Override
    public void queueEvent(FacesEvent event) {
        System.out.println("@@@ event");
    }
    
    @Override
    public void processDecodes(FacesContext context) {
        System.out.println("@@@4");
        this.decode(context);        
    } 
    
    private boolean isSelfRequest(FacesContext context) {
        System.out.println("@@@ Param2: " + 
                context.getExternalContext().getRequestParameterMap().get(Constants.PARTIAL_SOURCE_PARAM));
        System.out.println("@@@ Param3: " + 
                this.getClientId(context));
        return this.getClientId(context)
        .equals(context.getExternalContext().getRequestParameterMap().get(Constants.PARTIAL_SOURCE_PARAM));
    } 
}
