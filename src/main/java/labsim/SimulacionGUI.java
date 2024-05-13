package labsim;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import labsim.recursos.*;
import labsim.motor.*;
import labsim.politicas.MultiplesServidores;

import java.awt.event.*;

public class SimulacionGUI extends JFrame implements ActionListener {

    private JButton startButton;
    private JTextArea outputTextArea;

    private static final float TAMANIOSIMULACION = 40320;

    /**
     * Constructor de la interfaz grafica, donde se definen todos los parametros.
     */
    public SimulacionGUI() {
        setTitle("Simulación GUI");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        startButton = new JButton("Iniciar Simulación");
        startButton.setBounds(120, 20, 160, 30);
        startButton.addActionListener(this);
        panel.add(startButton);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setBounds(20, 70, 700, 500);
        panel.add(scrollPane);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startButton.setEnabled(false);
            EstadisticasGenerales estadisticasGenerales = new EstadisticasGenerales();
            Thread simulationThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    // Ejecuta 50 veces la simulacion con distintas semillas
                    while (i<50) {
                        Estadisticas estadisticas = new Estadisticas();
                        Motor motor = new Simulacion(TAMANIOSIMULACION, CreadorServidores.nServidoresUnicasColas(2), estadisticas, new CustomRandomizer(), new MultiplesServidores());    
                        i++;
                        motor.correr();
                        recolectarDatos(estadisticas);
                        outputTextArea.setText(estadisticas.toString(TAMANIOSIMULACION));

                        try {
                            Thread.sleep(500); // Tiempo de duracion por ejecucion
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    estadisticasGenerales.calcularEstadisticasGeneral();
                    try {
                        mostrarDatos();
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }
                    startButton.setEnabled(true);
                }

                private void mostrarDatos() throws BadLocationException {
                    JTextPane infoTextPane = new JTextPane();
                    infoTextPane.setEditable(false);
                    StyledDocument doc = infoTextPane.getStyledDocument();
                    SimpleAttributeSet center = new SimpleAttributeSet();
                    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
                    doc.setParagraphAttributes(0, doc.getLength(), center, false);
                    doc.insertString(doc.getLength(), estadisticasGenerales.toString(), null);
                    JOptionPane.showMessageDialog(null, new JScrollPane(infoTextPane), "Información", JOptionPane.INFORMATION_MESSAGE);
                }

                private void recolectarDatos(Estadisticas estadisticas) {
                    estadisticasGenerales.agregarAvionesArribados(estadisticas.getCantidadAvionesArribados());
                    estadisticasGenerales.agregarAvionesAterrizados(estadisticas.getCantidadAvionesAterrizados());
                    estadisticasGenerales.agregarAvionesTransitoTotal(estadisticas.getTiempoTransito());
                    estadisticasGenerales.agregarAvionesTransitoMin(estadisticas.getTiempoMinTransito());
                    estadisticasGenerales.agregarAvionesTransitoMax(estadisticas.getTiempoMaxTransito());
                    estadisticasGenerales.agregarAvionesEsperaTotal(estadisticas.getTiempoEspera());
                    estadisticasGenerales.agregarAvionesEsperaMin(estadisticas.getTiempoMinEspera());
                    estadisticasGenerales.agregarAvionesEsperaMax(estadisticas.getTiempoMaxEspera());
                    estadisticasGenerales.agregarAvionesOcioTotal(estadisticas.getTiempoOcio());
                    estadisticasGenerales.agregarAvionesOcioMin(estadisticas.getTiempoMinOcio());
                    estadisticasGenerales.agregarAvionesOcioMax(estadisticas.getTiempoMaxOcio());
                    estadisticasGenerales.agregarAvionesColaMin(estadisticas.getMinCola());
                    estadisticasGenerales.agregarAvionesOcioMax(estadisticas.getMaxCola());
                }
            });

            simulationThread.start();            
        }
    }
}