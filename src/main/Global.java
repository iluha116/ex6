package main;

import main.Lines.Line;

import java.util.ArrayList;

public class Global extends Scope {

    public Global (ArrayList<Line> lines){
        this.lines = lines;
    }
}
