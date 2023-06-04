package com.fabiocarlesso.visitor.shapes;

import com.fabiocarlesso.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
