package main.Variables;

/**
 * Variables Factory class
 * @author Shani Cheskis
 * @author Ilia Bogov
 */


public class VariablesFactory {

    public Variable factory (String type, String name, String value, boolean IfFinal)
            throws WrongCastingException{
        Variable val;
        switch (type){
            case ("String"):
                val = new StringVariable (name,value);
                break;
            case ("int"):
                val = new IntVariable (name,value);
                break;
            case ("double"):
                val = new DoubleVariable (name,value);
                break;
            case ("boolean"):
                val = new BooleanVariable (name,value);
                break;
            case ("char"):
                val = new CharVariable (name,value);
                break;
            default:
                throw new WrongCastingException();
        }
        if (IfFinal){
            val = new FinalVariable(val);
        }
        return val;
    }

}
