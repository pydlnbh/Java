package com.design.pattern.db.interpreter;

import java.util.HashMap;

public abstract class Expression {
    abstract int interpreter(HashMap<String, Integer> var);
}
