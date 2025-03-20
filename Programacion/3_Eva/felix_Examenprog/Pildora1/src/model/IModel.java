package model;

import java.util.List;

import entities.Component;

public interface IModel {
    List<Component> listComponents();
    Component addComponent(Component component);
    Component findComponentById(String id);
    void updateComponent(String id, Component component);
    void deleteComponent(String id);
    void clearComponents();
}
