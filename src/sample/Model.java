package sample;

public class Model
{
    public double calculateMagnitude(double v1x, double v1y) {
        System.out.println("calculating magnitude of v1");

        double vector[] = {v1x, v1y};
        double magnitude = 0;

        for(int i = 0; i < vector.length; i++) {
            magnitude = magnitude + Math.pow(vector[i], 2);
        }
        //http://cljavacode.blogspot.com/2017/02/vector-magnitude.html
        return Math.sqrt(magnitude);
    }

    public double[] calculateSumOfTwoVectors(double v1x, double v1y, double v2x, double v2y)
    {
        double v1 = v1x + v2x;
        double v2 = v1y + v2y;
        return new double[]{v1, v2};
    }

    public double calculateDotProductBetweenTwoVectors(double vect_A[], double vect_B[]) {
        double product = 0;
        int n = 2;

        // Loop for calculate cot product
        for (double i = 0; i < n; i++)
            product = product + vect_A[(int) i] * vect_B[(int) i];
        //https://www.geeksforgeeks.org/program-dot-product-cross-product-two-vector/
        return product;
    }

    public double calculateAngleBetweenTwoVectors(double v1x, double v1y, double v2x, double v2y) {
        //https://onlinemschool.com/math/library/vector/angl/

        //calculate dot product of two vectors
        double vec1[] = {v1x, v1y};
        double vec2[] = {v2x, v2y};
        double dotProduct = calculateDotProductBetweenTwoVectors(vec1, vec2);

        //calculate vectors magnitude
        double mv1 = calculateMagnitude(v1x, v1y);
        double mv2 = calculateMagnitude(v2x, v2y);

        //calculate angle between vectores
        double cosA = dotProduct / (mv1 * mv2);
        double resultAngle = Math.toDegrees(Math.acos(cosA));
        return resultAngle;
    }




    //simple trigonemtry
    //angles
    public double calculateSineAngle(double opposite, double hypothenuse) {
        double result = Math.toDegrees(Math.asin(opposite / hypothenuse));
        return result;
    }

    public double calculateCosAngle(double adjacent, double hypothenuse) {
        double result = Math.toDegrees(Math.acos(adjacent / hypothenuse));
        return result;
    }

    public double calculateTanAngle(double opposite, double adjacent) {
        double result = Math.toDegrees(Math.atan(opposite / adjacent));
        return result;
    }

    //sides
    public double calculateOpposite(double hypothenuse, double angle) {
        return Math.sin(Math.toRadians(angle)) * hypothenuse;
    }

    public double calculateHypothenuse(double opposite, double angle) {
        return opposite / (Math.sin(Math.toRadians(angle)));
    }

    public double calculateAdjacent(double hypothenuse, double angle) {
        return hypothenuse * (Math.cos(Math.toRadians(angle)));
    }

    public double calculateHypothenuse2(double adjacent, double angle) {
        return adjacent / (Math.cos(Math.toRadians(angle)));
    }

    public double calculateOpposite2(double adjacent, double angle) {
        return adjacent * (Math.tan(Math.toRadians(angle)));
    }

    public double calculateAdjacent2(double opposite, double angle) {
        return opposite / (Math.tan(Math.toRadians(angle)));
    }

    public double calculateAdjacent3(double hypotenuse, double opposite) {
        //phytagoras calc side b
        double result = (hypotenuse * hypotenuse)-( opposite * opposite);
        double result1 = Math.sqrt(result);
        return result1;
    }

    public double calculateAdjacent4(double hypotenuse, double adjacent) {
        //phytagoras calc side a
        double result = (hypotenuse*hypotenuse)-(adjacent*adjacent);
        double result1 = Math.sqrt(result);
        return result1;
    }


    public double calculateAdjacent5(double opposite, double adjacent) {
        //phtagoras calc side c
        double result = (opposite * opposite) + (adjacent * adjacent);
        double result1 = Math.sqrt(result);
        return result1;
    }
}
