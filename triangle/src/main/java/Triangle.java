class Triangle {

    private double side1;
    private double side2;
    private double side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side1 + side2 < side3 || side2 + side3 < side1 || side1 + side3 <= side2) {
            throw new TriangleException();
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    TriangleKind getKind() {
        if (this.side3 == this.side2 && this.side3 == this.side1){
            return TriangleKind.EQUILATERAL;
        } else if (this.side1 == this.side2 || this.side2 == this.side3 || this.side1 == this.side3) {
            return TriangleKind.ISOSCELES;
        }
        else return TriangleKind.SCALENE;
    }

}
