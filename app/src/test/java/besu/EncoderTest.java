package besu;

import static org.junit.Assert.assertEquals;

import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.math.BigInteger;
import org.junit.Test;

public class EncoderTest {

    @Test
    public void testFunctionEncode() {

        String expectedResult = "0x2814957700000000000000000000000000000000000000000000000000000000000000010000000000000000000000001234567890123456789012345678901234567890";
        Function function = new Function(
                "abc",
                Arrays.asList(new Uint256(BigInteger.valueOf(1)), new Address("0x1234567890123456789012345678901234567890")),
                Collections.emptyList()
        );
        String encodedFunction = FunctionEncoder.encode(function);
        assertEquals(expectedResult, encodedFunction);
    }

    @Test
    public void testParameterEncode() {

        String expectedResult = "00000000000000000000000000000000000000000000000000000000000000010000000000000000000000001234567890123456789012345678901234567890";
        List<Type> parameters = Arrays.asList(new Uint256(BigInteger.valueOf(1)), new Address("0x1234567890123456789012345678901234567890"));
        String encodedParameter = FunctionEncoder.encodeConstructor(parameters);
        assertEquals(expectedResult, encodedParameter);
    }


    
}
