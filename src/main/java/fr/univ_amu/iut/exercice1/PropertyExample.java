package fr.univ_amu.iut.exercice1;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;

public class PropertyExample {
    private ChangeListener changeListener = (observableValue, o, t1)
            -> System.out.println("The observableValue has changed: oldValue = "  + o + ", newValue = " + t1);
    private InvalidationListener invalidationListener = (observable) -> System.out.println("The observable has been invalidated.");

    private IntegerProperty anIntProperty;

    public static void main(String[] args) {
        PropertyExample propertyExample = new PropertyExample();
        propertyExample.createProperty();
        propertyExample.addAndRemoveInvalidationListener();
        propertyExample.addAndRemoveChangeListener();
    }

    void createProperty() {
        SimpleIntegerProperty anIntProperty = new SimpleIntegerProperty();
        anIntProperty.set(1024);
        System.out.println();
        System.out.println("anIntProperty = " + anIntProperty);
        System.out.println("anIntProperty.get() = " + anIntProperty.get());
        System.out.println("anIntProperty.getValue() = " + anIntProperty.get());
    }

    void addAndRemoveInvalidationListener() {
        throw new RuntimeException("Not yet implemented !");
    }

    void addAndRemoveChangeListener() {
        throw new RuntimeException("Not yet implemented !");
    }


    public int getAnInt() {
        return anIntProperty.get();
    }

    public void setAnInt(int anInt) {
        if (anIntProperty == null)
            anIntProperty = new SimpleIntegerProperty();
        this.anIntProperty.set(anInt);
    }

    public IntegerProperty anIntProperty() {
        return anIntProperty;
    }

}