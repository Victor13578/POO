public class Paciente extends Persona {
    private String numeroHistorial;
    private String eps;
    private double saldoDisponible;
    private String sintoma;

    public Paciente(String nombre, String DNI, int edad, String genero, String numeroHistorial, String eps, double saldoDisponible, String sintoma) {
        super(nombre, DNI, edad, genero);
        this.numeroHistorial = numeroHistorial;
        this.eps = eps;
        this.saldoDisponible = saldoDisponible;
        this.sintoma = sintoma;
    }

    public String getEps() {
        return this.eps;
    }

    public String getSintoma() {
        return this.sintoma;
    }

    public void mostrarDatos() {
        System.out.println("[Paciente] " + this.nombre + " EPS: " + this.eps + " Sintoma: " + this.sintoma);
    }

    public void pagarConsulta(double costo) {
        System.out.print("El paciente " + this.nombre + " intenta pagar $" + costo + ". Saldo actual $" + this.saldoDisponible + " Resultado: ");
        if (this.saldoDisponible >= costo) {
            this.saldoDisponible -= costo;
            System.out.println("Éxito");
        } else {
            System.out.println("Rechazado");
        }

    }
}
