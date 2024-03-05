/**
 * PerimeterAssignmentRunner
 * Assignment for Java Week 1
 * 
 * @author Annie Grubb 
 * @version 0.1 2/29/24
 */
import edu.duke.*;
import java.io.File;
import java.time.LocalTime;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        double currDist = 0;
        
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
            //temporary code to print out points
        //    System.out.println(currPt);
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Start with numPoints = 0
        int numPoints = 0;
        
        //   numPoints = s.modCount;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Increment numPoints for each iteration 
            numPoints ++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Start with aveLength = 0
        double aveLength = 0;
        
        aveLength = getPerimeter(s) / getNumPoints(s);
        return aveLength;

    }

    public double getLargestSide(Shape s) {
        // initalize maxLength variable to zero
        double maxLength = 0;
    
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
    
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            
            System.out.println("Current side  = " + currDist);
            
            if (currDist>maxLength){
                maxLength = currDist;    
            }
            // Update prevPt to be currPt
            prevPt = currPt;
            
            //temporary code to print out points
            System.out.println(currPt);

        }   
        return maxLength;
    }

    public double getLargestX(Shape s) {
        // initalize maxX variable to zero
        double currX;
        double prevX;
        double maxX = 0;
    
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        
        // Initialize maxX to current X
        maxX = prevPt.getX();
          
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find X value of prevPt point to currPt 
            currX = currPt.getX();
            prevX = prevPt.getX();
            
            System.out.println("Current X  = " + currX);
            
            maxX = Math.max(currX,maxX);
            if (currX > maxX){
                maxX = currX;    
            }
            // Update prevPt to be currPt
            prevPt = currPt;
            
            //temporary code to print out points
            System.out.println(currPt);

        }   
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        
        DirectoryResource dr = new DirectoryResource();
        double currPerimiter = 0;
        double maxPerimeter = 0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
    
            currPerimiter = getPerimeter(s);
            if (currPerimiter > maxPerimeter){
                maxPerimeter = currPerimiter;
            }
            System.out.println(f);
            System.out.println("    has a perimeter of " + currPerimiter);
            System.out.println("So far maximum perimeter is " + maxPerimeter);

        }    
        return maxPerimeter;    
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double currPerimiter = 0;
        double maxPerimeter = 0;
        String maxPeriFileName = "TESTING";
        File temp = null;    // replace this code
         
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currPerimiter = getPerimeter(s);
            if (currPerimiter > maxPerimeter){
                maxPerimeter = currPerimiter;
                maxPeriFileName = f.getName();
   
            }
            System.out.println(f);
            System.out.println("    has a perimeter of " + currPerimiter);
            System.out.println("So far maximum perimeter is " + maxPerimeter);

        }          
        return maxPeriFileName;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        LocalTime time = LocalTime.now();
        
        // print out blank line and header for each iteration of this test
        System.out.println("  ");
        System.out.println("****** " + time);

        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double longest = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.println("Perimeter = " + length);
        System.out.println("Number of points = " + numPoints);
        System.out.println("Average side length = " + averageLength);
        System.out.println("Length of longest side = " + longest);
        System.out.println("Largest X value = " + largestX);
    }
    

    // testPerimeterMultipleFiles scans a list of files input by user prompt
    // and finds the greatest perimeter value
    public void testPerimeterMultipleFiles() {
        new DirectoryResource();
        LocalTime time = LocalTime.now();
        //double maxPerimeter = 0;
        System.out.println("  ");
        System.out.println("testPerimeterMultipleFiles****** " + time);
        
        double maxPerimeter = getLargestPerimeterMultipleFiles();
        // print out blank line and header for each iteration of this test
        System.out.println("    Maximun Perimeter = " + maxPerimeter);
     }

     // testFileWithLargestPerimeter scans a list of files input by user 
     // and returns the file name of the file with greatest perimeter
     public void testFileWithLargestPerimeter() {
        // Put code here
        new DirectoryResource();
        LocalTime time = LocalTime.now();
        //double maxPerimeter = 0;
 
        // print out blank line and header for each iteration of this test
        System.out.println("  ");
        System.out.println("testFileWithLargestPerimeter****** " + time);
        String maxPerimeterFileName = getFileWithLargestPerimeter();
        System.out.println("    *** File Name of Maximum Perimeter = " + maxPerimeterFileName);
     }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+ peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println("File: " + f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
    //    DirectoryResource dr = new DirectoryResource();
        pr.testPerimeter();
    //    pr.printFileNames();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    //    pr.getLargestPerimeterMultipleFiles();
    //    pr.testFileWithLargestPerimeter();
    }
}
