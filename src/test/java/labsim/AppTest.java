package labsim;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import labsim.entidades.Avion;
import labsim.motor.FEL;
import labsim.politicas.MultiplesServidores;
import labsim.recursos.CustomRandomizer;
import labsim.recursos.Estadisticas;
import labsim.recursos.Randomizer;
import labsim.tablas.TablaArribo;
import labsim.tablas.TablaSalida;
import labsim.eventos.*;
import labsim.distribuciones.*;


    public class AppTest {

    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );
    }

    @Test
    public void testFel() {

        Randomizer randomizer = new CustomRandomizer();
        TablaArribo ta = new TablaArribo(randomizer);
        TablaSalida ts = new TablaSalida(randomizer);
        List<Evento> listaPrueba = new ArrayList<>();  //Creamos lista auxiliar de eventos

        //Esta insercion esta desordenada temporalmente, por ende haremos la insercion
        //en la fel, para corroborar que funciona el metodo de ordenamiento en la misma
        listaPrueba.add(new Arribo(1.0, new Avion(1), ta, ts, new Estadisticas(), new MultiplesServidores()));
        listaPrueba.add(new Salida(3.0, new Avion(1), ts, new Estadisticas()));
        listaPrueba.add(new Arribo(2.0, new Avion(2), ta, ts, new Estadisticas(), new MultiplesServidores()));
        listaPrueba.add(new Salida(5.0, new Avion(2), ts, new Estadisticas()));
        listaPrueba.add(new Arribo(4.0, new Avion(3), ta, ts, new Estadisticas(), new MultiplesServidores()));
        listaPrueba.add(new Salida(6.0, new Avion(3), ts, new Estadisticas()));
        listaPrueba.add(new Arribo(5.0, new Avion(4), ta, ts, new Estadisticas(), new MultiplesServidores()));

        //Insertamos en la fel para que los ordene
        FEL fel = new FEL();
        for (Evento evento : listaPrueba) {
            fel.insert(evento);
        }

        //Limpiamos la lista y la cargamos de nuevo como deberian estar los elementos
        listaPrueba.clear();
        listaPrueba.add(new Arribo(1.0, new Avion(1), ta, ts, new Estadisticas(), new MultiplesServidores()));
        listaPrueba.add(new Arribo(2.0, new Avion(2), ta, ts, new Estadisticas(), new MultiplesServidores()));
        listaPrueba.add(new Salida(3.0, new Avion(1), ts, new Estadisticas()));
        listaPrueba.add(new Arribo(4.0, new Avion(3), ta, ts, new Estadisticas(), new MultiplesServidores()));
        listaPrueba.add(new Salida(5.0, new Avion(2), ts, new Estadisticas()));
        listaPrueba.add(new Arribo(5.0, new Avion(4), ta, ts, new Estadisticas(), new MultiplesServidores()));
        listaPrueba.add(new Salida(6.0, new Avion(3), ts, new Estadisticas()));
        
        //Comprobación de igualdad de eventos
        for (int i = 0; i < listaPrueba.size(); i++) {
            Evento eventoListaPrueba = listaPrueba.get(i);
            Evento eventoFel = fel.getProximo();
            assertTrue(eventoListaPrueba.iguales(eventoFel));
        }
    }


    @Test
    public void testDistribucionExponencial(){

        Randomizer randomizer = new CustomRandomizer();
        TablaArribo ta = new TablaArribo(randomizer);
        double[] datos = new double[10000];
        int i = 0;

        for (i = 0; i < 10000; i++){
            double dato = ta.nextTime(500);  //exp con media = 15
            datos[i] = dato;
        }

        //Crear un conjunto de datos para el histograma
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Distribución Exponencial Media = 15", datos, 50);

        //Crear el gráfico de histograma
        JFreeChart chart = ChartFactory.createHistogram(
                "Histograma de Distribución Exponencial",
                "Valor",
                "Frecuencia",
                dataset
        );

        //Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        //Mostrar el gráfico en una ventana
        JFrame frame = new JFrame("Gráfico de Distribución Exponencial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);

        //Pausa la ejecución para ver el grafico
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
    @Test
    public void testDistribucionNormal(){

        DistribucionNormal normal = new DistribucionNormal(5, 1);
        double[] datos = new double[10000];
        int i;
        
        for (i = 0; i < 10000; i++){
            double dato = normal.getDistribucionNormal();
            datos[i] = dato;
        }

        //Crear un conjunto de datos para el histograma
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Distribución Normal", datos, 50);

        // Crear el gráfico de histograma
        JFreeChart chart = ChartFactory.createHistogram(
                "Histograma de Distribución Normal",
                "Valor",
                "Frecuencia",
                dataset
        );

        //Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        // Mostrar el gráfico en una ventana
        JFrame frame = new JFrame("Gráfico de Distribución Normal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);

        //Pausa la ejecución para ver el grafico
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testDistribucionUniforme(){

        Randomizer randomizer = new CustomRandomizer();
        TablaSalida ts = new TablaSalida(randomizer);

        double[] datos = new double[10000];
        int i = 0;

        for (i = 0; i < 10000; i++){
            double dato = ts.nextTime(500);  //exp con media = 15
            datos[i] = dato;
        }

        //Crear un conjunto de datos para el histograma
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Distribución Uniforme", datos, 50);

        //Crear el gráfico de histograma
        JFreeChart chart = ChartFactory.createHistogram(
                "Histograma de Distribución Uniforme",
                "Valor",
                "Frecuencia",
                dataset
        );

        //Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        //Mostrar el gráfico en una ventana
        JFrame frame = new JFrame("Gráfico de Distribución Uniforme");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);

        //Pausa la ejecución para ver el grafico
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testDistribucionPoisson(){

        DistribucionPoisson normal = new DistribucionPoisson(8);
        double[] datos = new double[10000];
        int i;
        
        for (i = 0; i < 10000; i++){
            double dato = normal.getDistribucionPoisson();
            datos[i] = dato;
        }

        //Crear un conjunto de datos para el histograma
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Distribución de Poisson", datos, 50);

        // Crear el gráfico de histograma
        JFreeChart chart = ChartFactory.createHistogram(
                "Histograma de Distribución de Poisson",
                "Valor",
                "Frecuencia",
                dataset
        );

        //Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        // Mostrar el gráfico en una ventana
        JFrame frame = new JFrame("Gráfico de Distribución de Poisson");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);

        //Pausa la ejecución para ver el grafico
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tetsDistribucionEmpiricaDiscreta() {
        List<Double> empirica = new ArrayList<>();
        DistribucionEmpiricaDiscreta distribucion = new DistribucionEmpiricaDiscreta();
        double[] datos = new double[10000];
        int i;

        // Definir la distribución empírica discreta
        empirica.add(0.15); //Probabilidad Acomulada
        empirica.add(2.0);  //Valor Deseado
        empirica.add(0.30);
        empirica.add(3.0);
        empirica.add(0.45);
        empirica.add(4.0);
        empirica.add(0.60);
        empirica.add(5.0);
        empirica.add(0.75);
        empirica.add(6.0);
        empirica.add(0.9);
        empirica.add(7.0);
        empirica.add(1.0);
        empirica.add(8.0);
        
        for (i = 0; i < 10000; i++){
            double dato = distribucion.getDistribucionEmpiricaDiscreta(empirica);
            datos[i] = dato;
        }

        //Crear un conjunto de datos para el histograma
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Distribución Empirica Discreta", datos, 50);

        // Crear el gráfico de histograma
        JFreeChart chart = ChartFactory.createHistogram(
                "Histograma de Distribución Empirica Discreta",
                "Valor",
                "Frecuencia",
                dataset
        );

        //Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        // Mostrar el gráfico en una ventana
        JFrame frame = new JFrame("Gráfico de Distribución Empirica Discreta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);

        //Pausa la ejecución para ver el grafico
        try {
            Thread.sleep(5000); // 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

