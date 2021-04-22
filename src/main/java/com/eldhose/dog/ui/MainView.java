package com.eldhose.dog.ui;

import com.eldhose.dog.Entity.DogModel;
import com.eldhose.dog.Service.DogServiceImpl;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("./shared-styles.css")
public class MainView extends VerticalLayout {

    private Grid<DogModel> grid = new Grid<>(DogModel.class);
    private DogServiceImpl dogService;
    private DogForm form;


    public MainView(DogServiceImpl dogService)
    {
        this.dogService=dogService;
        addClassName("list-view");
        setSizeFull();
        configGrid();

        form = new DogForm();
        form.addListener(DogForm.SaveEvent.class,this::saveContact);

        Div content = new Div(grid,form);
        content.addClassName("content");
        content.setSizeFull();

        add(content);
        updateList();

    }

    private  void saveContact(DogForm.SaveEvent event) {
        DogModel dogModel = new DogModel();
        dogModel.setName(event.getDogModel().getName());
        dogModel.setBreed(event.getDogModel().getBreed());
        dogService.putDog(dogModel);
        updateList();
        //closeForm();
    }

    private void configGrid()
    {
        grid.addClassName("dog-grid");
        grid.setSizeFull();
        grid.setColumns("id","name","breed");
        grid.getColumns().forEach(col ->col.setAutoWidth(true));
    }

    private void updateList()
    {
        grid.setItems(dogService.retrieveDogs());
    }

    private void closeForm()
    {
            form.setDog(null);
    }



}
