package main;

import main.Lines.Line;

import java.util.ArrayList;

public class Global extends Scope {

    public Global (ArrayList<Line> lines){
        this.lines = lines;
        this.globalVariables = new ArrayList<>();
        this.localVariables = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    public boolean isScopeCorrect (){



        return false;
    }

    @Override
    public boolean IsScopeCorrect() {
        return false;
    }
}
