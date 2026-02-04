package functional_interfaces;

interface ReportExporter {

    void exportCSV();
    void exportPDF();

    default void exportToJSON() {
        System.out.println("Exporting report in JSON format (default implementation)");
    }
}

class CSVExporter implements ReportExporter {

    public void exportCSV() {
        System.out.println("Report exported as CSV");
    }

    public void exportPDF() {
        System.out.println("PDF export not supported in CSVExporter");
    }
}

class PDFExporter implements ReportExporter {

    public void exportCSV() {
        System.out.println("CSV export not supported in PDFExporter");
    }

    public void exportPDF() {
        System.out.println("Report exported as PDF");
    }

    @Override
    public void exportToJSON() {
        System.out.println("Exporting report in JSON using PDFExporter logic");
    }
}

public class DataExportFeature {

    public static void main(String[] args) {

        ReportExporter csv = new CSVExporter();
        ReportExporter pdf = new PDFExporter();

        csv.exportCSV();
        csv.exportToJSON();

        System.out.println();

        pdf.exportPDF();
        pdf.exportToJSON();
    }
}
