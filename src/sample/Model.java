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
        //calculate dot product of two vectors
        double vec1[] = {v1x, v1y};
        double vec2[] = {v2x, v2y};
        double dotProduct = calculateDotProductBetweenTwoVectors(vec1, vec2);

        //calculate vectors magnitude
        double mv1 = calculateMagnitude(v1x, v1y);
        double mv2 = calculateMagnitude(v2x, v2y);

        //calculate angle between vectores
        double cosA = dotProduct / (mv1 * mv2);
        return cosA;
    }
}
