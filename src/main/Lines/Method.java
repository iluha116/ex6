package main.Lines;


public class Method {

    private String name;
    private String [] parametersNames;
    private String [] parametersTypes;
    private boolean [] ifFinal;



    public Method (String name, String [] parametersNames, String [] parametersTypes, boolean [] ifFinal){
        this.name = name;
        this.parametersNames = parametersNames;
        this.parametersNames = parametersTypes;
        this.ifFinal = ifFinal;

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
