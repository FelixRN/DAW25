public class Person {
    private String name;
    private String lastName;
    private boolean hasGlasses;

    public Person(String name, String lastName, boolean hasGlasses) {
        this.name = name;
        this.lastName = lastName;
        this.hasGlasses = hasGlasses;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean getHasGlasses() {
        return this.hasGlasses;
    }

    @Override
    public String toString() {
        return "La persona \"" + this.getName()
                + " " + this.getLastName() + ": "
                + (this.getHasGlasses() ? "si tiene" : "no tiene");
    }
}