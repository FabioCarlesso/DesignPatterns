package com.fabiocarlesso.visitor.shapes;

import com.fabiocarlesso.visitor.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Circle extends Dot {
    private final int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }
}
