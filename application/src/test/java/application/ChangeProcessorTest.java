package application;

import application.domain.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import application.port.StateChangeDrivenPort;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ChangeProcessorTest {

    @Mock
    private StateChangeDrivenPort drivenPort;
    private ChangeProcessor underTest;

    @Before
    public void setUp() {
        underTest = new ChangeProcessor(drivenPort);
    }

    @Test
    public void coreTest() {
        UUID id = UUID.randomUUID();
        String type = "create";
        String content = "some content";

        Event event = Event.builder()
                .id(id)
                .type(type)
                .content(content)
                .create();

        underTest.receiveEvent(event);

        verify(drivenPort).sendEvent(event);
    }
}