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
}
