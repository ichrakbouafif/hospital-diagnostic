

import com.hospital.diagnostic.HealthIndexProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealthIndexProcessorTest {
    @Test
    void process_ShouldReturnCardiology_ForCardiacCondition() {
        HealthIndexProcessor processor = new HealthIndexProcessor();
        String result = processor.process(33);
        assertEquals("Cardiologie", result);
    }

    @Test
    void process_ShouldReturnErrorMessage_WhenInvalidInput() {
        HealthIndexProcessor processor = new HealthIndexProcessor();
        String result = processor.process(-1);
        assertTrue(result.startsWith("Erreur:"));
    }

}
