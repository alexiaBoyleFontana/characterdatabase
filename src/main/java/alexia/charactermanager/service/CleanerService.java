package alexia.charactermanager.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
@NoArgsConstructor
@Service
public class CleanerService {

    public String clean (String value) {
        if (value != null) {
            value = value.replace("<", "");
            value = value.replace(">", "");
            value = value.replace("\"", "\'");
            value = value.replace("&", "");
        }

        return value;
    }
}
