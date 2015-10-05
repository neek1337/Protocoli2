import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;

public class LineChart1 extends Application {
    public ArrayList<Pair<Integer, Float>> arrayList;

    public LineChart1() {
        arrayList = new ArrayList<Pair<Integer, Float>>();
    }

    public LineChart1(ArrayList<Pair<Integer, Float>> arrayList) {
        this.arrayList = arrayList;
    }

    public void setArrayList(ArrayList<Pair<Integer, Float>> arrayList) {
        this.arrayList = arrayList;
    }

    public void addArrayList(Pair<Integer, Float> a) {
        arrayList.add(a);
    }

    @Override
    public void start(Stage stage) {

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        //creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);


        XYChart.Series series = new XYChart.Series();


        ObservableList datas = FXCollections.observableArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            datas.add(arrayList.get(i).getKey(),
                    arrayList.get(i).getValue());
        }
        series.setData(datas);
        series.setName("b(m)");
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}