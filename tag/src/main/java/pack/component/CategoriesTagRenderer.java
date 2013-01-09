package pack.component;

import java.io.IOException;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.panel.Panel;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.Constants;
import pack.utils.FacesUtil;

public class CategoriesTagRenderer extends CoreRenderer {
    
    @Override
    public void encodeEnd(FacesContext ctx, UIComponent component) throws IOException {  
        component.setId("catsComp");
        System.out.println("&&& encode");
        
        HtmlForm form = construct(component);   
                
        form.encodeAll(ctx); 
    }
    
    private HtmlForm construct(UIComponent component) {
        HtmlForm form = new HtmlForm();
        form.setId("form" + 1);
        CommandButton outText = new CommandButton();
        outText.setValue("kat"); 
        outText.setId("button" + 1);

        outText.addActionListener(new ActionListener() {
            @Override
            public void processAction(ActionEvent event) throws AbortProcessingException {
                System.out.println("++++++ ACTION");
            }
        });
        
        form.getChildren().add(outText);
        component.getChildren().add(form);
        return form;
    }
    
    @Override
    public void decode(FacesContext ctx, UIComponent component) {
        HtmlForm form = construct(component);
        System.out.println("@@@ postback: " + ctx.isPostback());
        
        
        Map requestParameterMap =
            ctx.getExternalContext().getRequestParameterMap();
        String requestId = (String)(requestParameterMap.get(
                Constants.PARTIAL_SOURCE_PARAM)); 
        UIComponent root = form;
        if(root != null) {
            UIComponent componentFound = FacesUtil.findComponent(root, "button1");
            if(componentFound != null) {
                System.out.println("%%% buttonId: " + componentFound.getId());
                System.out.println("%%% buttonClientId: " + componentFound.getClientId());
                System.out.println("%%% request: " + requestId);
                if(requestId.equals(componentFound.getClientId())) {
                    if(componentFound != null) {
                        System.out.println("%%% Found button: " + componentFound.getId());
                        //componentFound.decode(ctx);
                        ((CommandButton)componentFound).decode(ctx);
                    }
                }
            } else {
                System.out.println("%%% panel is null");
            }
        } else {
            System.out.println("%%% root is null");
        }        
    }
    public static class PanelWithDepth {
        
        public Panel panel;
        public int depth;   

        public PanelWithDepth(Panel panel, int depth) {
            this.panel = panel;
            this.depth = depth;
        }
        
    }
        
}
