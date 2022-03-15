import com.godeltech.task1.exception.InjectRandomValueException;
import com.godeltech.task1.processor.InjectRandomValueAnnotationProcessor;
import fixture.InjectRandomValueFixture;
import fixture.InjectRandomValueInvalidFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Test InjectRandomValueAnnotationProcessor")
public class InjectRandomValueAnnotationProcessorTest {
    private InjectRandomValueAnnotationProcessor injectRandomValueAnnotationProcessor;
    private InjectRandomValueFixture injectRandomValueFixture;

    @BeforeEach
    void init() {
        injectRandomValueAnnotationProcessor = new InjectRandomValueAnnotationProcessor();
        injectRandomValueFixture = new InjectRandomValueFixture();
    }

    @Test
    public void testInjectRandomBoolean() throws IllegalAccessException {
        Boolean isMarriedBeforeProcessing = injectRandomValueFixture.getIsMarried();

        injectRandomValueAnnotationProcessor.process(injectRandomValueFixture);
        Boolean isMarriedAfterProcessing = injectRandomValueFixture.getIsMarried();

        assertNull(isMarriedBeforeProcessing, "Should be null");
        assertNotNull(isMarriedAfterProcessing, "No field injection");
    }

    @Test
    public void testInjectRandomString() throws IllegalAccessException {
        String nameBeforeProcessing = injectRandomValueFixture.getName();

        injectRandomValueAnnotationProcessor.process(injectRandomValueFixture);
        String nameAfterProcessing = injectRandomValueFixture.getName();

        assertNull(nameBeforeProcessing, "Should be null");
        assertNotNull(nameAfterProcessing, "No field injection");
    }

    @Test
    public void testInjectRandomInteger() throws IllegalAccessException {
        Integer ageBeforeProcessing = injectRandomValueFixture.getAge();

        injectRandomValueAnnotationProcessor.process(injectRandomValueFixture);
        Integer ageAfterProcessing = injectRandomValueFixture.getAge();

        assertNull(ageBeforeProcessing, "Should be null");
        assertNotNull(ageAfterProcessing, "No field injection");
    }

    @Test
    public void testInvalidFieldType() {
        InjectRandomValueInvalidFixture injectRandomValueInvalidFieldFixture = new InjectRandomValueInvalidFixture();
        assertThrows(InjectRandomValueException.class, () -> injectRandomValueAnnotationProcessor.process(injectRandomValueInvalidFieldFixture), "Should throw exception");
    }
}
