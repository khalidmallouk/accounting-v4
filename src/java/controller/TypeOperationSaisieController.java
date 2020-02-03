package controller;

import bean.TypeOperationSaisie;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import service.TypeOperationSaisieFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("typeOperationSaisieController")
@SessionScoped
public class TypeOperationSaisieController implements Serializable {

    @EJB
    private service.TypeOperationSaisieFacade ejbFacade;
    private List<TypeOperationSaisie> items = null;
    private TypeOperationSaisie selected;

    public TypeOperationSaisieController() {
    }

    public TypeOperationSaisie getSelected() {
        return selected;
    }

    public void setSelected(TypeOperationSaisie selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TypeOperationSaisieFacade getFacade() {
        return ejbFacade;
    }

    public TypeOperationSaisie prepareCreate() {
        selected = new TypeOperationSaisie();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TypeOperationSaisieCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TypeOperationSaisieUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TypeOperationSaisieDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TypeOperationSaisie> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TypeOperationSaisie getTypeOperationSaisie(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<TypeOperationSaisie> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TypeOperationSaisie> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TypeOperationSaisie.class)
    public static class TypeOperationSaisieControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TypeOperationSaisieController controller = (TypeOperationSaisieController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "typeOperationSaisieController");
            return controller.getTypeOperationSaisie(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TypeOperationSaisie) {
                TypeOperationSaisie o = (TypeOperationSaisie) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TypeOperationSaisie.class.getName()});
                return null;
            }
        }

    }

}
