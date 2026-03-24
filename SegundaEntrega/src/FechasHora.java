import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FechasHora {
    public static void main(String[] args) {
        System.out.println("*** Fechas ***");
        LocalDate fecha1 = LocalDate.now(); // hoy
        System.out.println("fecha1 = " + fecha1);

        LocalDate fechas2 = LocalDate.of(2000, 5, 30);
        System.out.println("fechas2 = " + fechas2);

        LocalDate fecha3 = LocalDate.parse("1999-12-31");
        System.out.println("fecha3 = " + fecha3);

        System.out.println("Año: " + fecha1.getYear());
        System.out.println("Mes: " + fecha1.getMonth());
        System.out.println("Dia: " + fecha1.getDayOfMonth());

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha4 = LocalDate.parse("12/03/2007", formato);
        System.out.println("fecha4 = " + fecha4.format(formato));

        System.out.println("*** Horas ***");
        LocalTime hora1 = LocalTime.now();
        System.out.println("hora1: " + hora1);

        LocalTime hora2 = LocalTime.of(5, 6, 7);
        System.out.println("hora2 = " + hora2);

        LocalTime hora3 = LocalTime.parse("12:13:14");
        System.out.println("hora3 = " + hora3);

        System.out.println("Hora " + hora1.getHour());
        System.out.println("Minuto " + hora2.getMinute());
        System.out.println("Seg: " + hora3.getSecond());

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora4 = LocalTime.parse("09:56", formatoHora);
        System.out.println("hora4 = " + hora4);
        System.out.println("Fecha 4 formateada: " + hora4.format(formatoHora));

        Date fechaDAte = new Date();

    }
}
