public class ColorUtils {
    public static String printColorFromName(String colorName) {
        String result;
        switch(colorName) {
            case "rojo":
                result = "#FF0000";
                break;
            case "verde":
                result = "#00FF00";
                break;
            case "negro":
                result = "#000000";
                break;
            case "blanco":
                result = "#FFFFFF";
                break;
            default:
                result = null;
        }
        return result;
    }
}
