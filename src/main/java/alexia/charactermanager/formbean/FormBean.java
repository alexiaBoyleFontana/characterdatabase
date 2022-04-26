package alexia.charactermanager.formbean;

public interface FormBean {

    default public String sanitize(String value) {

        value = value.replace("<","");
        value = value.replace(">","");
        value = value.replace("\"", "\'");
        value = value.replace("&", "");

        return value;
    }

    void clean();
}
