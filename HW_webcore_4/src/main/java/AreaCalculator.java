public class AreaCalculator {

private void sideTest(int a, int b , int c) throws Exception {
    if (a<=0 || b<=0 || c<=0) throw new Exception("Стороны треугольника не могут быть равны или меньше 0") {};
    }


    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double areaCalc (int a, int b, int c) throws Exception {
        this.sideTest(a,b,c);
        double halfPerimeter = (double)(a+b+c)/2;
        return  Math.sqrt(halfPerimeter*(halfPerimeter-a)*(halfPerimeter-b)*(halfPerimeter-c));
    }




}
