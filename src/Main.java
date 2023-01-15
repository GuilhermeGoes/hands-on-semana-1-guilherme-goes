import services.BillingService;
import utilities.FileUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        LOGGER.info("INICIANDO APLICAÇÃO");

        var service = new BillingService();
        service.execute();

        LOGGER.info("FINALIZANDO APLICAÇÃO");
    }
}