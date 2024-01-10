package besu;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;

public class DecoderTest {
    
    @Test
    public void testDecodeSingleValue() {

        String expectedResult = "5";
        String data = "0x000000000000000000000000000000000000000000000000000000000000005";
        String functionName = "getData"; 
        Function function = new Function(
                functionName,
                Collections.<Type>emptyList(),
                Arrays.asList(new TypeReference<Uint>() {}));
        List<Type> decodedResult = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        assertEquals(expectedResult, decodedResult.get(0).getValue().toString());

    }
    @Test
    public void testDecodeMultipleValue() {
        String expectedResult = "9";
        String data = "0x000000000000000000000000000000000000000000000000000000000000005"+"0000000000000000000000000000000000000000000000000000000000000009"+"0000000000000000000000000000000000000000000000000000000000000004";
        String functionName = "getData"; 
        Function function = new Function(
                functionName,
                Collections.<Type>emptyList(),
                Arrays.asList(new TypeReference<Uint>() {}, new TypeReference<Uint>() {}, new TypeReference<Uint>() {}));
        List<Type> decodedResult = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        assertEquals(expectedResult, decodedResult.get(1).getValue().toString());
    }
}
