import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

public class MockTest {

    HttpQueryClass httpQueryClass;
    //String link = "https://api.gios.gov.pl/pjp-api/rest/station/findAll";

    @Before
    public void setUp() {
        System.out.println("Run setUp");
        httpQueryClass = Mockito.mock(HttpQueryClass.class);
    }

    @Test
    public void mockTestExample() {
        Mockito.when(httpQueryClass.query(any(), any())).thenReturn("test");

        ProcessQ processQuery = new ProcessQ(httpQueryClass);

        String result = processQuery.process("test param", "");
        assertThat(result).isEqualToIgnoringCase("TEST");
    }

}