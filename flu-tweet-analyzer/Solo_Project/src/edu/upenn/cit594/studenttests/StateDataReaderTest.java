package edu.upenn.cit594.studenttests;

import edu.upenn.cit594.datamanagement.StateDataReader;
import edu.upenn.cit594.util.State;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StateDataReaderTest {

    @Test
    public void testReadStates() {
        StateDataReader reader = new StateDataReader("states.csv");
        List<State> states = reader.readStates();
        assertNotNull(states); // Check that the list of states is not null
        assertEquals(51, states.size()); // Check that the list contains the expected number of states (50 states +
                                         // Washington DC)
    }
}
