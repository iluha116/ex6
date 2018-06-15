package main.Lines;


public class Method {

    private String name;
    private String [] parametersNames;
    private String [] parametersTypes;


    public Method (String name, String [] parametersNames, String [] parametersTypes){
        this.name = name;
        this.parametersNames = parametersNames;
        this.parametersNames = parametersTypes;
    }

    public String getName (){
        return name;
    }

    public String[] getParametersNames() {
        return parametersNames;
    }

    public String[] getParametersTypes() {
        return parametersTypes;
    }
}
