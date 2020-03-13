import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Chart extends Application {

    public static void drawChart(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sort Algorithm Comparison");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("length of array");
        yAxis.setLabel("Time (in milliseconds)");

        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Sort Algorithm Comparison");

        // this function calculate time for sorting and add them to chart
        addingDataToChart(lineChart);

        Scene scene = new Scene(lineChart, 800, 600);

        stage.setScene(scene);
        stage.show();

    }

    private void addingDataToChart(LineChart<String, Number> lineChart) {

        // declare series
        XYChart.Series insertionSort = new XYChart.Series();
        insertionSort.setName("Insertion Sort");

        XYChart.Series quickSort = new XYChart.Series();
        quickSort.setName("Quick Sort");

        XYChart.Series mergeSort = new XYChart.Series();
        mergeSort.setName("Merge Sort");

        XYChart.Series heapSort = new XYChart.Series();
        heapSort.setName("Heap Sort");

        XYChart.Series radixSort = new XYChart.Series();
        radixSort.setName("Radix Sort");

        XYChart.Series bucketSort = new XYChart.Series();
        bucketSort.setName("Bucket Sort");

        XYChart.Series shellSort = new XYChart.Series();
        shellSort.setName("Shell Sort");


        int startRange = 100000;
        int endRange   = 10000000;
        int step       = 100000;

        for (int i = startRange; i <= endRange; i += step) {

            // Create an array with numbers 0 to n
            ArrayList<Integer> nums = new ArrayList<>(i);
            for (int j = 1; j <= i; j++)
                nums.add(j);
            // shuffle the nums array
            Collections.shuffle(nums);
            // copy nums ArrayList to normal array for using in sort algorithms
            int[] mainNums = new int[endRange];
            for (int j = 0; j < nums.size(); j++)
                mainNums[j] = nums.get(j);
            // make a copy of mainNums array to emulate same condition for every sort algorithm
            int[] sortArr;
            long first, second;
            System.out.format("Sorting: %d numbers\n", i);

            // sort algorithms

            // Merge Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            MergeSort.sort(sortArr, i);
            second = System.currentTimeMillis();
            mergeSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));

            // Quick Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            QuickSort.sort(sortArr, 0, i - 1);
            second = System.currentTimeMillis();
            quickSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));

            // Heap Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            HeapSort.sort(sortArr);
            second = System.currentTimeMillis();
            heapSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));

            // Radix Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            RadixSort.sort(sortArr);
            second = System.currentTimeMillis();
            radixSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));

            // Bucket Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            BucketSort.sort(sortArr);
            second = System.currentTimeMillis();
            bucketSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));

            // Shell Sort
            sortArr = mainNums.clone();
            first = System.currentTimeMillis();
            ShellSort.sort(sortArr);
            second = System.currentTimeMillis();
            shellSort.getData().add(new XYChart.Data(String.valueOf(i), second - first));

        }

        // adding series to line chart
        lineChart.getData().addAll(insertionSort, quickSort, mergeSort, radixSort, bucketSort, heapSort, shellSort);

    }
}
