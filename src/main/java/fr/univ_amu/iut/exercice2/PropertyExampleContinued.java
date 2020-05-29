package fr.univ_amu.iut.exercice2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PropertyExampleContinued {

    private IntegerProperty anIntProperty;

    public static void main(String[] args) {
        PropertyExampleContinued propertyExample = new PropertyExampleContinued();
        propertyExample.setAnInt(1024);
        propertyExample.bindAndUnbindOnePropertyToAnother();
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

    void bindAndUnbindOnePropertyToAnother() {
        System.out.println();
        IntegerProperty otherProperty = new SimpleIntegerProperty(0);
        System.out.println(otherProperty);
        otherProperty.bind(anIntProperty);
        System.out.println(otherProperty);
        anIntProperty.setValue(7168);
        System.out.println(otherProperty);
        otherProperty.unbind();
        System.out.println(otherProperty);
        anIntProperty.setValue(8192);
        System.out.println(otherProperty);
    }
}
