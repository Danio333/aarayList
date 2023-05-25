import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Procesos {
    ArrayList<String> nombres;
    ArrayList<Double> imc;

    public Procesos() {
        nombres = new ArrayList<>();
        imc = new ArrayList<>();
        llenarDatos();
        evaluarIMC();
        mostrarResultados();
    }

    private void llenarDatos() {
        boolean agregarPersona = true;

        while (agregarPersona) {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la persona");

            if (nombre == null || nombre.isEmpty()) {
                agregarPersona = false;
            } else {
                nombres.add(nombre);

                double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el peso de " + nombre));
                double talla = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la talla de " + nombre));
                double indiceMasaCorporal = calcularIMC(peso, talla);
                imc.add(indiceMasaCorporal);

                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otra persona?", "Confirmar", JOptionPane.YES_NO_OPTION);
                agregarPersona = (opcion == JOptionPane.YES_OPTION);
            }
        }
    }

    private double calcularIMC(double peso, double talla) {
        return peso / (talla * talla);
    }

    private void evaluarIMC() {
        for (int i = 0; i < nombres.size(); i++) {
            double indiceMasaCorporal = imc.get(i);
            imc.set(i, indiceMasaCorporal);
        }
    }

    private void mostrarResultados() {
        for (int i = 0; i < nombres.size(); i++) {
            String nombre = nombres.get(i);
            double indiceMasaCorporal = imc.get(i);
            String categoria = obtenerCategoriaIMC(indiceMasaCorporal);

            JOptionPane.showMessageDialog(null, "Persona: " + nombre + "\nIMC: " + indiceMasaCorporal + "\nCategoría: " + categoria);
        }
    }

    private String obtenerCategoriaIMC(double imc) {
        if (imc >= 40) {
            return "Obesidad Morbida";
        } else if (imc >= 35) {
            return "Obesidad grado 3";
        } else if (imc >= 30) {
            return "Obesidad grado 2";
        } else if (imc >= 27) {
            return "Obesidad grado 1";
        } else if (imc >= 20) {
            return "Normalidad";
        } else if (imc >= 18) {
            return "Delgadez";
        } else {
            return "Anorexia";
        }
    }
}
