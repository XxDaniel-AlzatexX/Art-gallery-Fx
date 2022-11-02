package proyectoFx.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

public class FileUtils {
    private static final String[] CSV_HEADERS = {"nombre", "cedula", "fechaIngreso"};

//    public static void saveCSV(File salida, Map<Long, Empleado> empleados) throws IOException{
//        try (FileWriter archvioSalida = new FileWriter(salida);
//             CSVPrinter printer = new CSVPrinter(archvioSalida,CSVFormat.DEFAULT.withHeader(CSV_HEADERS))){
//            for(Empleado emp: empleados.values()){
//                printer.printRecord(emp.getNombre(), emp.getCedula(), emp.getFechaIngreso());
//            }
//        }
//    }
//
//    public static void loadCSV(File entrada, ControlGaleria controlador) throws IOException, DateTimeParseException, EmpleadoYaExisteException {
//        try(FileReader archivoEntrada = new FileReader(entrada);
//            CSVParser parser = new CSVParser(archivoEntrada, CSVFormat.DEFAULT.withFirstRecordAsHeader())){
//            List<CSVRecord> filas = parser.getRecords();
//            controlador.getEmpleados().clear();
//            for(CSVRecord registro: filas){
//                controlador.annadirEmpleado(
//                        registro.get("nombre"),
//                        Long.valueOf(registro.get("cedula")),
//                        LocalDate.parse(registro.get("fechaIngreso")));
//            }
//        }
//    }
//
//    public static void saveXML(File salida, ControladorEmpleados controladorEmpleados) throws IOException, JAXBException {
//        try(FileWriter archvioSalida = new FileWriter(salida)){
//            JAXBContext context = JAXBContext.newInstance(ControladorEmpleados.class);
//            Marshaller m = context.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            m.marshal(controladorEmpleados, archvioSalida);
//        }
//    }
//
//    public static ControladorEmpleados loadXML(File entrada) throws IOException, JAXBException {
//        try(FileReader archivoEntrada = new FileReader(entrada)){
//            return JAXB.unmarshal(archivoEntrada, ControladorEmpleados.class);
//        }
//    }
//
//    public static void saveJSON(File salida, ControladorEmpleados controladorEmpleados) throws IOException{
//        try(FileWriter archivoSalida = new FileWriter(salida)){
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoSalida, controladorEmpleados);
//        }
//    }
//
//    public static ControladorEmpleados loadJSON(File entrada) throws IOException{
//        try(FileReader archivoEntrada = new FileReader(entrada)){
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.readValue(archivoEntrada, ControladorEmpleados.class);
//        }
//    }
}
