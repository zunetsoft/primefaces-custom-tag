package pack.utils;

import java.util.List;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.MethodExpressionActionListener;

public class FacesUtil {

    public static MethodExpression createMethodExpression(String valueExpression,
            Class<?> expectedReturnType) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExpressionFactory factory = fc.getApplication().getExpressionFactory();

        return factory.createMethodExpression(fc.getELContext(),
                valueExpression, expectedReturnType, new Class<?>[0]);
    }

    
    public static MethodExpressionActionListener createMethodActionListener(
            String valueExpression, Class<?> expectedReturnType) {
        System.out.println(" ++++ IN");
        return new MethodExpressionActionListener(
                createMethodExpression(valueExpression, expectedReturnType));
    }
    
    public static UIComponent findComponent(UIComponent c, String id) {
        if (id.equals(c.getId())) {
            return c;
        }
        List<UIComponent> kids = c.getChildren();
        for(UIComponent next: kids) {
            System.out.println("&&&& next: " + next.getId());
            UIComponent found = findComponent(next, id);            
            if (found != null) {
                return found;
            } 
        }
        return null;
    }
}
