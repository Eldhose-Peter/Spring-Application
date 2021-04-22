package com.eldhose.dog.ui;

import com.eldhose.dog.Entity.DogModel;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;


public class DogForm extends FormLayout {

    Binder<DogModel> binder = new BeanValidationBinder<>(DogModel.class);

    TextField name = new TextField("Dog Name");
    TextField breed = new TextField("Dog Breed");

    Button save= new Button("Save");
    Button cancel = new Button("Cancel");

    public  DogForm()
    {
        addClassName("dog-form");
        binder.bindInstanceFields(this);

        add(name,breed,createButtons());
    }

    private HorizontalLayout createButtons()
    {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event->validateSave());

        cancel.addClickListener(event->fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e->save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save,cancel);


    }


    public void setDog(DogModel dog)
    {
        binder.setBean(dog);
    }

    public static abstract class DogFormEvent extends ComponentEvent<DogForm> {
        private DogModel dogModel;

        public DogFormEvent(DogForm source, DogModel dogModel) {
            super(source, false);
            this.dogModel=dogModel;
        }

        public DogModel getDogModel()
        {
            return dogModel;
        }
    }

    public static class SaveEvent extends DogFormEvent {
        public SaveEvent(DogForm source, DogModel dogModel) {
            super(source, dogModel);
        }
    }

    public void validateSave(){

        binder.bindInstanceFields(this);
        if(binder.isValid())
        {

            DogModel dogModel = new DogModel();
            dogModel.setName(name.getValue());
            dogModel.setBreed(breed.getValue());
            //binder.setBean(dogModel);
            fireEvent(new SaveEvent(this,dogModel));

        }
    }

    public static class CloseEvent extends DogFormEvent {
        public CloseEvent(DogForm source) {
            super(source, null);
        }
    }

    public  <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener)
    {
        return getEventBus().addListener(eventType,listener);
    }


}

