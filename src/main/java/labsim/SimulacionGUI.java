package labsim;

import javax.swing.*;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            Estadisticas estadisticas = new Estadisticas();
            Motor motor = new Simulacion(TAMANIOSIMULACION, CreadorServidores.nServidoresUnicasColas(2), estadisticas, new CustomRandomizer(), new MultiplesServidores());
            motor.correr();

            outputTextArea.setText(estadisticas.toString(TAMANIOSIMULACION));
        }
    }
}