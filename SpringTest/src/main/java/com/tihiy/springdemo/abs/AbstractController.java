/*
 * AbstractController.java
 *
 * Created on January 22, 2007, 8:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.tihiy.springdemo.abs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides base level functionality for each controller. This includes the
 * ability to register multiple models and views, propogating model change events to
 * each of the views, and providing a utility function to broadcast model property
 * changes when necessary.
 * @author Robert Eckstein
 */
public abstract class AbstractController implements PropertyChangeListener {
    //  Vectors that hold a list of the registered models and views for this controller.
    private ArrayList<AbstractViewPanel> registeredViews;
    protected Map<String, AbstractModel> registeredModels = new HashMap<>();
//    private final Map<String, AbstractModel> registeredModels;

    /** Creates a new instance of Controller */
    public AbstractController() {
        registeredViews = new ArrayList<AbstractViewPanel>();
        registeredModels =  new HashMap<>();
    }

    /**
     * Binds a model to this controller. Once added, the controller will listen for all
     * model property changes and propogate them on to registered views. In addition,
     * it is also responsible for resetting the model properties when a view changes
     * state.
     * @param model The model to be added
     */
    public void addModel(String modelName, AbstractModel model){
        registeredModels.put(modelName, model);
        model.addPropertyChangeListener(this);
    }

    /**
     * Unbinds a model from this controller.
     * @param model The model to be removed
     */
    public void removeModel(AbstractModel model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }

    /**
     * Binds a view to this controller. The controller will propogate all model property
     * changes to each view for consideration.
     * @param view The view to be added
     */
    public void addView(AbstractViewPanel view) {
        registeredViews.add(view);
    }

    /**
     * Unbinds a view from this controller.
     * @param view The view to be removed
     */
    public void removeView(AbstractViewPanel view) {
        registeredViews.remove(view);
    }

    // TI return list of models
//    protected  ArrayList<AbstractModel> getModelsList(){
//        return registeredModels;
//    }
    public AbstractModel getModel(String modelName){
        return registeredModels.get(modelName);
    }

    /**
     * This method is used to implement the PropertyChangeListener interface. Any model
     * changes will be sent to this controller through the use of this method.
     * @param evt An object that describes the model's property change.
     */
    public void propertyChange(PropertyChangeEvent evt) {

        for (AbstractViewPanel view: registeredViews) {
            view.modelPropertyChange(evt);
        }
    }
}
