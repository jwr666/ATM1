import org.apache.log4j.Logger;

public class LogMysqlRun {

        private static Logger log=Logger.getLogger(LogMysqlRun.class);

        public static void main(String[] args) {
            log.debug("this is logger debug message");
            log.info("this is logger info message");

        }

}
