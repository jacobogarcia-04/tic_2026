package tic_2026;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BotIncidencias {

    public static void main(String[] args) {
        String webhook = "https://hook.eu1.make.com/lzc1y8q0a4ymzq9rvredjmmielbpplvo";

        String[] usuarios = {"Ana", "Luis", "Marta", "Carlos", "Elena", "Pablo"};
        String[] departamentos = {"IT", "RRHH", "Administracion", "Finanzas", "Marketing"};
        String[] prioridades = {"muy urgente", "urgente", "normal"};
        String[] problemas = {
                "No funciona el correo corporativo",
                "Error al iniciar sesion",
                "Impresora sin conexion",
                "No carga la aplicacion interna",
                "Fallo de red en el departamento",
                "Acceso denegado al sistema"
        };

        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            for (int i = 1; i <= 20; i++) {
                String fecha = LocalDateTime.now().format(formatter);
                String usuario = usuarios[random.nextInt(usuarios.length)];
                String departamento = departamentos[random.nextInt(departamentos.length)];
                String problema = problemas[random.nextInt(problemas.length)];
                String prioridad = prioridades[random.nextInt(prioridades.length)];
                String notificacion = "Pendiente";
                String estado = "Abierta";
                String idActividad = "ACT-" + System.currentTimeMillis() + "-" + i;

                String json = "{"
                        + "\"Fecha\":\"" + fecha + "\","
                        + "\"Usuario\":\"" + usuario + "\","
                        + "\"Departamento\":\"" + departamento + "\","
                        + "\"Problema\":\"" + problema + "\","
                        + "\"Prioridad\":\"" + prioridad + "\","
                        + "\"Notificacion\":\"" + notificacion + "\","
                        + "\"Estado\":\"" + estado + "\","
                        + "\"ID_actividad\":\"" + idActividad + "\""
                        + "}";

                URL url = new URL(webhook);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                conn.setDoOutput(true);

                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = json.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                int responseCode = conn.getResponseCode();
                System.out.println("Incidencia enviada " + i + " | Código: " + responseCode);
                System.out.println(json);

                conn.disconnect();

                Thread.sleep(1500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}