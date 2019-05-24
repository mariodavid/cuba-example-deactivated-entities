package com.rtcab.cede.web;

import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.HasButtonsPanel;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.rtcab.cede.entity.WithInactivityOption;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface WithInactivityOptionSupport {


    /**
     * defines the edited entity of the StandardEditor that implements the WithInactivityOption interface
     * @return the edited entity
     */
    WithInactivityOption getEditedEntityWithInactivityOption();



    @Subscribe
    default void disableComponentsIfInactive(Screen.AfterShowEvent event) {

        if (!getEditedEntityWithInactivityOption().getActive()) {
            Collection<Component> components = event.getSource().getWindow().getComponents();
            Set<Component> editableComponents = components
                    .stream()
                    .filter(component -> component instanceof Component.Editable)
                    .collect(Collectors.toSet());

            editableComponents
                    .stream()
                    .map(component -> (Component.Editable) component)
                    .forEach(editable -> editable.setEditable(false));
            List<Table> tables = components.stream()
                    .filter(component -> component instanceof Table)
                    .map(component -> (Table) component)
                    .collect(Collectors.toList());


            tables.stream()
                    .map(HasButtonsPanel::getButtonsPanel)
                    .forEach(buttonsPanel -> buttonsPanel.setEnabled(false));
        }

    }

}
