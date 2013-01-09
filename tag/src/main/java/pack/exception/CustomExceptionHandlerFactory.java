/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author akasprzak
 */
public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
   private ExceptionHandlerFactory parent;

   // this injection handles jsf
   public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
    this.parent = parent;
   }

    @Override
    public ExceptionHandler getExceptionHandler() {

        ExceptionHandler handler = new CustomExceptionHandler(parent.getExceptionHandler());

        return handler;
    }

}