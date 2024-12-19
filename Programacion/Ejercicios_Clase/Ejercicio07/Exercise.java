package EJERCICIO07RESUELTO;

public class Exercise {
    private String statement;

    public Exercise(String statement, Level level) {
        this.statement = statement;
        this.level = level;
    }

    @Override
    public String toString(){
        String result = "El enunciado es " + statement + " y su dificultad es " + level.getType;
        return result;

    }
}
