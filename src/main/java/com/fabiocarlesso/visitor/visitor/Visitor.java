package com.fabiocarlesso.visitor.visitor;

import com.fabiocarlesso.visitor.shapes.Circle;
import com.fabiocarlesso.visitor.shapes.CompoundShape;
import com.fabiocarlesso.visitor.shapes.Dot;
import com.fabiocarlesso.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
