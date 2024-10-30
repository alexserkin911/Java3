package lesson4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public void sayHallo(){
        LOG.info("INFO");
        LOG.debug("DEBUG");
        int x = 3;
        LOG.debug("x = {}, list = {}", x, List.of("123", "34"));
    }
}
